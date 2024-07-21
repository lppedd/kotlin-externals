package zowe.sdk.core.apiml.doc

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface IApimlServiceStatus {
  companion object {
    @seskar.js.JsValue("DOWN")
    val DOWN: IApimlServiceStatus

    @seskar.js.JsValue("UP")
    val UP: IApimlServiceStatus
  }
}
