plugins {
    id("com.handtruth.gradle.kotlin-jvm.library")
    id("com.handtruth.gradle.kapt")
}

dependencies {
    api("com.google.devtools.ksp:symbol-processing-api")
}
