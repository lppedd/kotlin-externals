package com.github.lppedd.kotlin.gradle.tasks

import com.github.lppedd.kotlin.gradle.ExternalsModulePlugin
import com.github.lppedd.kotlin.gradle.ext.stringProperty
import com.github.lppedd.kotlin.gradle.services.NpmService
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.services.ServiceReference
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.hasPlugin

/**
 * @author Edoardo Luppi
 */
abstract class CheckNpmVersionTask : DefaultTask() {
  companion object {
    const val TASK_NAME: String = "checkNpmVersion"
  }

  @ServiceReference(NpmService.SERVICE_NAME)
  abstract fun getNpmService(): Property<NpmService>

  @TaskAction
  fun checkAllVersions() {
    if (project.plugins.hasPlugin(ExternalsModulePlugin::class)) {
      checkProjectVersions(project, getNpmService().get())
    }
  }

  private fun checkProjectVersions(project: Project, npmService: NpmService) {
    val projectName = project.name
    val (npmName, npmVersion) = project.stringProperty(projectName).split(':')
    val versions = npmService.retrieveVersions(npmName, ">$npmVersion")

    if (versions.isEmpty()) {
      logger.lifecycle("The npm package is up-to-date")
    } else {
      logger.warn("[Outdated] New versions: ${versions.joinToString()}")
    }
  }
}
