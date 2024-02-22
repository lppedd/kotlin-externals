@file:JsModule("@zowe/imperative")

package zowe.imperative.config.api

/**
 * API Class for manipulating plugins.
 */
external class ConfigPlugins : ConfigApi {
  fun get(): Array<String>
}
