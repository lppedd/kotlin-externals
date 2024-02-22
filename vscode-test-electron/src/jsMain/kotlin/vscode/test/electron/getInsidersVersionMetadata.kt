@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise

external fun getInsidersVersionMetadata(
  platform: String,
  version: String,
): Promise<IUpdateMetadata>
