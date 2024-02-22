@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.session

import seskar.js.JsValue
import seskar.js.JsVirtual

/**
 * Type that specifies the choice of token types
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface TokenTypeChoices {
  companion object {
    @JsValue("LtpaToken2")
    val LtpaToken2: AuthTypeChoices

    @JsValue("jwtToken")
    val jwtToken: AuthTypeChoices

    @JsValue("apimlAuthenticationToken")
    val apimlAuthenticationToken: AuthTypeChoices
  }
}
