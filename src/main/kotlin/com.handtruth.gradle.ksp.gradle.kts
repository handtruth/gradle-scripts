plugins {
    id("com.handtruth.gradle.kotlin-jvm")
    id("com.google.devtools.ksp")
}

dependencies {
    ksp(externalDependencies)
}
