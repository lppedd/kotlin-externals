@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.compare

import js.promise.Promise
import node.buffer.Buffer
import zowe.cli.zosfiles.ZosFilesBaseHandler
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse
import kotlin.ts.Union

/**
 * This class is used by the various zosfiles-compare handlers as the base class for their implementation.
 * All handlers within zosfiles-compare should extend this class.
 *
 * This class should not be used outside of the zosfiles-compare package.
 */
abstract external class CompareBaseHandler : ZosFilesBaseHandler {
  /**
   * This will grab the zosmf profile and create a session before calling the subclass
   * [ZosFilesBaseHandler.processWithSession] method.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  fun processWithSession(
    commandParameters: IHandlerParameters,
    session: AbstractSession,
  ): Promise<IZosFilesResponse<Any?>>

  /**
   * Abstract method required for compare handlers to determine how they gather the contents of the file/dataset to compare
   * @param session Gives access to the session object in case the handler needs to submit a request to get the first file
   * @param args Command arguments required for getting the dataset, filepath, or spool descriptor
   * @param helper CompareBaseHelper instance to access prepare- functions
   */
  open fun getFile1(
    session: AbstractSession,
    args: ICommandArguments,
    helper: CompareBaseHelper,
  ): Promise<Union<String, Buffer>>

  /**
   * Abstract method required for compare handlers to determine how they gather the contents of the file/dataset to compare
   * @param session Gives access to the session object in case the handler needs to submit a request to get the contents
   * @param args Command arguments required for getting the dataset, filepath, or spool descriptor
   * @param helper CompareBaseHelper instance to access prepare- functions
   */
  open fun getFile2(
    session: AbstractSession,
    args: ICommandArguments,
    helper: CompareBaseHelper,
  ): Promise<Union<String, Buffer>>
}
