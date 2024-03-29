package vscode

/**
 * The information of an account associated with an [AuthenticationSession].
 */
external interface AuthenticationSessionAccountInformation {
  /**
   * The unique identifier of the account.
   */
  val id: String

  /**
   * The human-readable name of the account.
   */
  val label: String
}
