package me.ibrahim.composepractice

import android.app.Application
import androidx.compose.runtime.compositionLocalOf


val LocalMyName = compositionLocalOf { "" }

class ComposePracticeApp : Application() {
    override fun onCreate() {
        super.onCreate()
//        Gravatar.initialize(BuildConfig.GRAVATAR_API_KEY)
    }
}