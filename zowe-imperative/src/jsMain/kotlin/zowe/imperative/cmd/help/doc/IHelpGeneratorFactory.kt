package zowe.imperative.cmd.help.doc

/**
 * Help generator factory interface - implemented by the AbstractHelpGeneratorFactory (which is then
 * extended to suit the needs of the implementation)
 */
external interface IHelpGeneratorFactory {
  /**
   * Create an instance of the help generator for the command.
   *
   * @param parms The generator parameters - See Interface for details.
   */
  fun getHelpGenerator(parms: IHelpGeneratorParms): IHelpGenerator
}
