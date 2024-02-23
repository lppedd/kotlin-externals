package vscode.authentication

import vscode.AuthenticationForceNewSessionOptions
import vscode.AuthenticationGetSessionOptions
import kotlin.ts.Union

external interface AuthenticationGetSessionOptionsForce : AuthenticationGetSessionOptions {
  override var forceNewSession: Union<`true`, AuthenticationForceNewSessionOptions>? // true | AuthenticationForceNewSessionOptions
}
