package com.github.lppedd.kotlin.gradle

import org.gradle.api.provider.Property
import org.gradle.api.provider.SetProperty

/**
 * @author Edoardo Luppi
 */
interface TsDeclarations {
  val packageName: Property<String>
  val basePath: Property<String>
  val includePattern: SetProperty<String>
  val excludePattern: SetProperty<String>
}
