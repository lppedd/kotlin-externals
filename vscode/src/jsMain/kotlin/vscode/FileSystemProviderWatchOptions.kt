package vscode

external interface FileSystemProviderWatchOptions {
/**
   * When enabled also watch subfolders.
   */
  val recursive: Boolean

/**
   * A list of paths and pattern to exclude from watching.
   */
  val excludes: Array<out String>
}
