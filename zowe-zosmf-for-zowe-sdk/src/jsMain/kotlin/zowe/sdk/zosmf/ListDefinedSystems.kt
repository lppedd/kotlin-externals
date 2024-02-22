@file:JsModule("@zowe/zosmf-for-zowe-sdk")

package zowe.sdk.zosmf

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zosmf.doc.IZosmfListDefinedSystemsResponse

/**
 * This class is used to list the systems defined to z/OSMF throgh the
 * z/OSMF APIs.
 */
external class ListDefinedSystems {
  companion object {
    /**
     * List systems defined to z/OSMF
     * @param session z/OSMF connection info.
     * @return A response contains information from API call.
     * @throws ImperativeError session must not be null or undefined. Any error threw by the REST API call.
     */
    fun listDefinedSystems(session: AbstractSession): Promise<IZosmfListDefinedSystemsResponse>
  }
}
