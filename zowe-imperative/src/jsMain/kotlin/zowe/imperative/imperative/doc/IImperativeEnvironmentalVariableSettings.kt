package zowe.imperative.imperative.doc

/**
 * Interface representing variables set via environmental variables for CLIs based on Imperative
 */
external interface IImperativeEnvironmentalVariableSettings {
  /**
   * Override the log level for the "imperative" log file for your CLI
   */
  var imperativeLogLevel: IImperativeEnvironmentalVariableSetting?

  /**
   * Override the log level for the app log file (named after your CLI project)
   */
  var appLogLevel: IImperativeEnvironmentalVariableSetting?

  /**
   * The home for the CLI where logs, profiles, and other data are stored
   */
  var cliHome: IImperativeEnvironmentalVariableSetting?

  /**
   * The phrase which, when entered as the value of a command line argument, indicates Imperative
   * should prompt the user and hide their text entry default is PROMPT*
   */
  var promptPhrase: IImperativeEnvironmentalVariableSetting?

  /**
   * The indication that sensitive data should be obscured in the CLI default is TRUE
   */
  var maskOutput: IImperativeEnvironmentalVariableSetting?

  /**
   * The directory where CLI plugins are installed. Default is `${cliHome}/plugins`.
   */
  var pluginsDir: IImperativeEnvironmentalVariableSetting?
}
