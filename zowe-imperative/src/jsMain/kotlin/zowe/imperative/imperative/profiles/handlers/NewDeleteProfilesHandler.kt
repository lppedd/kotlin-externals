@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.handlers

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters

external class NewDeleteProfilesHandler {
  fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
