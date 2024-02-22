package vscode

import js.array.ReadonlyArray

external interface FileSystemProviderWatchOptions {
  /**
   * When enabled also watch subfolders.
   */
  val recursive: Boolean

  /**
   * A list of paths and pattern to exclude from watching.
   */
  val excludes: ReadonlyArray<String>
}
