@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.help

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseApi
import zowe.imperative.cmd.help.doc.IWebHelpManager

/**
 * Imperative web help manager.
 * Single instance class used to launch web help in browser which
 * handles (re)building web help files first if necessary.
 */
external class WebHelpManager : IWebHelpManager {
  /**
   * Launch root help page in browser.
   *
   * @param cmdResponse Command response object to use for output
   */
  override fun openRootHelp(cmdResponse: IHandlerResponseApi)

  /**
   * Launch help page for specific group/command in browser.
   *
   * @param inContext Name of page for group/command to jump to
   * @param cmdResponse Command response object to use for output
   */
  override fun openHelp(
    inContext: String,
    cmdResponse: IHandlerResponseApi,
  )

  /**
   * Record a reference to our CLI's full command tree.
   */
  var fullCommandTree: ICommandDefinition

  companion object {
    /**
     * Return a singleton instance of this class
     */
    val instance: WebHelpManager
  }
}
