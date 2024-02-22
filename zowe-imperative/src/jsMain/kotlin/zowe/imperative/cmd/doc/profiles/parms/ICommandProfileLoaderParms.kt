package zowe.imperative.cmd.doc.profiles.parms

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.logger.Logger
import zowe.imperative.profiles.doc.api.IProfileManagerFactory
import kotlin.js.plain.JsPlainObject

/**
 * Control parameters for the command profile loader.
 */
@JsPlainObject
external interface ICommandProfileLoaderParms {
  /**
   * The command definition document which contains the profile specifications for the command.
   */
  var commandDefinition: ICommandDefinition

  /**
   * The profile Manager factory to create profile manager instances depending on the profile types
   * required by the command.
   */
  var profileManagerFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>

  /**
   * Optional logger instance - if not supplied, then Logger.getImperativeLogger() is used.
   */
  var logger: Logger?
}
