package zowe.explorer.api.tree

import kotlin.ts.Readonly

external interface TextEncoding : ZosEncoding {
  @JsString("text")
  @Readonly
  override var kind: String
}
