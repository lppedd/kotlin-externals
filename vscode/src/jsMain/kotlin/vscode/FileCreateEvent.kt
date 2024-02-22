package vscode

/**
 * An event that is fired after files are created.
 */

external interface FileCreateEvent {
  /**
   * The files that got created.
   */
  val files: Array<out Uri>
}
