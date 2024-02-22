@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.env

import zowe.imperative.imperative.doc.IImperativeEnvironmentalVariableSettings

/**
 * Service for reading environmental variable settings exposed for CLIs built on Imperative CLI framework
 */
external class EnvironmentalVariableSettings {
  companion object {
    /**
     * The end of the environmental variable for configuring the log level for the imperative logger
     * of your CLI The prefix will be added to the beginning of this value to construct the full key
     */
    @JsString("_IMPERATIVE_LOG_LEVEL")
    val IMPERATIVE_LOG_LEVEL_KEY_SUFFIX: String

    /**
     * The end of the environmental variable for configuring the log level for the appLogger of your
     * CLI The prefix will be added to the beginning of this value to construct the full key
     */
    @JsString("_APP_LOG_LEVEL")
    val APP_LOG_LEVEL_KEY_SUFFIX: String

    /**
     * The end of the environmental variable for configuring the ability to mask output of your CLI
     * The prefix will be added to the beginning of this value to construct the full key
     */
    @JsString("_APP_MASK_OUTPUT")
    val APP_MASK_OUTPUT_SUFFIX: String

    /**
     * The end of the environmental variable for configuring the home directory for your CLI The
     * prefix will be added to the beginning of this value to construct the full key
     */
    @JsString("_CLI_HOME")
    val CLI_HOME_SUFFIX: String

    /**
     * The end of the environmental variable for configuring the prompt phrase for your CLI The
     * prefix will be added to the beginning of this value to construct the full key
     */
    @JsString("_PROMPT_PHRASE")
    val PROMPT_PHRASE_SUFFIX: String

    /**
     * The end of the environmental variable for configuring the plugins directory for your CLI The
     * prefix will be added to the beginning of this value to contruct the full key
     */
    @JsString("_CLI_PLUGINS_DIR")
    val CLI_PLUGINS_DIR_SUFFIX: String

    /**
     * Read all environmental variable settings for a CLI
     *
     * @param prefix the environmental variables for a CLI will begin with this prefix
     *   e.g. "SAMPLE_CLI". by default, this should be the same as the Imperative.loadedConfig.name
     *   field unless you specify envVariablePrefix on your Imperative configuration
     * @return object populated with the settings specified by the user
     */
    fun read(prefix: String): IImperativeEnvironmentalVariableSettings
  }
}
