@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import zowe.imperative.error.ImperativeError

/**
 * Utility to load environment JSON files and set variables
 */
external class EnvFileUtils {
  companion object {
    /**
     * Check and read in an environment file from the user home directory using the app name If the
     * file is valid, set the environment variables If the file is not valid, display an error and
     * continue
     *
     * @param appName The application name
     * @param checkCliHomeVariableFirst Check inside of *_CLI_HOME first if it is defined
     * @param envPrefix The environment variable prefix
     * @throws ImperativeError
     */
    fun setEnvironmentForApp(
      appName: String,
      checkCliHomeVariableFirst: Boolean = definedExternally,
      envPrefix: String = definedExternally,
    )

    /**
     * Reapply environment variables that were applied before
     *
     * @throws ImperativeError
     */
    fun resetEnvironmentForApp()

    /**
     * Get the expected path for the user's environment variable file
     *
     * @param appName The application name
     * @param checkCliHomeVariableFirst Check inside of *_CLI_HOME first if it is defined
     * @param envPrefix environment variable prefix
     * @return Returns the path string if it exists, or null if it does not
     */
    fun getEnvironmentFilePath(
      appName: String,
      checkCliHomeVariableFirst: Boolean = definedExternally,
      envPrefix: String = definedExternally,
    ): String

    /**
     * Get the expected path for the user's environment variable file
     *
     * @param appName The application name
     * @return Returns the path string if it exists, or null if it does not
     */
    fun getUserHomeEnvironmentFilePath(appName: String): String

    /**
     * Get the expected path for the user's environment variable file
     *
     * @param appName The application name
     * @param envPrefix The environment variable prefix
     * @return Returns the path string if it exists, or null if it does not
     */
    fun getCliHomeEnvironmentFilePath(
      appName: String,
      envPrefix: String = definedExternally,
    ): String
  }
}
