@file:JsModule("@zowe/cli")

package zowe.cli.daemon

/**
 * Class containing daemon utility functions.
 */
external class DaemonUtil {
  companion object {
    /**
     * Get the directory that holds daemon-related runtime files.
     * Ensures that the directory exists, or we create it.
     *
     * @return The absolute path to the daemon directory.
     */
    fun getDaemonDir(): String
  }
}
