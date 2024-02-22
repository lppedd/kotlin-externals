package vscode

import js.array.ReadonlyArray

/**
 * An event that is fired after files are renamed.
 */
external interface FileRenameEvent {
  /**
   * The files that got renamed.
   */
  val files: ReadonlyArray<FileRenameInfo>
}
