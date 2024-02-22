package vscode.test.electron

import kotlin.ts.Union

external interface IFetchInferredOptions : IFetchStableOptions {
  var extensionsDevelopmentPath: (Union<String, Array<String>> /* string | string[] */)?
}
