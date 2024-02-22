@file:JsModule("vscode")

package vscode.window

import vscode.IDisposable
import vscode.WebviewPanelSerializer

/**
 * Registers a webview panel serializer.
 *
 * Extensions that support reviving should have an `"onWebviewPanel:viewType"` activation event and
 * make sure that `registerWebviewPanelSerializer` is called during activation.
 *
 * Only a single serializer may be registered at a time for a given `viewType`.
 *
 * @param viewType Type of the webview panel that can be serialized.
 * @param serializer Webview serializer.
 * @return A [IDisposable] that unregisters the serializer.
 */
external fun registerWebviewPanelSerializer(
  viewType: String,
  serializer: WebviewPanelSerializer<Any?>,
): IDisposable
