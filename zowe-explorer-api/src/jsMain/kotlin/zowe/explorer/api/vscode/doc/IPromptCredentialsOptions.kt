package zowe.explorer.api.vscode.doc

import zowe.imperative.profiles.doc.response.IProfileLoaded

external interface IPromptCredentialsOptions : IPromptCredentialsCommonOptions {
  var profile: IProfileLoaded?
  var sessionName: String?
  var sessionType: String?
  var secure: Boolean?
}
