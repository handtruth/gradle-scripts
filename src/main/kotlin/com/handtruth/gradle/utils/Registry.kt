package com.handtruth.gradle.utils

interface Registry<E> {
    fun register(element: E)

    fun each(action: (E) -> Unit)
}
