package vscode.authentication

import vscode.AuthenticationForceNewSessionOptions
import vscode.AuthenticationGetSessionOptions
import vscode.JsTrue
import vscode.Union

external interface AuthenticationGetSessionOptionsForce : AuthenticationGetSessionOptions {
  @JsTrue
  override var forceNewSession: Union<Boolean, AuthenticationForceNewSessionOptions>? // true | AuthenticationForceNewSessionOptions
}
