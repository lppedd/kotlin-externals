package zowe.sdk.console.doc

/**
 * Common z/OS Consoles API Parameters.
 */
external interface IConsoleParms {
  /**
   * The z/OS emcs console to direct the commands.
   */
  var consoleName: String?

  /**
   * The z/OSMF Console API returns '\r' or '\r\n' where line-breaks. Can attempt to replace these
   * sequences with '\n', but there may be cases where that is not preferable. Specify false to prevent processing.
   */
  var processResponses: Boolean?
}
