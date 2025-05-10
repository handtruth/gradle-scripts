import com.handtruth.gradle.utils.Registry
import com.handtruth.gradle.utils.RegistryAccess
import com.handtruth.gradle.utils.RegistryKey
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.the
import kotlin.reflect.typeOf

fun Project.submodule(name: String) = project(":${rootProject.name}-$name")

inline fun <reified E> registryKey(name: String): RegistryKey<E> = RegistryKey(name, typeOf<E>())

inline operator fun <reified E> RegistryAccess.get(name: String): Registry<E> = get(registryKey(name))

val Project.mavenPublications: Registry<MavenPublication> get() = the<RegistryAccess>()["mavenPublications"]

val Project.coverable: Registry<String> get() = the<RegistryAccess>()["coverable"]

val Project.documentable: Registry<String> get() = the<RegistryAccess>()["documentable"]

val Project.externalDependencies: Dependency get() {
    val externalDependenciesVersion: String by project
    return dependencies.platform("com.handtruth.external:external-dependencies:$externalDependenciesVersion")
}
