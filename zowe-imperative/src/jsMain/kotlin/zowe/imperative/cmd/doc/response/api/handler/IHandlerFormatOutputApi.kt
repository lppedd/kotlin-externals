package zowe.imperative.cmd.doc.response.api.handler

import zowe.imperative.cmd.doc.response.response.ICommandOutputFormat
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IHandlerFormatOutputApi {
  var output: (format: ICommandOutputFormat) -> Unit
}
