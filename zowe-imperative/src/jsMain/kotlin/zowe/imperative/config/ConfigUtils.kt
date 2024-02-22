@file:JsModule("@zowe/imperative")

package zowe.imperative.config

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.error.ImperativeError

external class ConfigUtils {
  companion object {
    /**
     * Coeerces string property value to a boolean or number type.
     *
     * @param value String value
     * @param type Property type defined in the schema
     * @return Boolean, number, or string
     */
    fun coercePropValue(
      value: Any?,
      type: String = definedExternally,
    ): Any?

    /**
     * Retrieves the name of the active profile for the given type. If no such profile exists,
     * returns the default name which can be used to create a new profile.
     *
     * @param profileType The type of CLI profile
     * @param cmdArguments CLI arguments which may specify a profile
     * @param defaultProfileName Name to fall back to if profile doesn't exist. If not specified,
     *   the profile type will be used.
     * @return The profile name
     */
    fun getActiveProfileName(
      profileType: String,
      cmdArguments: ICommandArguments = definedExternally,
      defaultProfileName: String = definedExternally,
    ): String

    /**
     * Checks if partial path is equal to or nested inside full path
     *
     * @param fullPath JSON path to profile 1
     * @param partialPath JSON path to profile 2
     */
    fun jsonPathMatches(
      fullPath: String,
      partialPath: String,
    ): Boolean

    /**
     * Form an error message for failures to securely save a value.
     *
     * @param solution Text that our caller can supply for a solution.
     * @return ImperativeError to be thrown
     */
    fun secureSaveError(solution: String = definedExternally): ImperativeError
  }
}
