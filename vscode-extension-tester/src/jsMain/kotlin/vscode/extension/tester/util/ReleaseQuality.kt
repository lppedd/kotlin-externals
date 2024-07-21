package vscode.extension.tester.util

import seskar.js.JsValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ReleaseQuality {
  companion object {
    @JsValue("stable")
    val Stable: ReleaseQuality

    @JsValue("insider")
    val Insider: ReleaseQuality
  }
}
