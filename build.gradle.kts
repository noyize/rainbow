@file:Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")

import org.jetbrains.changelog.date

plugins {
  alias(libs.plugins.android.application).apply(false)
  alias(libs.plugins.android.library).apply(false)
  alias(libs.plugins.kotlin.android).apply(false)
  alias(libs.plugins.dependencyguard).apply(false)
  alias(libs.plugins.kotlin.jvm).apply(false)
  alias(libs.plugins.spotless)
  alias(libs.plugins.kotlin.binaryCompat)
  alias(libs.plugins.changelog)
}

spotless {
  kotlin {
    target("**/*.kt")
    targetExclude("**/build/**")
    ktfmt(libs.versions.ktfmt.get()).googleStyle()
  }
  kotlinGradle {
    target("**/*.gradle.kts")
    targetExclude("**/build/**")
    ktfmt(libs.versions.ktfmt.get()).googleStyle()
  }
}

apiValidation {
  ignoredProjects.addAll(arrayOf("playground"))
  ignoredPackages.addAll(arrayOf("com.example.rainbow.databinding"))
}

changelog {
  header.set("[${project.version as String}] - ${date("yyyy-MM-dd")}")
  lineSeparator.set("\n")
  itemPrefix.set("-")
  keepUnreleasedSection.set(true)
  unreleasedTerm.set("[Unreleased]")
  groups.set(setOf("Added", "Changed", "Deprecated", "Removed", "Fixed"))
}
