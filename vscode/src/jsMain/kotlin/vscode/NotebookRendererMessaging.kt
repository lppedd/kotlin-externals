package vscode

/**
 * Renderer messaging is used to communicate with a single renderer. It's returned from [vscode.notebooks.createRendererMessaging].
 */
external interface NotebookRendererMessaging {
  /**
   * An event that fires when a message is received from a renderer.
   */
  val onDidReceiveMessage: Event<NotebookRendererMessage>

  /**
   * Send a message to one or all renderer.
   *
   * @param message Message to send
   * @param editor Editor to target with the message. If not provided, the
   *   message is sent to all renderers.
   * @return a boolean indicating whether the message was successfully
   *   delivered to any renderer.
   */
  fun postMessage(
    message: Any?,
    editor: NotebookEditor = definedExternally,
  ): Thenable<Boolean>
}
