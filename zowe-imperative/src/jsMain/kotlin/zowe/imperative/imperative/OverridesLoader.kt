@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative

import js.promise.Promise
import zowe.imperative.imperative.doc.IImperativeConfig
import zowe.imperative.utilities.ImperativeConfig

/**
 * Imperative-internal class to load overrides You should not need to call this from your CLI.
 */
external class OverridesLoader {
  companion object {
    /**
     * Apply overrides to all applicable facilities and use our defaults where an override is not
     * provided.
     *
     * @param config the current [ImperativeConfig.loadedConfig]
     * @param packageJson the current package.json
     */
    fun load(
      config: IImperativeConfig,
      packageJson: Any?,
    ): Promise<Unit>

    /**
     * Ensure the Credential Manager is initialized for team config.
     */
    fun ensureCredentialManagerLoaded(): Promise<Unit>
  }
}
