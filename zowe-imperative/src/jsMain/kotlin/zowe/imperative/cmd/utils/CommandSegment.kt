package zowe.imperative.cmd.utils

/**
 * The command segment represents the "level" you are at in the command (for help generation)
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CommandSegment {
  companion object {
    @seskar.js.JsValue("group")
    val group: CommandSegment

    @seskar.js.JsValue("command")
    val command: CommandSegment
  }
}
