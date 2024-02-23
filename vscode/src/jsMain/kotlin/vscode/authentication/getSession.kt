@file:JsModule("vscode")
@file:JsQualifier("authentication")

package vscode.authentication

import js.array.ReadonlyArray
import vscode.AuthenticationGetSessionOptions
import vscode.AuthenticationSession
import vscode.Thenable

/**
 * Get an authentication session matching the desired scopes. Rejects if a provider with providerId is not
 * registered, or if the user does not consent to sharing authentication information with
 * the extension. If there are multiple sessions with the same scopes, the user will be shown a
 * quickpick to select which account they would like to use.
 *
 * Currently, there are only two authentication providers that are contributed from built in extensions
 * to the editor that implement GitHub and Microsoft authentication: their providerId's are 'github' and 'microsoft'.
 * @param providerId The id of the provider to use
 * @param scopes A list of scopes representing the permissions requested. These are dependent on the authentication provider
 * @param options The [AuthenticationGetSessionOptions] to use
 * @return A thenable that resolves to an authentication session
 */
external fun getSession(
  providerId: String,
  scopes: ReadonlyArray<String>,
  options: AuthenticationGetSessionOptionsCreate,
): Thenable<AuthenticationSession>

/**
 * Get an authentication session matching the desired scopes. Rejects if a provider with providerId is not
 * registered, or if the user does not consent to sharing authentication information with
 * the extension. If there are multiple sessions with the same scopes, the user will be shown a
 * quickpick to select which account they would like to use.
 *
 * Currently, there are only two authentication providers that are contributed from built in extensions
 * to the editor that implement GitHub and Microsoft authentication: their providerId's are 'github' and 'microsoft'.
 * @param providerId The id of the provider to use
 * @param scopes A list of scopes representing the permissions requested. These are dependent on the authentication provider
 * @param options The [AuthenticationGetSessionOptions] to use
 * @return A thenable that resolves to an authentication session
 */
external fun getSession(
  providerId: String,
  scopes: ReadonlyArray<String>,
  options: AuthenticationGetSessionOptionsForce,
): Thenable<AuthenticationSession>

/**
 * Get an authentication session matching the desired scopes. Rejects if a provider with providerId is not
 * registered, or if the user does not consent to sharing authentication information with
 * the extension. If there are multiple sessions with the same scopes, the user will be shown a
 * quickpick to select which account they would like to use.
 *
 * Currently, there are only two authentication providers that are contributed from built in extensions
 * to the editor that implement GitHub and Microsoft authentication: their providerId's are 'github' and 'microsoft'.
 * @param providerId The id of the provider to use
 * @param scopes A list of scopes representing the permissions requested. These are dependent on the authentication provider
 * @param options The [AuthenticationGetSessionOptions] to use
 * @return A thenable that resolves to an authentication session if available, or undefined if there are no sessions
 */
external fun getSession(
  providerId: String,
  scopes: ReadonlyArray<String>,
  options: AuthenticationGetSessionOptions = definedExternally,
): Thenable<AuthenticationSession?>
