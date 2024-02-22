package zowe.imperative.operations.doc

import zowe.imperative.operations.Operation
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IOperationResult<T> {
  var operationName: String
  var resultMessage: String
  var operationFailed: Boolean
  var diverge: Boolean
  var divergeTo: Operation<Any?>
  var continuePath: Boolean
  var nextOperationResult: IOperationResult<Any?>
  var operationObject: Operation<Any?>
  var operationUndoPossible: Boolean
  var operationUndoFailed: Boolean
  var operationUndoAttempted: Boolean
  var critical: Boolean
  var infoMessages: Array<String>
  var errorMessages: Array<String>
  var output: T
}
