package vscode

import js.array.ReadonlyArray

/**
 * An event that is fired when files are going to be renamed.
 *
 * To make modifications to the workspace before the files are renamed,
 * call the [FileWillCreateEvent.waitUntil]-function with a
 * thenable that resolves to a [WorkspaceEdit].
 */
external interface FileWillRenameEvent {
  /**
   * A cancellation token.
   */
  val token: CancellationToken

  /**
   * The files that are going to be renamed.
   */
  val files: ReadonlyArray<FileRenameInfo>

  /**
   * Allows to pause the event until the provided thenable resolves.
   *
   * *Note:* This function can only be called during event dispatch.
   *
   * @param thenable A thenable that delays saving.
   */
  fun waitUntil(thenable: Thenable<Any?>)
}
