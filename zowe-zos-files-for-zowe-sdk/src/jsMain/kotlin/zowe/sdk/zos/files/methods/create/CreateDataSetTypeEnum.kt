package zowe.sdk.zos.files.methods.create

import seskar.js.JsIntValue

/**
 * Enumerated type that describes the different kinds of data sets that can be created
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CreateDataSetTypeEnum {
  companion object {
    @JsIntValue(0)
    val DATA_SET_BINARY: CreateDataSetTypeEnum

    @JsIntValue(1)
    val DATA_SET_C: CreateDataSetTypeEnum

    @JsIntValue(2)
    val DATA_SET_CLASSIC: CreateDataSetTypeEnum

    @JsIntValue(3)
    val DATA_SET_PARTITIONED: CreateDataSetTypeEnum

    @JsIntValue(4)
    val DATA_SET_SEQUENTIAL: CreateDataSetTypeEnum

    @JsIntValue(5)
    val DATA_SET_BLANK: CreateDataSetTypeEnum
  }
}
