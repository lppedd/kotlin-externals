package vscode

import kotlin.ts.Readonly

/**
 * An individual terminal instance within the integrated terminal.
 */
external interface Terminal {
  /**
   * The name of the terminal.
   */
  val name: String

  /**
   * The process ID of the shell process.
   */
  val processId: Thenable<Int?>

  /**
   * The object used to initialize the terminal, this is useful for example to detecting the
   * shell type of when the terminal was not launched by this extension or for detecting what
   * folder the shell was launched in.
   */
  val creationOptions: Union<@Readonly TerminalOptions, @Readonly ExtensionTerminalOptions>

  /**
   * The exit status of the terminal, this will be undefined while the terminal is active.
   *
   * **Example:** Show a notification with the exit code when the terminal exits with a
   * non-zero exit code.
   * ```typescript
   * window.onDidCloseTerminal(t => {
   *   if (t.exitStatus && t.exitStatus.code) {
   *   	vscode.window.showInformationMessage(`Exit code: ${t.exitStatus.code}`);
   *   }
   * });
   * ```
   */
  val exitStatus: TerminalExitStatus?

  /**
   * The current state of the [Terminal].
   */
  val state: TerminalState

  /**
   * Send text to the terminal. The text is written to the stdin of the underlying pty process
   * (shell) of the terminal.
   *
   * @param text The text to send.
   * @param shouldExecute Indicates that the text being sent should be executed rather than just inserted in the terminal.
   *   The character(s) added are \n or \r\n, depending on the platform. This defaults to `true`.
   */
  fun sendText(
    text: String,
    shouldExecute: Boolean = definedExternally,
  )

  /**
   * Show the terminal panel and reveal this terminal in the UI.
   *
   * @param preserveFocus When `true` the terminal will not take focus.
   */
  fun show(preserveFocus: Boolean = definedExternally)

  /**
   * Hide the terminal panel if this terminal is currently showing.
   */
  fun hide()

  /**
   * Dispose and free associated resources.
   */
  fun dispose()
}
