@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.tso.doc.IStartStopResponses
import zowe.sdk.zos.tso.doc.input.IStartTsoParms
import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

/**
 * Start TSO address space and receive servlet key
 */
external class StartTso {
  companion object {
    /**
     * Start TSO address space with provided  parameters
     * @param session z/OSMF connection info
     * @param commandParms object with required parameters, see [IStartTsoParms]
     * @return z/OSMF response object, see [IZosmfTsoResponse]
     */
    fun startCommon(
      session: AbstractSession,
      commandParms: IStartTsoParms,
    ): Promise<IZosmfTsoResponse>

    /**
     * Start TSO address space with provided parameters.
     * @param session z/OSMF connection info
     * @param accountNumber this key of IStartTsoParms required, because it cannot be default.
     * @param parms optional object with required parameters, see [IStartTsoParms]
     * @return command response on resolve, see [IStartStopResponses]
     */
    fun start(
      session: AbstractSession,
      accountNumber: String,
      parms: IStartTsoParms = definedExternally,
    ): Promise<IStartStopResponses>

    /**
     * Sets required parameters by default if not provided. If some parameters provided
     * it uses received and the rest required parameters will be default
     * @param parms object with required parameters, see [IStartTsoParms]
     * @param accountNumber this key of IStartTsoParms required, because it cannot be default.
     * @return object with provided parameters if not the with default
     */
    fun setDefaultAddressSpaceParams(
      parms: IStartTsoParms,
      accountNumber: String,
    ): IStartTsoParms

    /**
     * Builds a resources query from passed parameters which is needed for z/OSMF api URI.
     * @param parms object with required parameters, see [IStartTsoParms]
     * @return URI for z/OSMF REST call
     */
    fun getResourcesQuery(parms: IStartTsoParms): String
  }
}
