package vscode.authentication

import vscode.AuthenticationGetSessionOptions

external interface AuthenticationGetSessionOptionsCreate : AuthenticationGetSessionOptions {
  override var createIfNone: `true`?
}
