@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.tso.doc.input.IIssueTsoParms
import zowe.sdk.zos.tso.doc.input.IStartTsoParms
import zowe.sdk.zos.tso.doc.input.IStopTsoParms
import zowe.sdk.zos.tso.doc.zosmf.IZosmfPingResponse
import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

/**
 * Class validates parameters for TSO commands
 */
external class TsoValidator {
  companion object {
    /**
     * Validate session
     */
    fun validateSession(session: AbstractSession)

    /**
     * Validate TSO start command parameters
     * @param parms object with required parameters, see [IStartTsoParms]
     */
    fun validateStartParams(parms: IStartTsoParms)

    /**
     * Validate TSO issue command parameters
     * @param parms object with required parameters, see [IIssueTsoParms]
     */
    fun validateIssueParams(parms: IIssueTsoParms)

    /**
     * Validate TSO stop command parameters
     * @param parms object with required parameters, see [IStopTsoParms]
     */
    fun validateStopParams(parms: IStopTsoParms)

    /**
     * Validate z/OSMF response, needed for service and filtering servlet key
     * @param parms object response from z/OSMF, see [IZosmfTsoResponse]
     */
    fun validateStartZosmfResponse(parms: IZosmfTsoResponse)

    /**
     * Validate supplied parameters
     * @param session representing connection to this api
     * @param text string to check if not empty or undefined
     * @param errorMsg message to show in text case validation fails
     */
    fun validatePingParms(
      session: AbstractSession,
      text: String,
      errorMsg: String,
    )

    /**
     * Validate supplied parameters
     * @param text string to check if not null or undefined
     * @param errorMsg message to show in text case validation fails
     */
    fun validateString(
      text: String,
      errorMsg: String,
    )

    /**
     * Validate supplied parameters
     * @param text string to check if empty
     * @param errorMsg message to show in text case validation fails
     */
    fun validateNotEmptyString(
      text: String,
      errorMsg: String,
    )

    /**
     * Validate z/OSMF response
     * @param parms object response from z/OSMF, see [IZosmfPingResponse]
     */
    fun validatePingZosmfResponse(parms: IZosmfPingResponse)

    /**
     * Validate z/OSMF response for errors
     * @param zosmfResponse object response from z/OSMF, see [IZosmfTsoResponse]
     */
    fun validateErrorMessageFromZosmf(zosmfResponse: IZosmfTsoResponse)
  }
}
