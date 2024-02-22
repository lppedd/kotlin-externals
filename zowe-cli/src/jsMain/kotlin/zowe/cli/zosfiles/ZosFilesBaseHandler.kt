@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * This class is used by the various zosfiles handlers as the base class for their implementation.
 * All handlers within zosfiles should extend this class.
 *
 * This class should not be used outside of the zosfiles package.
 */
abstract external class ZosFilesBaseHandler : ICommandHandler {
  /**
   * This will grab the zosmf profile and create a session before calling the subclass
   * [ZosFilesBaseHandler.processWithSession] method.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>

  /**
   * This is called by the [ZosFilesBaseHandler.process] after it creates a session. Should
   * be used so that every class under files does not have to instantiate the session object.
   *
   * @param commandParameters Command parameters sent to the handler.
   * @param session The session object generated from the zosmf profile.
   * @param zosmfProfile The zosmf profile that was loaded for the command.
   *        Never use this deprecated zosmfProfile parameter.
   *        It should have been removed for the V2 version of Zowe, but we missed it.
   *        There is no good reason to use it. Better techniques exist, and are
   *        implemented in all of the implementations of this abstract class.
   *
   * @return The response from the underlying zos-files api call.
   */
  open fun processWithSession(
    commandParameters: IHandlerParameters,
    session: AbstractSession,
    zosmfProfile: IProfile = definedExternally,
  ): Promise<IZosFilesResponse<Any?>>
}
