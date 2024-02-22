package vscode

/**
 * An event that is fired after files are deleted.
 */

external interface FileDeleteEvent {
  /**
   * The files that got deleted.
   */
  val files: Array<out Uri>
}
