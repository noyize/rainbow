@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

plugins {
  id("com.android.application")
  kotlin("android")
  alias(libs.plugins.firebase.appdistribution)
}

android {
  namespace = "com.example.rainbow.playground"
  compileSdk = 33

  defaultConfig {
    applicationId = "com.example.rainbow.playground"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes { getByName("release") { isMinifyEnabled = false } }

  if (System.getenv("RELEASE_SIGNING_ENABLED") == "true") {
    signingConfigs {
      register("release") {
        keyAlias = System.getenv("KEY_ALIAS")
        keyPassword = System.getenv("KEY_PASSWORD")
        storeFile = rootProject.file(System.getenv("STORE_FILE"))
        storePassword = System.getenv("STORE_PASSWORD")
      }
    }
    buildTypes.getByName("release").signingConfig = signingConfigs.getByName("release")
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      // proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
      // "proguard-rules.pro")
      firebaseAppDistribution {
        artifactType = "APK"
        appId = "" // Todo: Create app in your firebase project & add App ID here
        // Todo: Make sure to onboard your app by pressing the "Get started" button on the App
        // Distribution page in the Firebase console:
        // https://console.firebase.google.com/project/_/appdistribution
      }
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  viewBinding.enable = true
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions { jvmTarget = JavaVersion.VERSION_11.toString() }
}

dependencies {
  implementation(projects.lib)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.kotlin.stdlib)
  implementation(libs.android.material)
}
