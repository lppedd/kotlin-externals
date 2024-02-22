@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.session

import seskar.js.JsValue
import seskar.js.JsVirtual

/**
 * Type that specifies the choice of protocols
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface HttpProtocolChoices {
  companion object {
    @JsValue("http")
    val http: HttpProtocolChoices

    @JsValue("https")
    val https: HttpProtocolChoices
  }
}
