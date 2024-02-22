package zowe.imperative.imperative.doc

import zowe.imperative.cmd.doc.IPartialCommandDefinition

external interface IImperativeAuthGroupConfig {
  /**
   * Command definition for "auth" command group
   */
  var authGroup: IPartialCommandDefinition?

  /**
   * Command definition for "auth login" command group
   */
  var loginGroup: IPartialCommandDefinition?

  /**
   * Command definition for "auth logout" command group
   */
  var logoutGroup: IPartialCommandDefinition?
}
