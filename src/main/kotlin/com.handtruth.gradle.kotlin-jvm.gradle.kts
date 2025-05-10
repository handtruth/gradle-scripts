import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    id("com.handtruth.gradle.base")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlinx.kover")
    id("org.jmailen.kotlinter")
}

kotlin {
    jvmToolchain(21)
}

tasks {
    test {
        useJUnitPlatform()

        testLogging {
            exceptionFormat = TestExceptionFormat.FULL
        }
    }

    withType<LintTask> {
        source = source.minus(fileTree("src/generated")).asFileTree
        source = source.minus(fileTree("build/generated-sources")).asFileTree
        source = source.minus(fileTree("build/generated")).asFileTree
    }

    withType<FormatTask> {
        source = source.minus(fileTree("src/generated")).asFileTree
        source = source.minus(fileTree("build/generated-sources")).asFileTree
        source = source.minus(fileTree("build/generated")).asFileTree
    }
}

coverable.register(path)

dependencies {
    val externalDependencies = externalDependencies
    implementation(externalDependencies)
    runtimeOnly(externalDependencies)
    compileOnly(externalDependencies)
    ktlint(externalDependencies)

    testImplementation("io.kotest:kotest-assertions-core-jvm")
    testImplementation("io.kotest:kotest-property-jvm")
    testImplementation("io.kotest:kotest-framework-engine-jvm")
    testRuntimeOnly("io.kotest:kotest-runner-junit5-jvm")
}
