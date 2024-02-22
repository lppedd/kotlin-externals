@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.util

import js.promise.Promise

external class Download {
  companion object {
    fun getText(uri: String): Promise<String>

    fun getFile(
      uri: String,
      destination: String,
      progress: Boolean = definedExternally,
    ): Promise<Unit>
  }
}
