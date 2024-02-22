package zowe.explorer.api.vscode.doc

import vscode.InputBoxOptions

external interface IPromptCredentialsCommonOptions {
  var rePrompt: Boolean?
  var userInputBoxOptions: InputBoxOptions?
  var passwordInputBoxOptions: InputBoxOptions?
}
