@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.create.binaryPds

import js.promise.Promise
import zowe.cli.zosfiles.ZosFilesBaseHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * Handler to create a Binary-PDS data set
 */
external class BinaryPDSHandler : ZosFilesBaseHandler {
  override fun processWithSession(
    commandParameters: IHandlerParameters,
    session: AbstractSession,
    zosmfProfile: IProfile,
  ): Promise<IZosFilesResponse<Any?>>
}
