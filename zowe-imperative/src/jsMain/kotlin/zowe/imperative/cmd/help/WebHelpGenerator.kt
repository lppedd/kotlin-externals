@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.help

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseApi
import zowe.imperative.utilities.ImperativeConfig

/**
 * Imperative web help generator.
 * Accepts the command definitions and constructs the full help text for the command node.
 */
external class WebHelpGenerator {
  /**
   * Create an instance of WebHelpGenerator.
   *
   * @param fullCommandTree Imperative command tree to build help for
   * @param config Imperative config containing data about the CLI
   * @param webHelpDir Output directory for web help files
   */
  constructor(fullCommandTree: ICommandDefinition, config: ImperativeConfig, webHelpDir: String)

  /**
   * Specifies whether user's home directory should be redacted from help content
   */
  var sanitizeHomeDir: Boolean

  /**
   * Build web help files and copy dependencies to output folder
   *
   * @param cmdResponse Command response object to use for output
   */
  fun buildHelp(cmdResponse: IHandlerResponseApi)
}
