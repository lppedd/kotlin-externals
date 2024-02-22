package zowe.imperative.imperative.config.cmd.report.env

/**
 * This is the structure for defining a test to identify if a problem exists for a given runtime
 * environment item, and the message to give when the problem is detected.
 */
external interface IProbTest {
  var itemId: ItemId
  var probExpr: String
  var probMsg: String
}
