@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative

import js.errors.JsError
import zowe.imperative.imperative.doc.IImperativeConfig

/**
 * Imperative-internal class to validate configuration You should not need to call this from your CLI.
 */
external class ConfigurationValidator {
  companion object {
    /**
     * Validate a configuration object that has already been completely loaded from the consumer of Imperative.
     *
     * @param config
     * @throws JsError if the configuration is not valid
     */
    fun validate(config: IImperativeConfig)
  }
}
