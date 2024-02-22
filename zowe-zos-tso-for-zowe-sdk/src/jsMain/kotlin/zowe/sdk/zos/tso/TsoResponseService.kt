@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import zowe.sdk.zos.tso.doc.ICollectedResponses
import zowe.sdk.zos.tso.doc.IPingResponse
import zowe.sdk.zos.tso.doc.IStartStopResponse
import zowe.sdk.zos.tso.doc.IStartStopResponses
import zowe.sdk.zos.tso.doc.zosmf.IZosmfPingResponse
import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

/**
 * Filter responses from z/OSMF
 */
external class TsoResponseService {
  companion object {
    /**
     * Populates start and stop commands response with z/OSMF response details
     * @param zosmfResponse z/OSMF response object, see [IZosmfTsoResponse]
     * @return populated object with type of IStartStopResponse, see [IStartStopResponse]
     */
    fun populateStartAndStop(zosmfResponse: IZosmfTsoResponse): IStartStopResponse

    /**
     * Populates start and stop commands response with z/OSMF response details
     * @param zosmfResponse z/OSMF response object, see [IZosmfTsoResponse]
     * @param collectedResponses collected z/OSMF responses object, see [ICollectedResponses]
     * @return populated object with type of IStartStopResponse, see [IStartStopResponse]
     */
    fun populateStartAndStopCollectAll(
      zosmfResponse: IZosmfTsoResponse,
      collectedResponses: ICollectedResponses = definedExternally,
    ): IStartStopResponses

    /**
     * Populates ping command response with z/OSMF response details
     * @param zosmfResponse z/OSMF response object, see [IZosmfPingResponse]
     * @return populated object with type of IPingResponse
     */
    fun populatePing(zosmfResponse: IZosmfPingResponse): IPingResponse
  }
}
