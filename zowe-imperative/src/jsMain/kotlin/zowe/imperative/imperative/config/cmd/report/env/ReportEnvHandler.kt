@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.report.env

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.ICommandHandler
import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Handler to report a user's wroking environment.
 *
 * We detect and report information from the user environment, including installed 3rd party
 * prerrequisites. We report those findings.
 *
 * We also maintain a set of known problem conditions (like broken NPM versions which happen way too
 * often). We use that data to report the probelem to the customer and any known workaround.
 */
external class ReportEnvHandler : ICommandHandler {
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
