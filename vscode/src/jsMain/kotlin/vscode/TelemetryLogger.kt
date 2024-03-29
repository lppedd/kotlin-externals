package vscode

import js.errors.JsError
import js.objects.Record
import kotlin.ts.Union

/**
 * A telemetry logger which can be used by extensions to log usage and error telementry.
 *
 * A logger wraps around an [TelemetrySender] but it guarantees that
 * - user settings to disable or tweak telemetry are respected, and that
 * - potential sensitive data is removed
 *
 * It also enables an "echo UI" that prints whatever data is send and it allows the editor
 * to forward unhandled errors to the respective extensions.
 *
 * To get an instance of a `TelemetryLogger`, use
 * [vscode.env.createTelemetryLogger].
 */
external interface TelemetryLogger {
  /**
   * An [Event] which fires when the enablement state of usage or error telemetry changes.
   */
  val onDidChangeEnableStates: Event<TelemetryLogger>

  /**
   * Whether or not usage telemetry is enabled for this logger.
   */
  val isUsageEnabled: Boolean

  /**
   * Whether or not error telemetry is enabled for this logger.
   */
  val isErrorsEnabled: Boolean

  /**
   * Log a usage event.
   *
   * After completing cleaning, telemetry setting checks, and data mix-in calls `TelemetrySender.sendEventData` to log the event.
   * Automatically supports echoing to extension telemetry output channel.
   * @param eventName The event name to log
   * @param data The data to log
   */
  fun logUsage(
    eventName: String,
    data: Record<String, Union<Any, TelemetryTrustedValue<Any?>>?> = definedExternally,
  )

  /**
   * Log an error event.
   *
   * After completing cleaning, telemetry setting checks, and data mix-in calls `TelemetrySender.sendEventData` to log the event.
   * Differs from `logUsage` in that it will log the event if the telemetry setting is Error+.
   * Automatically supports echoing to extension telemetry output channel.
   * @param eventName The event name to log
   * @param data The data to log
   */
  fun logError(
    eventName: String,
    data: Record<String, Union<Any, TelemetryTrustedValue<Any?>>?> = definedExternally,
  )

  /**
   * Log an error event.
   *
   * Calls `TelemetrySender.sendErrorData`. Does cleaning, telemetry checks, and data mix-in.
   * Automatically supports echoing to extension telemetry output channel.
   * Will also automatically log any exceptions thrown within the extension host process.
   * @param error The error object which contains the stack trace cleaned of PII
   * @param data Additional data to log alongside the stack trace
   */
  fun logError(
    error: JsError,
    data: Record<String, Union<Any, TelemetryTrustedValue<Any?>>?> = definedExternally,
  )

  /**
   * Dispose this object and free resources.
   */
  fun dispose()
}
