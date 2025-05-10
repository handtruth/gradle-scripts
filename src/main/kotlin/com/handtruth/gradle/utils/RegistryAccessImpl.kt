package com.handtruth.gradle.utils

import org.gradle.api.model.ObjectFactory

abstract class RegistryAccessImpl(
    private val objects: ObjectFactory,
) : RegistryAccess {
    override fun <E> get(key: RegistryKey<E>): Registry<E> {
        return Registries.getRegistry(key, objects)
    }
}