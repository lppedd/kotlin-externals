@file:JsModule("vscode")
@file:JsQualifier("debug")

package vscode.debug

import vscode.DebugProtocolSource
import vscode.DebugSession
import vscode.Uri

/**
 * Converts a "Source" descriptor object received via the Debug Adapter Protocol into a Uri that can be used to load its contents.
 * If the source descriptor is based on a path, a file Uri is returned.
 * If the source descriptor uses a reference number, a specific debug Uri (scheme 'debug') is constructed that requires a corresponding ContentProvider and a running debug session
 *
 * If the "Source" descriptor has insufficient information for creating the Uri, an error is thrown.
 *
 * @param source An object conforming to the [Source](https://microsoft.github.io/debug-adapter-protocol/specification#Types_Source) type defined in the Debug Adapter Protocol.
 * @param session An optional debug session that will be used when the source descriptor uses a reference number to load the contents from an active debug session.
 * @return A uri that can be used to load the contents of the source.
 */
external fun asDebugSourceUri(
  source: DebugProtocolSource,
  session: DebugSession = definedExternally,
): Uri
