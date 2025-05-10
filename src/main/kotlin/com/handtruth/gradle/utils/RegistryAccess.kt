package com.handtruth.gradle.utils

interface RegistryAccess {
    operator fun <E> get(key: RegistryKey<E>): Registry<E>
}
