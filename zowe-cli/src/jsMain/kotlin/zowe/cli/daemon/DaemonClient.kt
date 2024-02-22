@file:JsModule("@zowe/cli")

package zowe.cli.daemon

import node.net.Server
import node.net.Socket

/**
 * Class for handling client connections to our persistent service (e.g. daemon mode)
 */
external class DaemonClient {
  /**
   * Creates an instance of DaemonClient.
   * @param mClient
   * @param mServer
   * @param mOwner
   */
  constructor(mClient: Socket, mServer: Server, mOwner: String)

  /**
   * Run an instance of this client and wait for proper events
   */
  fun run()
}
