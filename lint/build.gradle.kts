@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import org.gradle.api.JavaVersion.VERSION_11

plugins { alias(libs.plugins.kotlin.jvm) }

java {
  sourceCompatibility = VERSION_11
  targetCompatibility = VERSION_11
}

dependencies {
  compileOnly(libs.lint.api)
  compileOnly(libs.kotlin.stdlib)

  testImplementation(libs.junit)
  testImplementation(libs.lint.core)
  testImplementation(libs.lint.tests)
}

tasks.withType<Jar>().configureEach {
  manifest.attributes["Lint-Registry-v2"] = "com.example.myapplication.lint.DLSIssueRegistry"
}
