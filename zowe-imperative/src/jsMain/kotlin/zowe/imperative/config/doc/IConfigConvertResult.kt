@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IConfigConvertResult {
  var config: IConfig
  var profilesConverted: Record<String, Array<String>>
  var profilesFailed: Array<ProfileFailed>
}
