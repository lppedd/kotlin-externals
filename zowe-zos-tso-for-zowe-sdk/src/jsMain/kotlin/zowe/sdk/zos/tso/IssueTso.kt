@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.tso.doc.IIssueResponse
import zowe.sdk.zos.tso.doc.input.IIssueTsoParms
import zowe.sdk.zos.tso.doc.input.IStartTsoParms

/**
 * Class to handle issue command to TSO
 */
external class IssueTso {
  companion object {
    /**
     * API method to start a TSO address space, issue a command, collect responses until prompt is reached, and terminate the address space.
     * @param session z/OSMF connection info
     * @param accountNumber accounting info for Jobs
     * @param command command text to issue to the TSO address space.
     * @param startParams optional object with required parameters for starting TSO address space, see [IStartTsoParms]
     * @return IssueTso response object, see [IIssueResponse]
     */
    fun issueTsoCommand(
      session: AbstractSession,
      accountNumber: String,
      command: String,
      startParams: IStartTsoParms = definedExternally,
    ): Promise<IIssueResponse>

    /**
     * API method to start a TSO address space with provided parameters, issue a command,
     * collect responses until prompt is reached, and terminate the address space.
     * @param session z/OSMF connection info
     * @param commandParms object with required parameters, see [IIssueTsoParms]
     */
    fun issueTsoCommandCommon(
      session: AbstractSession,
      commandParms: IIssueTsoParms,
    ): Promise<IIssueResponse>
  }
}
