@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.tso.doc.IStartStopResponse
import zowe.sdk.zos.tso.doc.input.IStopTsoParms
import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

/**
 * Stop active TSO address space using servlet key
 */
external class StopTso {
  companion object {
    /**
     * Sends REST call to z/OSMF for stoping active TSO address space
     * @param session z/OSMF connection info
     * @param commandParms object with required parameters, see [IStopTsoParms]
     * @return z/OSMF response object, see [IZosmfTsoResponse]
     */
    fun stopCommon(
      session: AbstractSession,
      commandParms: IStopTsoParms,
    ): Promise<IZosmfTsoResponse>

    /**
     * Stop TSO address space and populates response with IStartStopResponse, see [IStartStopResponse]
     * @param session
     * @param servKey unique servlet entry identifier
     * @return populated response, see [IStartStopResponse]
     */
    fun stop(
      session: AbstractSession,
      servKey: String,
    ): Promise<IStartStopResponse>

    /**
     * Generates query parameter needed for z/OSMF REST call
     * @param servletKey unique servlet entry identifier
     * @return generated resources query
     */
    fun getResources(servletKey: String): String
  }
}
