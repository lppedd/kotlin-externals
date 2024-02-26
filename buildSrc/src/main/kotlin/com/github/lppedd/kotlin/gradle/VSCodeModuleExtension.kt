package com.github.lppedd.kotlin.gradle

import com.github.lppedd.kotlin.gradle.ext.kmpExtension
import com.github.lppedd.kotlin.gradle.vscode.VSCodeExtension
import com.github.lppedd.kotlin.gradle.vscode.vscode
import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.register
import org.jetbrains.kotlin.gradle.targets.js.npm.npmProject

/**
 * @author Edoardo Luppi
 */
abstract class VSCodeModuleExtension(private val project: Project) {
  abstract val webViewsDir: DirectoryProperty

  fun packageJson(vscodeVersion: String = "^1.86.0", action: VSCodeExtension.() -> Unit) {
    project.kmpExtension.js {
      compilations.named("main").configure {
        packageJson {
          vscode(vscodeVersion, action)
        }

        if (webViewsDir.isPresent) {
          val copyWebviewsTask = project.tasks.register<Copy>("copyWebviews") {
            from(webViewsDir)
            into(npmProject.dir.get().dir("dist-webviews"))
          }

          project.tasks.named("jsNodeDevelopmentLibraryDistribution").configure {
            dependsOn(copyWebviewsTask)
          }
        }
      }
    }
  }
}
