@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import js.errors.JsError
import node.buffer.BufferEncoding
import node.stream.Duplex

external class BufferBuilder : Duplex {
  override fun _write(chunk: Any?, encoding: BufferEncoding, callback: (error: JsError?) -> Unit)
  fun _read(_size: Int)
}
