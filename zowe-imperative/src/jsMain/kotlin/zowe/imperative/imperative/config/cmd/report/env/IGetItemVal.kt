package zowe.imperative.imperative.config.cmd.report.env

/**
 * This interface represents the result from getEnvItemVal().
 */
external interface IGetItemVal {
  var itemVal: String
  var itemValMsg: String
  var itemProbMsg: String
}
