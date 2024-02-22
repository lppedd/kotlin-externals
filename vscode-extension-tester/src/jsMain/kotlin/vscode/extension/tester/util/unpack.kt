@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.util

import js.promise.Promise
import node.fs.PathLike

external class Unpack {
  companion object {
    fun unpack(
      input: PathLike,
      target: PathLike,
    ): Promise<Unit>
  }
}
