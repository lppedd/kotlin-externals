@file:JsModule("@zowe/imperative")

package zowe.imperative.config

/**
 * Constants related to team configuration
 */
external class ConfigConstants {
  companion object {
    /**
     * Number of spaces used for indentation in config JSONC files
     */
    val INDENT: Int

    /**
     * A string used to hide the display of secure values
     */
    @JsString("(secure value)")
    val SECURE_VALUE: String

    /**
     * ID used for storing secure credentials in vault
     */
    @JsString("secure_config_props")
    val SECURE_ACCT: String

    /**
     * ID used for storing secure credentials in vault
     */
    @JsString("- Press ENTER to skip: ")
    val SKIP_PROMPT: String
  }
}
