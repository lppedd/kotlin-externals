package vscode

import js.typedarrays.Uint8Array
import kotlin.ts.Union

external interface WorkspaceEditCreateFileOptions {
  /**
   * Overwrite existing file. Overwrite wins over `ignoreIfExists`
   */
  val overwrite: Boolean?

  /**
   * Do nothing if a file with `uri` exists already.
   */
  val ignoreIfExists: Boolean?

  /**
   * The initial contents of the new file.
   *
   * If creating a file from a [DocumentDropEditProvider], you can
   * pass in a [DataTransferFile] to improve performance by avoiding extra data copying.
   */
  val contents: Union<Uint8Array, DataTransferFile>?
}
