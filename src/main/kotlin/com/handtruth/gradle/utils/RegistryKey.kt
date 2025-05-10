package com.handtruth.gradle.utils

import kotlin.reflect.KType

data class RegistryKey<E>(val name: String, val type: KType)
