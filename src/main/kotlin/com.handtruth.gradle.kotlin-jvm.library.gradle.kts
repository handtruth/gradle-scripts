plugins {
    id("com.handtruth.gradle.publishing")
    id("com.handtruth.gradle.kotlin-jvm")
}

java.withSourcesJar()

publishing {
    publications {
        val publication = create<MavenPublication>("main") {
            from(components["java"])
        }
        mavenPublications.register(publication)
    }
}
