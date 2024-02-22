package vscode.authentication

import vscode.AuthenticationGetSessionOptions
import vscode.JsTrue

external interface AuthenticationGetSessionOptionsCreate : AuthenticationGetSessionOptions {
  @JsTrue
  override var createIfNone: Boolean?
}
