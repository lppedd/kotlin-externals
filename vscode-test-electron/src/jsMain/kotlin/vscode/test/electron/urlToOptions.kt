@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import node.https.RequestOptions

external fun urlToOptions(url: String): RequestOptions
