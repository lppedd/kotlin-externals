package zowe.imperative.cmd.doc.response.parms

import node.fs.WriteStream
import zowe.imperative.operations.doc.ITaskWithStatus
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IProgressBarParms {
  var task: ITaskWithStatus
  var updateInterval: Int?
  var stream: WriteStream?
}
