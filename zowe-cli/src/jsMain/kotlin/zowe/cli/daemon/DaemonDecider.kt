@file:JsModule("@zowe/cli")

package zowe.cli.daemon

/**
 * Initial paramter parse to handle conditionally starting as a persistent process (e.g. daemon mode)
 */
external class DaemonDecider {
  /**
   * Creates an instance of DaemonDecider.
   * @param mParms
   */
  constructor(mParms: Array<String>)

  /**
   * Initialize our DaemonDecider parse and optionally start the server
   */
  fun init()

  /**
   * Method to immediately parse or otherwise start the server for later processing from
   * incoming socket connections.
   */
  fun runOrUseDaemon()
}
