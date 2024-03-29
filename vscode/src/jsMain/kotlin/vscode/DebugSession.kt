package vscode

/**
 * A debug session.
 */
external interface DebugSession {
  /**
   * The unique ID of this debug session.
   */
  val id: String

  /**
   * The debug session's type from the [DebugConfiguration].
   */
  val type: String

  /**
   * The parent session of this debug session, if it was created as a child.
   * @see DebugSessionOptions.parentSession
   */
  val parentSession: DebugSession?

  /**
   * The debug session's name is initially taken from the [DebugConfiguration].
   * Any changes will be properly reflected in the UI.
   */
  var name: String

  /**
   * The workspace folder of this session or `undefined` for a folderless setup.
   */
  val workspaceFolder: WorkspaceFolder?

  /**
   * The "resolved" [DebugConfiguration] of this session.
   * "Resolved" means that
   * - all variables have been substituted and
   * - platform specific attribute sections have been "flattened" for the matching platform and removed for non-matching platforms.
   */
  val configuration: DebugConfiguration

  /**
   * Send a custom request to the debug adapter.
   */
  fun customRequest(
    command: String,
    args: Any? = definedExternally,
  ): Thenable<Any?>

  /**
   * Maps a breakpoint in the editor to the corresponding Debug Adapter Protocol (DAP) breakpoint that is managed by the debug adapter of the debug session.
   * If no DAP breakpoint exists (either because the editor breakpoint was not yet registered or because the debug adapter is not interested in the breakpoint), the value `undefined` is returned.
   *
   * @param breakpoint A [Breakpoint] in the editor.
   * @return A promise that resolves to the Debug Adapter Protocol breakpoint or `undefined`.
   */
  fun getDebugProtocolBreakpoint(breakpoint: Breakpoint): Thenable<DebugProtocolBreakpoint?>
}
