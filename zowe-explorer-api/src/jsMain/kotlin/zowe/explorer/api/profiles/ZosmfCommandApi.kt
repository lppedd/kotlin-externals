@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import js.promise.Promise
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.sdk.console.doc.IConsoleResponse
import zowe.sdk.zos.tso.doc.IIssueResponse
import zowe.sdk.zos.tso.doc.input.IStartTsoParms

/**
 * An implementation of the Zowe Explorer Command API interface for zOSMF.
 */
external class ZosmfCommandApi : ZosmfApiCommon, ZoweExplorerApi.ICommand {
  constructor (profile: IProfileLoaded = definedExternally)

  override fun issueTsoCommand(
    command: String,
    acctNum: String,
  ): Promise<IIssueResponse>

  override fun issueTsoCommandWithParms(
    command: String,
    parms: IStartTsoParms,
  ): Promise<IIssueResponse>

  override fun issueMvsCommand(command: String): Promise<IConsoleResponse>

  override fun getStatus(
    profile: IProfileLoaded,
    profileType: Any?,
  ): Promise<String>
}
