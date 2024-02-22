@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.help.abstract

import zowe.imperative.cmd.help.doc.IHelpGenerator
import zowe.imperative.cmd.help.doc.IHelpGeneratorFactory
import zowe.imperative.cmd.help.doc.IHelpGeneratorFactoryParms
import zowe.imperative.cmd.help.doc.IHelpGeneratorParms

/**
 * The abstract help generator factory class - implemented normally by imperative to provide the
 * help generator object that should be used for your CLI.
 */
abstract external class AbstractHelpGeneratorFactory : IHelpGeneratorFactory {
  /**
   * Creates an instance of AbstractHelpGeneratorFactory.
   *
   * @param parms Control parameters and inforamtion required to
   *   build help generators
   * @memberof AbstractHelpGeneratorFactory
   */
  constructor(parms: IHelpGeneratorFactoryParms)

  /**
   * Verifies the input parameters and returns the help generator instance for the command.
   *
   * @param parms The input parameters - see interface for details.
   */
  override fun getHelpGenerator(parms: IHelpGeneratorParms): IHelpGenerator

  /**
   * Implement to return your specific help generator instance.
   *
   * @param parms
   * @return The help generator for the command.
   */
  open fun getGenerator(parms: IHelpGeneratorParms): IHelpGenerator

  /**
   * Accessor of the root command nae.
   */
  val rootCommandName: String

  /**
   * Accessor for the primary highlight color
   */
  val primaryHighlightColor: String

  /**
   * Accessor for the produce markdown flag
   */
  val produceMarkdown: Boolean

  /**
   * Accessor for the full list of parameters
   */
  val factoryParameters: IHelpGeneratorFactoryParms
}
