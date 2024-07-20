@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise

external fun fetchTargetInferredVersion(options: IFetchInferredOptions): Promise<Version>
