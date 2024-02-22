@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.yargs.doc

/**
 * Indicates the action performed.
 */
@seskar.js.JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ImperativeYargsCommandAction {
  companion object {
    @seskar.js.JsValue("syntax validation")
    val syntaxValidation: ImperativeYargsCommandAction

    @seskar.js.JsValue("command handler invoked")
    val commandHandlerInvoked: ImperativeYargsCommandAction

    @seskar.js.JsValue("help invoked")
    val helpInvoked: ImperativeYargsCommandAction
  }
}
