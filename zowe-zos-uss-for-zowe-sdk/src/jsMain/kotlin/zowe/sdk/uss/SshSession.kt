@file:JsModule("@zowe/zos-uss-for-zowe-sdk")

package zowe.sdk.uss

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition
import zowe.sdk.uss.doc.ISshSession

/**
 * Utility Methods for Brightside
 */
external class SshSession {
  /**
   * Creates an instance of AbstractSession.
   * @param mISshSession SshSession parameter object
   */
  constructor(mISshSession: ISshSession)

  /**
   * Obtain session info and defaults
   */
  val ISshSession: ISshSession

  companion object {
    /**
     * Default ssh port 22
     */
    @JsInt(22)
    val DEFAULT_SSH_PORT: Int
    var SSH_CONNECTION_OPTION_GROUP: String

    /**
     * Option used in profile creation and commands for hostname for z/OS SSH
     */
    var SSH_OPTION_HOST: ICommandOptionDefinition

    @Deprecated("Use SSH_OPTION_HOST")
    var SSH_OPTION_HOST_PROFILE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for port for z/OS SSH
     */
    var SSH_OPTION_PORT: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for username / ID  for z/OS SSH
     */
    var SSH_OPTION_USER: ICommandOptionDefinition

    @Deprecated("Use SSH_OPTION_USER")
    var SSH_OPTION_USER_PROFILE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for password/passphrase for z/OS SSH
     */
    var SSH_OPTION_PASSWORD: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for private key path
     */
    var SSH_OPTION_PRIVATEKEY: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for passphrase for private key
     */
    var SSH_OPTION_KEYPASSPHRASE: ICommandOptionDefinition

    /**
     * Option used in profile creation to set handshake timeout. If unset, defaults to no timeout.
     */
    var SSH_OPTION_HANDSHAKETIMEOUT: ICommandOptionDefinition

    /**
     * Options related to connecting to z/OS SSH
     * These options can be filled in if the user creates a profile
     */
    var SSH_CONNECTION_OPTIONS: Array<ICommandOptionDefinition>

    /**
     * Given command line arguments, create an SSH session configuration object.
     * @param args The arguments specified by the user
     * @return A session configuration to be used for an SSH session.
     */
    fun createSshSessCfgFromArgs(args: ICommandArguments): ISshSession
  }
}
