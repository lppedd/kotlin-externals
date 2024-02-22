package vscode

/**
 * An event that is fired when files are going to be deleted.
 *
 * To make modifications to the workspace before the files are deleted,
 * call the [FileWillCreateEvent.waitUntil `waitUntil`]-function with a
 * thenable that resolves to a [WorkspaceEdit workspace edit].
 */

external interface FileWillDeleteEvent {
  /**
   * A cancellation token.
   */
  val token: CancellationToken

  /**
   * The files that are going to be deleted.
   */
  val files: Array<out Uri>

  /**
   * Allows to pause the event until the provided thenable resolves.
   *
   * *Note:* This function can only be called during event dispatch.
   *
   * @param thenable A thenable that delays saving.
   */
  fun waitUntil(thenable: Thenable<Any?>): Unit
}
