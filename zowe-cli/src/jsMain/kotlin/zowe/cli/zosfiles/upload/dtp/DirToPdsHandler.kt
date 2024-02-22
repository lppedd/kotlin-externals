@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.upload.dtp

import js.promise.Promise
import zowe.cli.zosfiles.ZosFilesBaseHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * Handler to upload content of a directory to a PDS
 */
external class DirToPdsHandler : ZosFilesBaseHandler {
  override fun processWithSession(
    commandParameters: IHandlerParameters,
    session: AbstractSession,
    zosmfProfile: IProfile,
  ): Promise<IZosFilesResponse<Any?>>
}
