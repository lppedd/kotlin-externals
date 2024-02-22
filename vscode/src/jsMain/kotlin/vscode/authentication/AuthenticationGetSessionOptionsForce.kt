package vscode.authentication

import vscode.AuthenticationForceNewSessionOptions
import vscode.AuthenticationGetSessionOptions
import kotlin.ts.Union

external interface AuthenticationGetSessionOptionsForce : AuthenticationGetSessionOptions {
  @JsTrue
  override var forceNewSession: Union<Boolean, AuthenticationForceNewSessionOptions>? // true | AuthenticationForceNewSessionOptions
}
