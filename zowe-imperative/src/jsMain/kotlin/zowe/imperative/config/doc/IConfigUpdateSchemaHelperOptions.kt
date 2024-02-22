package zowe.imperative.config.doc

import zowe.imperative.config.Config
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigUpdateSchemaHelperOptions {
  var layer: IConfigLayer
  var config: Config
  var updatedPaths: IConfigUpdateSchemaPaths
  var updateOptions: IConfigUpdateSchemaOptions
}
