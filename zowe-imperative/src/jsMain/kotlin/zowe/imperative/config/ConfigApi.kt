package zowe.imperative.config

import zowe.imperative.config.api.ConfigLayers
import zowe.imperative.config.api.ConfigPlugins
import zowe.imperative.config.api.ConfigProfiles
import zowe.imperative.config.api.ConfigSecure
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface ConfigApi {
  var profiles: ConfigProfiles
  var plugins: ConfigPlugins
  var layers: ConfigLayers
  var secure: ConfigSecure
}
