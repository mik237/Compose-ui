package me.ibrahim.composepractice

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.compositionLocalOf
import me.ibrahim.composepractice.utils.EEUtil


val LocalMyName = compositionLocalOf { "" }

class ComposePracticeApp : Application() {


    companion object {
        lateinit var instance: ComposePracticeApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this


        val message = "Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* Hello Ibrahim* "

        // example of encrypting/decrypting using RSA algorithm
        val keyPair = EEUtil.getPublicAndPrivateKeysFromKeyStore()
        keyPair?.let {
            val encrypted = EEUtil.encrypt(message, it.public)
            Log.d("_keys_", "Encrypted: $encrypted")
            Log.d("_keys_", "Decrypted: ${EEUtil.decrypt(encrypted, it.private)}")
        }
    }
}