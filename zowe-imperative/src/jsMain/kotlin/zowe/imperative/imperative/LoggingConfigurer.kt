@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative

import zowe.imperative.imperative.doc.IImperativeConfig
import zowe.imperative.logger.doc.IConfigLogging

/**
 * Helper class to construct default config, log4js config, and define log4js configuration
 * document.
 */
external class LoggingConfigurer {
  companion object {
    /**
     * Configure all log4js loggers based on imperative config
     *
     * @param home home directory
     * @param imperativeConfig imperative main config
     * @return compiled logging config for Logger.init();
     */
    fun configureLogger(
      home: String,
      imperativeConfig: IImperativeConfig,
    ): IConfigLogging
  }
}
