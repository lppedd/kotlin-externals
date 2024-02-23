@file:JsModule("vscode")
@file:JsQualifier("authentication")

package vscode.authentication

import vscode.AuthenticationSessionsChangeEvent
import vscode.Event

/**
 * An [Event] which fires when the authentication sessions of an authentication provider have
 * been added, removed, or changed.
 */
external val onDidChangeSessions: Event<AuthenticationSessionsChangeEvent>
