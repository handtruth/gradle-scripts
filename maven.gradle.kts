repositories {
    mavenCentral()
    maven(url = "https://maven.pkg.github.com/handtruth/maven") {
        name = "HandTruth"
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
    google()
}
