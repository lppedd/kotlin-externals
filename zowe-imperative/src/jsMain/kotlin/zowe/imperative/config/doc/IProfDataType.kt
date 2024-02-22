@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

/**
 * The type of data for this property
 */
@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface IProfDataType {
  companion object {
    @seskar.js.JsValue("string")
    val string: IProfDataType

    @seskar.js.JsValue("number")
    val number: IProfDataType

    @seskar.js.JsValue("boolean")
    val boolean: IProfDataType

    @seskar.js.JsValue("array")
    val array: IProfDataType

    @seskar.js.JsValue("object")
    val `object`: IProfDataType
  }
}
