plugins {
    id("com.handtruth.gradle.publishing")
    `java-platform`
}

publishing {
    publications {
        create<MavenPublication>("main") {
            from(components["javaPlatform"])
        }
    }
}
