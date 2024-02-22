package zowe.imperative.operations

import zowe.imperative.operations.doc.IOperationResult

typealias IOperationResultReady<T> = (output: T, operationResults: IOperationResult<Any?>) -> Unit
