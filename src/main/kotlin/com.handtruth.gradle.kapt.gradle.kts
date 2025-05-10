plugins {
    id("com.handtruth.gradle.kotlin-jvm")
    id("org.jetbrains.kotlin.kapt")
}

dependencies {
    kapt(externalDependencies)
}
