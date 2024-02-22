package vscode.authentication

import vscode.AuthenticationGetSessionOptions

external interface AuthenticationGetSessionOptionsCreate : AuthenticationGetSessionOptions {
  @JsTrue
  override var createIfNone: Boolean?
}
