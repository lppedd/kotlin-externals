package com.github.lppedd.kotlin.gradle.tasks

import org.gradle.api.tasks.Copy

/**
 * @author Edoardo Luppi
 */
abstract class CopyTsDeclarationsTask : Copy() {
  companion object {
    const val TASK_NAME: String = "copyTsDeclarations"
  }
}
