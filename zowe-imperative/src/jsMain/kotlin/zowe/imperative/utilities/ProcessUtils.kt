@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import js.promise.Promise
import node.buffer.Buffer
import node.childProcess.SpawnSyncOptions
import zowe.imperative.utilities.doc.ISystemInfo
import kotlin.ts.Union

/**
 * A collection of utilities related to the running process.
 */
external class ProcessUtils {
  companion object {
    /**
     * Process utility to wrap callback process routines into promises Turn nextTick into a promise
     * to prevent nesting
     *
     * @param callback called before promise is resolved
     * @param args arguments passed to the callback
     * @return fulfilled whenever callback is invoked
     */
    fun nextTick(
      callback: (args: Array<Any?>) -> Unit, // (...args: any[]) => void
      vararg args: Any?,
    ): Promise<Unit>

    /**
     * Is a Graphical User Interface available in the environment in which the current command is running?
     *
     * @return True if GUI. False when no GUI.
     */
    fun isGuiAvailable(): GuiResult

    /**
     * Get some basic information about the system
     */
    fun getBasicSystemInfo(): ISystemInfo

    /**
     * Open a file or URL in the default application associated with its file extension or URL
     * protocol. This method is only supported in graphical environments.
     *
     * @param pathOrUrl File path or Internet URL to open
     */
    fun openInDefaultApp(pathOrUrl: String)

    /**
     * Open a file in the best editor that can be found in the current environment. In a graphical
     * environment, the default application associated with its file extension will be launched. In
     * a command-line environment, the file will be opened in vi, or the editor in the the
     * `{envVariablePrefix}_EDITOR` environment variable if specified.
     *
     * @param filePath File path to edit
     * @param editorOpt Chosen editor, can be a path or a valid environment variable name
     * @param sync Boolean where true == synchronous and false == asynchronous
     */
    fun openInEditor(
      filePath: String,
      editorOpt: String = definedExternally,
      sync: Boolean = definedExternally,
    )

    /**
     * Spawn a process with arguments and throw an error if the process fails. Parameters are same
     * as `child_process.spawnSync` (see Node.js docs). Use this method if you want the safe
     * argument parsing of `spawnSync` combined with the smart output handling of `execSync`.
     *
     * @return Contents of stdout as buffer or string
     */
    @Deprecated("Use ExecUtils.spawnAndGetOutput instead")
    fun execAndCheckOutput(
      command: String,
      args: Array<String> = definedExternally,
      options: SpawnSyncOptions = definedExternally,
    ): Union<Buffer, String> // Buffer | string
  }
}
