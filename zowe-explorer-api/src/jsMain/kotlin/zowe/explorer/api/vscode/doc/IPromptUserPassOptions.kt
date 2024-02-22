package zowe.explorer.api.vscode.doc

import zowe.imperative.rest.session.doc.ISession

external interface IPromptUserPassOptions : IPromptCredentialsCommonOptions {
  var session: ISession
}
