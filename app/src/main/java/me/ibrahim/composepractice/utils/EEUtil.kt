package me.ibrahim.composepractice.utils

import android.annotation.SuppressLint
import android.os.Build
import android.security.KeyPairGeneratorSpec
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import me.ibrahim.composepractice.ComposePracticeApp
import java.math.BigInteger
import java.security.Key
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.PrivateKey
import java.util.Calendar
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.security.auth.x500.X500Principal

object EEUtil {

    private const val SYMMETRIC_KEY_ALIAS = "singleKeyForAES"
    private const val ASYMMETRIC_KEY_ALIAS = "keyPairForRSA"
    private const val KEYSTORE_TYPE = "AndroidKeyStore"
    private const val RSA_ALGORITHIM = "RSA"
    private const val AES_ALGORITHIM = "AES"

    private const val TRANSFORMATION_ASYMMETRIC = "$RSA_ALGORITHIM/${KeyProperties.BLOCK_MODE_ECB}/PKCS1Padding"
    private const val TRANSFORMATION_SYMMETRIC = "$AES_ALGORITHIM/${KeyProperties.BLOCK_MODE_CBC}/${KeyProperties.ENCRYPTION_PADDING_PKCS7}"


    private val keyStore: KeyStore = createAndroidKeyStore()
    val asymmetricKey: KeyPair = createKeyPair()
    val symmetricKey: SecretKey = createSymmetricKey()

    //Create & load KeyStore (AndroidKeyStore)
    private fun createAndroidKeyStore(): KeyStore {
        val keyStore = KeyStore.getInstance(KEYSTORE_TYPE)
        keyStore.load(null)
        return keyStore
    }


    //get keys previously stored in key store.
    fun getPublicAndPrivateKeysFromKeyStore(): KeyPair? {
        val privateKey = keyStore.getKey(ASYMMETRIC_KEY_ALIAS, null) as? PrivateKey
        val publicKey = keyStore.getCertificate(ASYMMETRIC_KEY_ALIAS).publicKey

        return if (publicKey != null && privateKey != null)
            KeyPair(publicKey, privateKey)
        else null
    }

    //get AES symmetric key from android key store.
    fun getAESKeyFromKeyStore(): SecretKey? {
        val secretKey = keyStore.getKey(SYMMETRIC_KEY_ALIAS, null) as? SecretKey
        return secretKey
    }

    //this will create KeyPair (public & private keys for RSA algorithms)
    @SuppressLint("ObsoleteSdkInt")
    private fun createKeyPair(): KeyPair {
        val keyGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHIM, KEYSTORE_TYPE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            initWithKeyGenParameterSpec(keyGenerator, ASYMMETRIC_KEY_ALIAS)
        } else {
            initWithKeyPairGeneratorSpec(keyGenerator, ASYMMETRIC_KEY_ALIAS)
        }

        // Generates Key with given spec and also saves it to the KeyStore
        //* In Android Key Store provider, this method will automatically save key in KeyStore
        return keyGenerator.generateKeyPair()
    }


    fun createSymmetricKey(): SecretKey {
        val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, KEYSTORE_TYPE)
        val builder = KeyGenParameterSpec.Builder(SYMMETRIC_KEY_ALIAS, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
            .setKeySize(256)

        keyGenerator.init(builder.build())
        return keyGenerator.generateKey()
    }

    //region initialize KeyPairGenerator
    //before Marshmallow
    private fun initWithKeyPairGeneratorSpec(keyGenerator: KeyPairGenerator, alias: String) {
        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.YEAR, 40)

        val builder = KeyPairGeneratorSpec.Builder(ComposePracticeApp.instance)
            .setAlias(alias)
            .setSubject(X500Principal("CN:$alias CA Certificate"))
            .setSerialNumber(BigInteger.ONE)
            .setStartDate(startDate.time)
            .setEndDate(endDate.time)
        keyGenerator.initialize(builder.build())
    }

    //after Marshmallow
    private fun initWithKeyGenParameterSpec(keyGenerator: KeyPairGenerator, alias: String) {
        val builder = KeyGenParameterSpec.Builder(alias, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
        keyGenerator.initialize(builder.build())
    }

    //endregion


    fun encrypt(plainData: String, key: Key): String {
        val cipher = Cipher.getInstance(TRANSFORMATION_ASYMMETRIC)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val bytes = cipher.doFinal(plainData.toByteArray())
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

    fun decrypt(encryptedData: String, key: Key): String {
        val cipher = Cipher.getInstance(TRANSFORMATION_ASYMMETRIC)
        cipher.init(Cipher.DECRYPT_MODE, key)
        val bytes = Base64.decode(encryptedData, Base64.DEFAULT)
        val data = cipher.doFinal(bytes)
        return String(data)
    }


    //region Key Wrapping
    // encrypting AES key to be stored locally or transfer is called key wrapping
    fun wrapKey(keyToBeWraped: Key, keyToWrapWith: Key): String {
        val cipher = Cipher.getInstance(TRANSFORMATION_ASYMMETRIC)
        cipher.init(Cipher.WRAP_MODE, keyToWrapWith)
        val wrappedKey = cipher.wrap(keyToBeWraped)
        return Base64.encodeToString(wrappedKey, Base64.DEFAULT)
    }

    fun unWrapKey(wrappedKey: String, algorithm: String, wrappedKeyType: Int, keyToUnWrapWith: Key) {
        val cipher = Cipher.getInstance(TRANSFORMATION_ASYMMETRIC)
        cipher.init(Cipher.UNWRAP_MODE, keyToUnWrapWith)
        val wrappedKeyBytes = Base64.decode(wrappedKey, Base64.DEFAULT)
        val unWrappedKey = cipher.unwrap(wrappedKeyBytes, algorithm, wrappedKeyType)
    }
    //endregion

    fun encryptAES(plainData: String, key: Key): String {
        val cipher = Cipher.getInstance(TRANSFORMATION_SYMMETRIC)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val iv = cipher.iv
        val encryptedData = cipher.doFinal(plainData.toByteArray())
        val ivStr = Base64.encodeToString(iv, Base64.DEFAULT)
        val dataStr = Base64.encodeToString(encryptedData, Base64.DEFAULT)
        return "$ivStr:$dataStr"
    }

    fun decryptAES(base64EncodedData: String, key: Key): String {
        val cipher = Cipher.getInstance(TRANSFORMATION_SYMMETRIC)
        val dataParts = base64EncodedData.split(":")
        val ivStr = dataParts[0]
        val iv = IvParameterSpec(Base64.decode(ivStr, Base64.DEFAULT))

        cipher.init(Cipher.DECRYPT_MODE, key, iv)

        val dataStr = dataParts[1]
        val encodedBytes = Base64.decode(dataStr, Base64.DEFAULT)
        val decodedBytes = cipher.doFinal(encodedBytes)
        return String(decodedBytes)
    }
}