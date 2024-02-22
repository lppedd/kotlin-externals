package vscode

/**
 * The event that is fired when diagnostics change.
 */

external interface DiagnosticChangeEvent {
  /**
   * An array of resources for which diagnostics have changed.
   */
  val uris: Array<out Uri>
}
