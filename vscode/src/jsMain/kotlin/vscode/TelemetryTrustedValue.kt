@file:JsModule("vscode")

package vscode

/**
 * A special value wrapper denoting a value that is safe to not clean.
 * This is to be used when you can guarantee no identifiable information is contained in the value and the cleaning is improperly redacting it.
 */
external class TelemetryTrustedValue<T : Any? /* default is Any? */> {
  /**
   * Creates a new telementry trusted value.
   *
   * @param value A value to trust
   */
  constructor(value: T)

  /**
   * The value that is trusted to not contain PII.
   */
  val value: T
}
