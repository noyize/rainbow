@file:Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")

plugins {
  id("com.android.library")
  kotlin("android")
  alias(libs.plugins.dependencyguard)
  id("maven-publish")
}

apply(from = rootProject.file("tools/install-git-hooks.gradle"))

dependencyGuard {
  configuration("releaseRuntimeClasspath") {
    modules = false
    tree = true
  }
}

android {
  namespace = "com.example.rainbow"
  compileSdk = 33
  
  defaultConfig {
    minSdk = 24   
    targetSdk = 33       
  }
  
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }
  
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  
  buildFeatures { viewBinding = true }
  
  sourceSets {
    // Note: Add component source sets
    val srcDirs =
      arrayOf(
        "com/example/rainbow/theme",
        "com/example/rainbow/typography",
      )
    val buildTypes = arrayOf("main", "debug")

    buildTypes.forEach { type ->
      srcDirs.forEach { srcDir ->
        getByName(type).res.srcDir("src/$type/java/$srcDir/res")
        getByName(type).res.srcDir("src/$type/java/$srcDir/res-public")
      }
    }
    getByName("main").res.srcDirs("src/main/res-public")
  }
  
  publishing {
    singleVariant("release") {
      withJavadocJar()
      withSourcesJar()
    }
  }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions { jvmTarget = JavaVersion.VERSION_11.toString() }
}

publishing {
  publications {
    register<MavenPublication>("release") {
      groupId = providers.gradleProperty("publishing.groupId").get()
      artifactId = providers.gradleProperty("publishing.artifactId").get()
      version = providers.gradleProperty("publishing.version").get()

      afterEvaluate { from(components["release"]) }
    }
  }
  
  repositories {
    maven {
      name = "GitHubPackages"
      // TODO: Update org and repo name in the maven link
      url = uri("https://maven.pkg.github.com/OWNER/REPOSITORY")
      credentials {
        // TODO: Add the properties for githubPackagesUser and githubPackagesPassword
        username = providers.gradleProperty("githubPackagesUser").getOrElse(System.getenv("GH_USERNAME"))
        password = providers.gradleProperty("githubPackagesPassword").getOrElse(System.getenv("GH_TOKEN"))
      }
    }
  }
}

dependencies {
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.android.material)
  implementation(libs.kotlin.stdlib)
  
  lintChecks(projects.lint)
  lintPublish(projects.lint)
}

