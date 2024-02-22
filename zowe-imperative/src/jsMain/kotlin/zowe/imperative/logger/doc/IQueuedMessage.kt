package zowe.imperative.logger.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IQueuedMessage {
  var category: String
  var method: String
  var message: String
}
