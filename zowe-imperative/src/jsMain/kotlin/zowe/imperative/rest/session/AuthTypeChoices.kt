@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.session

import seskar.js.JsValue
import seskar.js.JsVirtual

/**
 * Type that specifies the choice of authentication types
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface AuthTypeChoices {
  companion object {
    @JsValue("none")
    val none: AuthTypeChoices

    @JsValue("basic")
    val basic: AuthTypeChoices

    @JsValue("bearer")
    val bearer: AuthTypeChoices

    @JsValue("token")
    val token: AuthTypeChoices

    @JsValue("cert-pem")
    val certPem: AuthTypeChoices
  }
}
