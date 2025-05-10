import java.util.Properties

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

apply(from = "maven.gradle.kts")

val projectProperties = Properties()
layout.projectDirectory.file("../gradle.properties").asFile.reader().use(projectProperties::load)

dependencies {
    val externalDependenciesVersion = projectProperties.getProperty("externalDependenciesVersion")
    implementation(platform("com.handtruth.external:external-dependencies:$externalDependenciesVersion"))

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("org.jetbrains.kotlin:kotlin-serialization")
    implementation("org.jetbrains.kotlin:kotlin-allopen")
    implementation("org.jetbrains.kotlin:kotlin-noarg")
    implementation("org.jetbrains.kotlin:kotlin-lombok")
    implementation("org.jetbrains.kotlin:kotlin-power-assert")
    implementation("org.jetbrains.kotlinx:kover-gradle-plugin")
    implementation("org.jetbrains.kotlinx:atomicfu-gradle-plugin")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin")
    implementation("com.google.devtools.ksp:symbol-processing-gradle-plugin")
    implementation("org.gradlex:reproducible-builds")
    implementation("org.jmailen.gradle:kotlinter-gradle")
    implementation("info.solidsoft.gradle.pitest:gradle-pitest-plugin")
}
