package vscode.window

external interface RegisterWebviewViewProviderOptions {
  /**
   * Content settings for the webview created for this view.
   */
  val webviewOptions: WebviewOptions?
}
