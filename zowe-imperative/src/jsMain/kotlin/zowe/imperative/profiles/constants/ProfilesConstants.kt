@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles.constants

/**
 * Constants used within the auto-generated profiles group
 */
external class ProfilesConstants {
  companion object {
    @JsString("profileTypeIdentifier")
    val PROFILES_COMMAND_TYPE_KEY: String

    @JsString("managed by")
    val PROFILES_OPTION_SECURELY_STORED: String

    @JsString("The 'config init' command")
    val DEPRECATE_TO_CONFIG_INIT: String

    @JsString("The 'config list' command")
    val DEPRECATE_TO_CONFIG_LIST: String

    @JsString("Edit your Zowe V2 configuration")
    val DEPRECATE_TO_CONFIG_EDIT: String

    @JsString("The 'config set' command")
    val DEPRECATE_TO_CONFIG_SET: String
  }
}
