package zowe.imperative.imperative.config.cmd.report.env

import zowe.imperative.cmd.doc.response.api.handler.IHandlerProgressApi

/**
 * This interface represents the the options for getEnvItemVal().
 */
external interface IGetItemOpts {
  /**
   * API to start/end progress bar for long running actions. Since this is a CLI thing, it is
   * optional in case non-CLI programs want to call the getEnvItemVal function.
   */
  var progressApi: IHandlerProgressApi?
}
