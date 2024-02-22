package vscode

/**
 * A debug adaper factory that creates [DebugAdapterTracker debug adapter trackers].
 */

external interface DebugAdapterTrackerFactory {
/**
   * The method 'createDebugAdapterTracker' is called at the start of a debug session in order
   * to return a "tracker" object that provides read-access to the communication between the editor and a debug adapter.
   *
   * @param session The [DebugSession debug session] for which the debug adapter tracker will be used.
   * @return A [DebugAdapterTracker debug adapter tracker] or undefined.
   */
  fun createDebugAdapterTracker(session: DebugSession): ProviderResult<DebugAdapterTracker>
}
