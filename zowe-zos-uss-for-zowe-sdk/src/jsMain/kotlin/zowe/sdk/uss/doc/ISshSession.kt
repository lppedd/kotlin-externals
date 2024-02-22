package zowe.sdk.uss.doc

/**
 * Session interface for maintaining cookie and protocol information
 */
external interface ISshSession {
  /**
   * Host to connect ssh to
   */
  var hostname: String?

  /**
   * Port to obtain data from
   *
   * 22 is the default for ssh
   */
  var port: Int?

  /**
   * User name for logging in
   */
  var user: String?

  /**
   * Password
   */
  var password: String?

  /**
   * Path to a private key that matches with a public key stored in the server for authentication
   */
  var privateKey: String?

  /**
   * password to unlock the private key.
   */
  var keyPassphrase: String?

  /**
   * How long in milliseconds to wait for the SSH handshake to complete. If unset, defaults to 0 - no timeout.
   */
  var handshakeTimeout: Int?
}
