package zowe.imperative.cmd.help.doc

import zowe.imperative.cmd.doc.response.api.handler.IHandlerResponseApi

/**
 * Web help manager API that handles launching of web help and generating it if necessary.
 */
external interface IWebHelpManager {
  /**
   * Launch root help page in browser.
   *
   * @param cmdResponse Command response object to use for output
   */
  fun openRootHelp(cmdResponse: IHandlerResponseApi)

  /**
   * Launch help page for specific group/command in browser.
   *
   * @param inContext Name of page for group/command to jump to
   * @param cmdResponse Command response object to use for output
   */
  fun openHelp(
    inContext: String,
    cmdResponse: IHandlerResponseApi,
  )
}
