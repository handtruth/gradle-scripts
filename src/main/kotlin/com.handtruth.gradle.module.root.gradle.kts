plugins {
    id("com.handtruth.gradle.base")
    id("org.jetbrains.kotlinx.kover")
    id("org.jetbrains.dokka")
    id("org.jetbrains.dokka-javadoc")
}

dependencies {
    coverable.each { kover(project(it)) }
    documentable.each { dokka(project(it)) }
}
