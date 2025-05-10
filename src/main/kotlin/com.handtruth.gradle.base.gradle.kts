import java.io.File
import com.handtruth.gradle.utils.RegistryAccess
import com.handtruth.gradle.utils.RegistryAccessImpl

plugins {
    base
    id("org.gradlex.reproducible-builds")
}

apply(from = File(File(rootDir, "buildSrc"), "maven.gradle.kts"))

extensions.create(RegistryAccess::class, "registries", RegistryAccessImpl::class, objects)
