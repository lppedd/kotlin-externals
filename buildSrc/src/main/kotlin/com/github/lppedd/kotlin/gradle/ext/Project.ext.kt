package com.github.lppedd.kotlin.gradle.ext

import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

val Project.npmName: String
  get() {
    val str = stringProperty(name)
    val (npmName, _) = str.split(':')
    return npmName
  }

val Project.npmVersion: String
  get() {
    val str = stringProperty(name)
    val (_, npmVersion) = str.split(':')
    return npmVersion
  }

/**
 * Returns the Kotlin Multiplatform project extension.
 */
val Project.kmpExtension: KotlinMultiplatformExtension
  get() = extensions.getByType()

/**
 * Returns a project property as a string.
 */
fun Project.stringProperty(name: String): String =
  property(name) as String

/**
 * Returns a project property as a string, or `null` if the property is not found.
 */
fun Project.stringPropertyOrNull(name: String): String? =
  findProperty(name) as? String

/**
 * Returns a project property as a boolean (`"true" == true`, else `false`).
 */
fun Project.booleanProperty(name: String): Boolean =
  (findProperty(name) as? String)?.trim()?.lowercase() == "true"
