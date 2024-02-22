package vscode

external interface FileSystemProviderWriteFileOptions {
  /**
   * Create the file if it does not exist already.
   */
  val create: Boolean

  /**
   * Overwrite the file if it does exist.
   */
  val overwrite: Boolean
}
