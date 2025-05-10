plugins {
    id("com.handtruth.gradle.platform")
}

dependencies.constraints {
    mavenPublications.each { publication ->
        with(publication) {
            api("$groupId:$artifactId:$version")
        }
    }
}
