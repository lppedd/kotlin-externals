@file:JsModule("@zowe/zos-console-for-zowe-sdk")

package zowe.sdk.console

import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.console.doc.ICollectParms
import zowe.sdk.console.doc.IIssueParms
import zowe.sdk.console.doc.zosmf.IZosmfIssueParms

/**
 * Class validates parameters for console commands
 */
external class ConsoleValidator {
  companion object {
    /**
     * Validate supplied parameters
     * @param session representing connection to this api
     * @param consoleName name of the EMCS console that is used to issue the command
     * @param commandParms synchronous console issue parameters, see [IZosmfIssueParms]
     */
    fun validateCommonParms(
      session: AbstractSession,
      consoleName: String,
      commandParms: IZosmfIssueParms,
    )

    /**
     * Validate supplied parameters
     * @param session representing connection to this api
     * @param parms console issue parameters, see [IIssueParms]
     */
    fun validateIssueParms(
      session: AbstractSession,
      parms: IIssueParms,
    )

    /**
     * Validate supplied parameters
     * @param session representing connection to this api
     * @param theCommand command to issue
     */
    fun validateIssueSimpleParms(
      session: AbstractSession,
      theCommand: String,
    )

    /**
     * Validate supplied parameters
     * @param parms console collect parameters, see [ICollectParms]
     */
    fun validateCollectParm(parms: ICollectParms)

    /**
     * Validate supplied parameters
     * @param parms console issue parameters, see [IIssueParms]
     */
    fun validateIssueParm(parms: IIssueParms)

    /**
     * Validate supplied parameters
     * @param session representing connection to this api
     * @param consoleName name of the EMCS console that is used to issue the command
     * @param commandResponseKey command response key from the Issue Command request
     */
    fun validateCollectCommonParms(
      session: AbstractSession,
      consoleName: String,
      commandResponseKey: String,
    )

    /**
     * Validate supplied parameters
     * @param session representing connection to this api
     * @param parms console collect parameters, see [ICollectParms]
     */
    fun validateCollectParms(
      session: AbstractSession,
      parms: ICollectParms,
    )
  }
}
