@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.tso.doc.ICollectedResponses
import zowe.sdk.zos.tso.doc.ISendResponse
import zowe.sdk.zos.tso.doc.input.ISendTsoParms
import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

/**
 * Class to handle sending data to TSO
 */
external class SendTso {
  companion object {
    /**
     * API method to send data to already started TSO address space, but will read TSO data until a PROMPT is reached.
     * @param session z/OSMF connection info
     * @param servletKey servlet key returned from a successful start
     * @param data data to send to the TSO address space.
     * @return SendTso response object, see [ISendResponse]
     */
    fun sendDataToTSOCollect(
      session: AbstractSession,
      servletKey: String,
      data: String,
    ): Promise<ISendResponse>

    /**
     * API method to send data to already started TSO address space
     * @param session z/OSMF connection info
     * @param commandParams object with required parameters, see [ISendTsoParms]
     * @return z/OSMF response object, see [IZosmfTsoResponse]
     */
    fun sendDataToTSOCommon(
      session: AbstractSession,
      commandParams: ISendTsoParms,
    ): Promise<IZosmfTsoResponse>

    /**
     * API method is used to get response data from a TSO address space.
     * @param session z/OSMF connection info
     * @param servletKey servlet key of address space
     * @return z/OSMF response object, see [IZosmfTsoResponse]
     */
    fun getDataFromTSO(
      session: AbstractSession,
      servletKey: String,
    ): Promise<IZosmfTsoResponse>

    /**
     * Collects responses from address space until it reaches prompt
     * @param session z/OSMF connection info
     * @param tso object from first API call from witch responses are needed
     * @return CollectedResponses response object, see [ICollectedResponses]
     */
    fun getAllResponses(
      session: AbstractSession,
      tso: IZosmfTsoResponse,
    ): Promise<ICollectedResponses>
  }
}
