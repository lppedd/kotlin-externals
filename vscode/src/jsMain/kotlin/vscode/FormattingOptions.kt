package vscode

/**
 * Value-object describing what options formatting should use.
 */
external interface FormattingOptions {
  /**
   * Size of a tab in spaces.
   */
  var tabSize: Int

  /**
   * Prefer spaces over tabs.
   */
  var insertSpaces: Boolean

  /**
   * Signature for further properties.
   */
  @seskar.js.JsNative
  operator fun get(key: String): Union3<Boolean, Number, String>? // boolean | number | string

  @seskar.js.JsNative
  operator fun set(key: String, value: Union3<Boolean, Number, String>? /* boolean | number | string */)
}
