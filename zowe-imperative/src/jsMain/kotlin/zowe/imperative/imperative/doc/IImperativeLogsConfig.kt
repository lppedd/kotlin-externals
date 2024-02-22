package zowe.imperative.imperative.doc

external interface IImperativeLogsConfig {
  /**
   * Use this property to configure imperative logging preferences. Defaults are provided and this
   * property must only be supplied to override defaults. See the IImperativeLoggingConfig document
   * for more information.
   */
  var imperativeLogging: IImperativeLoggingConfig?

  /**
   * Use this property to configure your applications logging preferences. Defaults are provided and
   * this property must only be supplied to override defaults. See the IImperativeLoggingConfig
   * document for more information.
   */
  var appLogging: IImperativeLoggingConfig?

  /**
   * Use this property to configure additional log files and preferences if needed.
   */
  var additionalLogging: Array<IImperativeLoggingConfig>?

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
