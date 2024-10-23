package me.ibrahim.composepractice

import android.app.Application
import android.content.Context
import android.security.keystore.KeyProperties
import android.util.Log
import androidx.compose.runtime.compositionLocalOf
import me.ibrahim.composepractice.utils.EEUtil
import java.security.Security
import javax.crypto.Cipher


val LocalMyName = compositionLocalOf { "" }

class ComposePracticeApp : Application() {


    companion object {
        lateinit var instance: ComposePracticeApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this


        val message = "Hello Ibrahim* Hello Ibrahim* "

        // example of encrypting/decrypting using RSA algorithm
        val keyPair = EEUtil.getPublicAndPrivateKeysFromKeyStore()
        keyPair?.let {
            val encrypted = EEUtil.encrypt(message, it.public)
            Log.d("_keys_", "Encrypted: $encrypted")
            Log.d("_keys_", "Decrypted: ${EEUtil.decrypt(encrypted, it.private)}")
        }


        // example of encrypting/decrypting using AES algorithm
        val secretKey = EEUtil.getAESKeyFromKeyStore()
        secretKey?.let { key ->

            //Key wrapping & un-wrapping
    //            Log.d("_keys_", "AES_KEY_UNWRAPPED: ${secretKey.toString()}")
    //            val wrappedAESKey = EEUtil.wrapKey(key, keyPair!!.public)
    //            Log.d("_keys_", "AES_KEY_WRAPPED: $wrappedAESKey")
    //            Log.d(
    //                "_keys_",
    //                "AES_KEY_UNWRAPPED: ${EEUtil.unWrapKey(wrappedAESKey, KeyProperties.KEY_ALGORITHM_AES, Cipher.SECRET_KEY, keyPair.private)}"
    //            )


            val encryptedAES = EEUtil.encryptAES(message, key)
            Log.d("_keys_", "Encrypted AES: $encryptedAES")
            Log.d("_keys_", "Decrypted AES: ${EEUtil.decryptAES(encryptedAES, key)}")

        }
    }
}