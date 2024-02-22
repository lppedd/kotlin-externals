package zowe.explorer.api.tree

import vscode.JsString
import kotlin.ts.Readonly

external interface BinaryEncoding : ZosEncoding {
  @JsString("binary")
  @Readonly
  override var kind: String
}
