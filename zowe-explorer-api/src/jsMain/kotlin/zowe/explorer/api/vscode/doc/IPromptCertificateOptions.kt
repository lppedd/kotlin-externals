package zowe.explorer.api.vscode.doc

import vscode.OpenDialogOptions
import zowe.imperative.profiles.doc.response.IProfileLoaded

external interface IPromptCertificateOptions : IPromptUserPassOptions {
  var openDialogOptions: OpenDialogOptions?
  var profile: IProfileLoaded?
}
