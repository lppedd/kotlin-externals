@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.auth

import js.objects.Record

/**
 * Class for various logout constants.
 */
external class LogoutConstants {
  companion object {
    /**
     * URI base jobs API
     */
    val APIML_V1_RESOURCE: String

    /**
     * Zowe Token Expired Error Code
     */
    val APIML_V1_TOKEN_EXP_ERR: String

    /**
     * Zowe Token Expired Error Codes
     */
    val APIML_V2_LOGOUT_ERR_LIST: Record<String, String>
  }
}
