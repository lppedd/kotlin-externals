package zowe.imperative.cmd.doc.handler

import js.promise.Promise
import zowe.imperative.cmd.response.CommandResponse

external interface ICommandHandlerResponseChecker {
  fun process(response: CommandResponse): Promise<Boolean>
}
