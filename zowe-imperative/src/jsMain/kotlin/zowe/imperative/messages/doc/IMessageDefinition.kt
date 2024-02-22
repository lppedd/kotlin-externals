package zowe.imperative.messages.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IMessageDefinition {
  var message: String
  var locales: Record<String, String>?
}
