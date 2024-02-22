@file:JsModule("@zowe/zosmf-for-zowe-sdk")

package zowe.sdk.zosmf

import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.cmd.doc.response.api.handler.IHandlerFormatOutputApi
import zowe.imperative.cmd.doc.response.api.handler.IHandlerProgressApi
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseConsoleApi
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseDataApi
import zowe.imperative.error.doc.IImperativeError
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.imperative.rest.session.AbstractSession

/**
 * This class is used by the various handlers in the project as the base class for their implementation.
 */
abstract external class ZosmfBaseHandler : ICommandHandler {
  /**
   * The session creating from the command line arguments / profile
   */
  var mSession: AbstractSession

  /**
   * Loaded z/OSMF profile if needed
   */
  var mZosmfProfile: IProfile

  /**
   * Loaded z/OSMF profile with meta information
   */
  var mZosmfLoadedProfile: IProfileLoaded

  /**
   * Command line arguments passed
   */
  var mArguments: ICommandArguments

  /**
   * Full set of command handler parameters from imperative
   */
  var mHandlerParams: IHandlerParameters

  /**
   * This will grab the arguments and create a session before calling the subclass
   * [ZosmfBaseHandler.processWithSession] method.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>

  /**
   * Fail the command with an imperative error
   * @param err the imperative error parameters
   */
  fun fail(err: IImperativeError)

  /**
   * Returns the console interface for the command handler
   */
  val console: IHandlerResponseConsoleApi

  /**
   * Returns the format interface for the command handler
   */
  val format: IHandlerFormatOutputApi

  /**
   * Returns the format interface for the command handler
   */
  val data: IHandlerResponseDataApi

  /**
   * Returns the format interface for the command handler
   */
  val progress: IHandlerProgressApi

  /**
   * This is called by the [ZosmfBaseHandler.process] after it creates a session.
   *
   * @param commandParameters Command parameters sent to the handler.
   */
  open fun processCmd(commandParameters: IHandlerParameters): Promise<Unit>
}
