@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise
import node.ReadableStream
import node.buffer.Buffer

/** Gets a Buffer from a Node.js stream */
external fun streamToBuffer(readable: ReadableStream): Promise<Buffer>
