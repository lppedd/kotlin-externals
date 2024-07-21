package zowe.imperative.cmd.doc

/**
 * Command Segment type - either "group" or "command".
 *
 * "group" implies no handler and should have children. Use groups to logically arrange portions of
 * your CLI. "command" implies there is a handler and may or may not have children.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ICommandNodeType {
  companion object {
    @seskar.js.JsValue("group")
    val group: ICommandNodeType

    @seskar.js.JsValue("command")
    val command: ICommandNodeType
  }
}
