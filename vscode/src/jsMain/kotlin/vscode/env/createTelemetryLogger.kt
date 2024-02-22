@file:JsModule("vscode")

package vscode.env

import vscode.TelemetryLogger
import vscode.TelemetryLoggerOptions
import vscode.TelemetrySender

/**
 * Creates a new [TelemetryLogger].
 *
 * @param sender The telemetry sender that is used by the telemetry logger.
 * @param options Options for the telemetry logger.
 * @return A new telemetry logger
 */
external fun createTelemetryLogger(
  sender: TelemetrySender,
  options: TelemetryLoggerOptions = definedExternally,
): TelemetryLogger
