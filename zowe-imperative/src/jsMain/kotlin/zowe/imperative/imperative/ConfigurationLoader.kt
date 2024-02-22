@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative

import zowe.imperative.imperative.doc.IImperativeConfig

/**
 * Imperative-internal class to load configuration You should not need to call this from your CLI.
 */
external class ConfigurationLoader {
  companion object {
    /**
     * @param providedConfig the configuration provided through the "init" Imperative API. Pass undefined if no config specified
     * @param packageJson caller's full package.json contents as an object. Used if providedConfig is undefined.
     * @param callerFileRequirer function that, when provided a string, returns the require()d contents of a file relative to where the caller initialized from
     */
    fun load(
      providedConfig: IImperativeConfig,
      packageJson: Any?,
      callerFileRequirer: (file: String) -> Any?,
    ): IImperativeConfig
  }
}
