package zowe.imperative.cmd.doc.handler

import js.promise.Promise
import zowe.imperative.cmd.doc.response.response.ICommandResponse
import zowe.imperative.cmd.response.CommandResponse

external interface ICommandHandlerResponseValidator {
  fun validate(response: CommandResponse): Promise<ICommandResponse>
}
