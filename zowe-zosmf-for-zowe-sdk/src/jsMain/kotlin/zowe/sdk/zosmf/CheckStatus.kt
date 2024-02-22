@file:JsModule("@zowe/zosmf-for-zowe-sdk")

package zowe.sdk.zosmf

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zosmf.doc.IZosmfInfoResponse

/**
 * This class holds the helper functions that are used to gather zosmf information throgh the
 * z/OSMF APIs.
 */
external class CheckStatus {
  companion object {
    /**
     * Get z/OSMF information
     * @param session z/OSMF connection info.
     * @return A response contains information from API call.
     * @throws ImperativeError session must not be null or undefined. Any error threw by the REST API call.
     */
    fun getZosmfInfo(session: AbstractSession): Promise<IZosmfInfoResponse>
  }
}
