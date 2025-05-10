package com.handtruth.gradle.utils

import org.gradle.api.model.ObjectFactory
import org.gradle.kotlin.dsl.domainObjectSet
import kotlin.reflect.jvm.jvmErasure

object Registries {
    private val registries: MutableMap<RegistryKey<*>, Registry<*>> = hashMapOf()

    fun <E> getRegistry(key: RegistryKey<E>, objects: ObjectFactory): Registry<E> {
        @Suppress("UNCHECKED_CAST")
        return registries.getOrPut(key) {
            val container = objects.domainObjectSet(key.type.jvmErasure)
            RegistryImpl(container)
        } as Registry<E>
    }
}
