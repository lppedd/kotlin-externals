package com.github.lppedd.kotlin.gradle.services

import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters.None
import org.orienteer.jnpm.JNPMService
import org.orienteer.jnpm.JNPMSettings

/**
 * @author Edoardo Luppi
 */
abstract class NpmService : BuildService<None> {
  companion object {
    const val SERVICE_NAME: String = "npmService"
    const val NPM_REGISTRY: String = "https://registry.npmjs.org/"
  }

  init {
    if (!JNPMService.isConfigured()) {
      JNPMService.configure(
        JNPMSettings.builder()
          .registryUrl(NPM_REGISTRY)
          .useCache(true)
          .build()
      )
    }
  }

  fun retrieveVersions(packageName: String, versionContraint: String): List<String> {
    val service = JNPMService.instance()
    val versions = service.retrieveVersions(packageName, versionContraint)
    return versions
      .asSequence()
      .filter { it.isVersionValid && it.version.isStable }
      .map { it.versionAsString }
      .toList()
  }
}
