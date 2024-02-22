package zowe.imperative.cmd.doc.response.api.handler

import zowe.imperative.cmd.doc.response.parms.IProgressBarParms

/**
 * Progress bar APIs for the command handler. Use these methods to start and end progress bars. Only
 * one bar can be active at any given time. Progress bars are displayed at the users
 * terminal/console (indicates/updates with progress) and are NOT shown
 */
external interface IHandlerProgressApi {
  /**
   * Start a progress bar - displays on the users terminal. Only one progress bar can be active at
   * any given time.
   *
   * @param params See the interface for details.
   */
  fun startBar(params: IProgressBarParms)

  /**
   * Ends an outstanding progress bar (does nothing if no progress bars have been started).
   */
  fun endBar()
}
