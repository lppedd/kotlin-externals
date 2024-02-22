@file:JsModule("vscode-extension-tester")

package vscode.extension.tester.util

import seskar.js.JsValue
import seskar.js.JsVirtual

@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ReleaseQuality {
  companion object {
    @JsValue("stable")
    val Stable: ReleaseQuality

    @JsValue("insider")
    val Insider: ReleaseQuality
  }
}
