@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.help

import zowe.imperative.cmd.help.abstract.AbstractHelpGeneratorFactory
import zowe.imperative.cmd.help.doc.IHelpGeneratorParms

/**
 * The default help generator factory - always supplies the default help generator.
 */
external class HelpGeneratorFactory : AbstractHelpGeneratorFactory {
  /**
   * Get an instance of the help generator
   *
   * @param parms See the interface for details
   */
  override fun getGenerator(parms: IHelpGeneratorParms): DefaultHelpGenerator
}
