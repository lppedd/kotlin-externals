@file:JsModule("@zowe/zos-console-for-zowe-sdk")

package zowe.sdk.console

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.console.doc.ICollectParms
import zowe.sdk.console.doc.IConsoleResponse
import zowe.sdk.console.doc.zosmf.IZosmfCollectResponse
import zowe.sdk.console.doc.zosmf.IZosmfIssueResponse

/**
 * Get the response to a command that was issued asynchronously with the Issue Command service
 */
external class CollectCommand {
  companion object {
    /**
     * Collect any messages related to the synchronous command response key provided
     * @param session representing connection to this api
     * @param consoleName name of the EMCS console that is used to issue the command
     * @param commandResponseKey command response key from the Issue Command request
     * @return command response on resolve, see [IZosmfIssueResponse]
     */
    fun collectCommon(
      session: AbstractSession,
      consoleName: String,
      commandResponseKey: String,
    ): Promise<IZosmfCollectResponse>

    /**
     * Collect any messages (from default console) related to the synchronous command response key provided
     * @param session representing connection to this api
     * @param commandResponseKey command response key from the Issue Command request
     * @return command response on resolve, see [IZosmfCollectResponse]
     */
    fun collectDefConsoleCommon(
      session: AbstractSession,
      commandResponseKey: String,
    ): Promise<IZosmfCollectResponse>

    /**
     * Collect any messages related to the synchronous command response key provided and collect them into IConsoleResponse
     *
     * To control additional collection and other behaviors, populate the ICollectParms object according
     * to your needs (see ICollectParms for details).
     *
     * @param session representing connection to this api
     * @param parms console collect parameters, see [ICollectParms]
     * @param response response from previous command (if present), see [IConsoleResponse]
     * @return command response on resolve, see [IConsoleResponse]
     */
    fun collect(
      session: AbstractSession,
      parms: ICollectParms,
      response: IConsoleResponse = definedExternally,
    ): Promise<IConsoleResponse>

    /**
     * Get resource path for collect command
     * @param consoleName name of the EMCS console that is used to issue the command
     * @param commandResponseKey command response key from the Issue Command request
     * @return resource path
     */
    fun getResource(
      consoleName: String,
      commandResponseKey: String,
    ): String
  }
}
