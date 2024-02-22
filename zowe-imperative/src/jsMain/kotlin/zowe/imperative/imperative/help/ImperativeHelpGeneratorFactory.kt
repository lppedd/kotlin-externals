@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.help

import zowe.imperative.cmd.help.abstract.AbstractHelpGeneratorFactory
import zowe.imperative.cmd.help.doc.IHelpGenerator
import zowe.imperative.cmd.help.doc.IHelpGeneratorParms
import zowe.imperative.imperative.doc.IImperativeConfig

/**
 * Imperative Help generator factory passed to yargs to build help generators where needed.
 */
external class ImperativeHelpGeneratorFactory : AbstractHelpGeneratorFactory {
  /**
   * Creates an instance of ImperativeHelpGeneratorFactory.
   *
   * @param rootCommandName The root command name of your CLI.
   * @param config The imperative configuration document for your CLI.
   */
  constructor(rootCommandName: String, config: IImperativeConfig)

  /**
   * Obtains an instance of the help generator
   *
   * @param parms See the interface for details
   * @return The help generator instance
   */
  override fun getGenerator(parms: IHelpGeneratorParms): IHelpGenerator
}
