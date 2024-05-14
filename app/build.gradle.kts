plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
    id ("com.google.gms.google-services")
    id ("com.google.firebase.crashlytics")
}

android {
    namespace = "com.cuin.shopifyke"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cuin.shopifyke"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    implementation(libs.androidx.core.ktx.v1101)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.activity.compose.v172)
    implementation(platform(libs.androidx.compose.bom.v20240500))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.androidx.material)

// Lifecycle components

// viewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
// viewModel utilities for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
// LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

    implementation(libs.androidx.runtime.livedata)

// Lifecycles only (without viewModel or LiveData)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.appcompat)
    implementation(libs.firebase.auth)

// Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom.v20230300))
    androidTestImplementation(libs.ui.test.junit4)

// Preview
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

// Navigation Component
    implementation(libs.androidx.navigation.compose)


// Firebase
    implementation(libs.firebase.messaging.ktx)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.firebase.crashlytics.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.auth.ktx)

// WorkManager
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.androidx.work.gcm)

// Retrofit
    implementation(libs.retrofit)

// Retrofit with Moshi Converter
    implementation(libs.converter.moshi)

// OkHttp
    implementation(libs.okhttp)

// Moshi
    implementation(libs.moshi.kotlin)

// Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    annotationProcessor(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

// Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    annotationProcessor(libs.androidx.room.compiler)
    kapt("androidx.room:room-compiler:2.6.1")


// JWT
    implementation(libs.kjwt.core)
    implementation(libs.kjwt.jwks)
    implementation(libs.arrow.core)

// Lottie
    implementation(libs.lottie.compose)

//Coil
    implementation(libs.coil.compose)

}
kapt {
    correctErrorTypes = true
}