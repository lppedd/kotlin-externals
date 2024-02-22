@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface IConfigUpdateSchemaOptionsLayer {
  companion object {
    @seskar.js.JsValue("active")
    val active: IConfigUpdateSchemaOptionsLayer

    @seskar.js.JsValue("global")
    val global: IConfigUpdateSchemaOptionsLayer

    @seskar.js.JsValue("all")
    val all: IConfigUpdateSchemaOptionsLayer
  }
}
