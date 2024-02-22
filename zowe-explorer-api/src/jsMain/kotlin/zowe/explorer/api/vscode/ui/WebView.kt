@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.vscode.ui

import js.promise.Promise
import vscode.ExtensionContext
import vscode.Union
import vscode.WebviewPanel

external class WebView {
  /**
   * Constructs a webview for use with bundled assets.
   * The webview entrypoint must be located at src/<webview folder>/dist/<webview-name>/index.js.
   *
   * @param title The title for the new webview
   * @param webviewName The webview name, the same name given to the directory of your webview in the webviews/src directory.
   * @param context The VSCode extension context
   * @param onDidReceiveMessage Event callback: called when messages are received from the webview
   */
  constructor(
    title: String,
    webviewName: String,
    context: ExtensionContext,
    onDidReceiveMessage: (
      message: Any,
    ) -> Union<Unit, Promise<Unit>> = definedExternally,
    retainContext: Boolean = definedExternally,
  )

  var panel: WebviewPanel

  /**
   * Pre-processed HTML content that loads the bundled script through the webview.
   */
  val htmlContent: String
}
