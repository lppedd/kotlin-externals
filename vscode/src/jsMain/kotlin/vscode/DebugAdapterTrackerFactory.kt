package vscode

/**
 * A debug adaper factory that creates [DebugAdapterTracker]s.
 */
external interface DebugAdapterTrackerFactory {
  /**
   * The method 'createDebugAdapterTracker' is called at the start of a debug session in order
   * to return a "tracker" object that provides read-access to the communication between the editor and a debug adapter.
   *
   * @param session The [DebugSession] for which the debug adapter tracker will be used.
   * @return A [DebugAdapterTracker] or undefined.
   */
  fun createDebugAdapterTracker(session: DebugSession): ProviderResult<DebugAdapterTracker>
}
