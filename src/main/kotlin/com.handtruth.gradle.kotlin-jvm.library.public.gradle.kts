plugins {
    id("com.handtruth.gradle.kotlin-jvm.library")
    id("org.jetbrains.dokka")
    id("org.jetbrains.dokka-javadoc")
}

kotlin {
    explicitApi()
}

documentable.register(path)

dokka {
    dokkaSourceSets.main {
        includes.from(layout.projectDirectory.file("documentation.md"))
    }
}

val javadocJar by tasks.registering(Jar::class) {
    group = "documentation"
    dependsOn(tasks.dokkaGeneratePublicationJavadoc)
    from(tasks.dokkaGeneratePublicationJavadoc.flatMap { it.outputDirectory })
    archiveClassifier = "javadoc"
}

java.withJavadocJar()
