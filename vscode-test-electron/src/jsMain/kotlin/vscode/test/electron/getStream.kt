@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise
import node.http.IncomingMessage

external fun getStream(
  api: String,
  timeout: Int,
): Promise<IncomingMessage>
