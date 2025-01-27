// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.secrets.gradle.plugin)

    }
}

plugins {

    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    alias(libs.plugins.android.application) apply false
    id ("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin) apply false
}