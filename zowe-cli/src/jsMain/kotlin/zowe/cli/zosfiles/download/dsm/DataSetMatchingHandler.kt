@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.download.dsm

import js.promise.Promise
import zowe.cli.zosfiles.ZosFilesBaseHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * Handler to download all members from a pds
 */
external class DataSetMatchingHandler : ZosFilesBaseHandler {
  override fun processWithSession(
    commandParameters: IHandlerParameters,
    session: AbstractSession,
    zosmfProfile: IProfile,
  ): Promise<IZosFilesResponse<Any?>>
}
