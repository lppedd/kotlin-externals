package com.github.lppedd.kotlin.gradle

import com.github.lppedd.kotlin.gradle.ext.booleanProperty
import com.github.lppedd.kotlin.gradle.ext.mavenRepositoryName
import com.github.lppedd.kotlin.gradle.ext.mavenRepositoryUrl
import com.vanniktech.maven.publish.MavenPublishPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.apply

/**
 * @author Edoardo Luppi
 */
class PublishableModulePlugin : Plugin<Project> {
  private companion object {
    private const val SNAPSHOT_SUFFIX = "-SNAPSHOT"
  }

  override fun apply(project: Project) {
    project.apply<MavenPublishPlugin>()
    project.afterEvaluate {
      if (project.booleanProperty("version.snapshot")) {
        val version = project.version.toString()

        if (!version.endsWith(SNAPSHOT_SUFFIX)) {
          project.version = version + SNAPSHOT_SUFFIX
        }
      }
    }

    // Allow publishing to a private Maven repository, other than to Maven Central
    val privateRepoUrl = project.mavenRepositoryUrl

    if (privateRepoUrl != null) {
      project.extensions.configure<PublishingExtension>("publishing") {
        repositories {
          maven {
            name = project.mavenRepositoryName ?: "PrivateNexus"
            url = project.uri(privateRepoUrl)
            isAllowInsecureProtocol = true
          }
        }
      }
    }
  }
}
