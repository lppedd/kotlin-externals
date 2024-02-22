package zowe.sdk.console.doc.zosmf

/**
 * The z/OSMF console API parameters. See the z/OSMF REST API documentation for full details.
 */
external interface IZosmfIssueParms {
  /**
   * The z/OS console command to issue.
   */
  var cmd: String

  /**
   * The solicited keyword to look for
   */
  /* "sol-key"?: string; */
  // TODO(Edoardo): how to do this?

  /**
   * The system in the sysplex to route the command.
   */
  var system: String?

  /**
   * The method of issuing the command.
   */
  var async: String?
}
