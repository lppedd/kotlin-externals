@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.copy.dsclp

import js.promise.Promise
import zowe.cli.zosfiles.ZosFilesBaseHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * Handler to load a target profile.
 *
 * TODO Consider migrating code for loading target profiles to Imperative
 */
external class TargetProfileHandler : ZosFilesBaseHandler {
  /**
   * Build target z/OSMF session from profiles and command arguments.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>

  /**
   * Return session config for target profile to pass on to the next handler.
   */
  fun processWithSession(
    _params: IHandlerParameters,
    session: AbstractSession,
  ): Promise<IZosFilesResponse<Any?>>
}
