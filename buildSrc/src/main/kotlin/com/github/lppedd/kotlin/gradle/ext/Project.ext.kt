package com.github.lppedd.kotlin.gradle.ext

import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

val Project.npmName: String
  get() = stringProperty("$name.name")

val Project.npmVersion: String
  get() = stringProperty("$name.version")

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
