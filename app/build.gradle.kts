plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.aulia_core"
    compileSdk = 36  // ← DIPERBAIKI: langsung angka, bukan function

    defaultConfig {
        applicationId = "com.example.aulia_core"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Core Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Material Design
    implementation("com.google.android.material:material:1.9.0")

    // CardView
    implementation("androidx.cardview:cardview:1.0.0")

    // GridLayout
    implementation("androidx.gridlayout:gridlayout:1.0.0")

    // ========== TAMBAHKAN INI UNTUK GLIDE ==========
    // Glide untuk load gambar dari URL (Custom Adapter)
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
}