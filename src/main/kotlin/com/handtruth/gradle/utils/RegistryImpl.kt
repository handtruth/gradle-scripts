package com.handtruth.gradle.utils

import org.gradle.api.DomainObjectSet

internal class RegistryImpl<E>(private val container: DomainObjectSet<E>) : Registry<E> {
    override fun register(element: E) {
        container.add(element)
    }

    override fun each(action: (E) -> Unit) {
        container.all(action)
    }
}
