@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import node.buffer.Buffer
import node.childProcess.SpawnSyncOptions
import kotlin.ts.Union

/**
 * A collection of utilities related to executing a sub-process.
 */
external class ExecUtils {
  companion object {
    /**
     * Spawn a process with arguments and throw an error if the process fails. Parameters are same
     * as `child_process.spawnSync` (see Node.js docs). Use this method if you want the safe
     * argument parsing of `spawnSync` combined with the smart output handling of `execSync`.
     *
     * @return Contents of stdout as buffer or string
     */
    fun spawnAndGetOutput(
      command: String,
      args: Array<String> = definedExternally,
      options: SpawnSyncOptions = definedExternally,
    ): Union<Buffer, String> // Buffer | string
  }
}
