import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "me.ibrahim.composepractice"
    compileSdk = 34

    buildFeatures.buildConfig = true

    val properties = Properties()
    properties.load(FileInputStream(project.rootProject.file("local.properties")))

    defaultConfig {
        applicationId = "me.ibrahim.composepractice"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField("String", "GR_AVATAR", "\"${project.properties["GRAVATAR_API_KEY"]}\"")
        buildConfigField("String", "GRAVATAR_API_KEY", "\"${properties["gravatar.api.key"]}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        debug {
            isDebuggable = false
        }

    }

    flavorDimensions += "version"
    productFlavors {
        create("free") {
            dimension = "version"
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"

        }
        create("paid") {
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"
            dimension = "version"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.adaptive.layout.android)
    implementation( libs.androidx.constraintlayout.compose)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.material.icons.extended)
    implementation(libs.compose.charts)

    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.navigation.compose)

    //coil - image loading
    implementation(libs.coil.compose)


    //junit
    testImplementation(libs.junit)
    //truth assertion library for assertion
    testImplementation(libs.truth)
    androidTestImplementation(libs.truth)


    // Room components
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)           // For annotation processing (Kotlin)

    // Optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    // Optional - Test helpers
    // For LiveData testing
    testImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.androidx.core.testing)
//    testImplementation("androidx.room:room-testing:2.6.1")

    //Retrofit 2 & gson convertor
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation("androidx.compose.material3.adaptive:adaptive")
    implementation("androidx.compose.material3.adaptive:adaptive-layout")
    implementation("androidx.compose.material3.adaptive:adaptive-navigation")
}