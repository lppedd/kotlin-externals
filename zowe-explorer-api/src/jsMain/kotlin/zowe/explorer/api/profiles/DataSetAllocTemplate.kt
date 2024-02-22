package zowe.explorer.api.profiles

import zowe.sdk.zos.files.methods.create.doc.ICreateDataSetOptions

/**
 * Used during creation of data sets in Zowe Explorer to access and manipulate a list of saved templates
 * presented to or saved by the user
 */
external interface DataSetAllocTemplate {
  @seskar.js.JsNative
  operator fun get(key: String): ICreateDataSetOptions?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: ICreateDataSetOptions?,
  )
}
