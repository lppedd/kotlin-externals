@file:JsModule("@zowe/imperative")

package zowe.imperative.config.api

import zowe.imperative.config.Config

/**
 * Base class from which all Config APIs are derived.
 */
open external class ConfigApi {
  constructor(mConfig: Config)

  var mConfig: Config
}
