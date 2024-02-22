@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.globals

import js.promise.Promise
import vscode.Thenable
import zowe.explorer.api.tree.IZoweTree
import zowe.explorer.api.tree.IZoweTreeNode

external object Gui {
  /**
   * Creates a new output channel with the given name and language ID
   * @param name The desired name for the output channel
   * @param languageId Identifier associated with the language for this output channel
   * @return The new output channel with the specified options
   *
   * @see vscode.window.createOutputChannel for more details
   */
  fun createOutputChannel(
    name: String,
    languageId: String = definedExternally,
  ): vscode.OutputChannel

  /**
   * Creates a QuickPick within VS Code with more flexible options than `quickPick`
   * @return A new QuickPick object
   *
   * @see vscode.window.createQuickPick for more details
   */
  fun <T : vscode.QuickPickItem> createQuickPick(): vscode.QuickPick<T>

  /**
   * Creates a TreeView given the specified view ID and options
   * @param viewId The ID contributed by `views`
   * @param options Any options for creating the tree view
   * @return A new TreeView object of the provided type
   *
   * @see vscode.window.createTreeView for more details
   */
  fun <T> createTreeView(
    viewId: String,
    options: vscode.TreeViewOptions<T>,
  ): vscode.TreeView<T>

  /**
   * Create and show a new webview panel
   * @param options Settings for the new panel (@see WebviewOptions for more info)
   *
   * @see vscode.window.createWebviewPanel for more details
   */
  fun createWebviewPanel(options: WebviewOptionsViewColumn): vscode.WebviewPanel

  /**
   * Create and show a new webview panel
   * @param options Settings for the new panel (@see WebviewOptions for more info)
   *
   * @see vscode.window.createWebviewPanel for more details
   */
  fun createWebviewPanel(options: WebviewOptionsShowOptions): vscode.WebviewPanel

  /**
   * Wrapper function for `showMessage` to display an error message.
   * @param message The message to display
   * @param options Additional options for the displayed message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun errorMessage(
    message: String,
    options: GuiMessageOptionsStringBase = definedExternally,
  ): Thenable<String?>

  /**
   * Wrapper function for `showMessage` to display an error message.
   * @param message The message to display
   * @param options Additional options for the displayed message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun errorMessage(
    message: String,
    options: GuiMessageOptionsMessageItemBase = definedExternally,
  ): Thenable<vscode.MessageItem?>

  /**
   * Wrapper function for `showMessage` to display an informational message.
   * @param message The message to display
   * @param options Additional options for the displayed message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun infoMessage(
    message: String,
    options: GuiMessageOptionsStringBase = definedExternally,
  ): Thenable<String?>

  /**
   * Wrapper function for `showMessage` to display an informational message.
   * @param message The message to display
   * @param options Additional options for the displayed message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun infoMessage(
    message: String,
    options: GuiMessageOptionsMessageItemBase = definedExternally,
  ): Thenable<vscode.MessageItem?>

  /**
   * Wrapper function for `showMessage` to display a warning message.
   * @param message The message to display
   * @param options Additional options for the displayed message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun warningMessage(
    message: String,
    options: GuiMessageOptionsStringBase = definedExternally,
  ): Thenable<String?>

  /**
   * Wrapper function for `showMessage` to display a warning message.
   * @param message The message to display
   * @param options Additional options for the displayed message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun warningMessage(
    message: String,
    options: GuiMessageOptionsMessageItemBase = definedExternally,
  ): Thenable<vscode.MessageItem?>

  /**
   * Shows an input box within VS Code using the specified options.
   * @param options All options for the input box
   * @return The user's response, or `undefined` if the input box was dismissed.
   *
   * @see vscode.window.showInputBox for more details
   */
  fun showInputBox(options: vscode.InputBoxOptions): Thenable<String?>

  /**
   * Shows a file open dialog to the user which allows for file selection
   * @param options Configure the behavior of the open file dialog
   * @return A promise containing the selected resource(s) or `undefined`
   *
   * @see vscode.window.showOpenDialog for more details
   */
  fun showOpenDialog(options: vscode.OpenDialogOptions = definedExternally): Thenable<Array<vscode.Uri>>

  fun setStatusBarMessage(
    text: String,
    hideAfterTimeout: Thenable<Any?>,
  ): vscode.Disposable

  fun setStatusBarMessage(
    text: String,
    hideAfterTimeout: Int,
  ): vscode.Disposable

  fun setStatusBarMessage(text: String): vscode.Disposable

  /**
   * Builds the specified QuickPick result based on user interaction.
   * @param quickpick The QuickPick object to resolve
   * @return A promise containing the result of the QuickPick
   */
  fun resolveQuickPick(quickpick: vscode.QuickPick<vscode.QuickPickItem>): Promise<vscode.QuickPickItem?>

  /**
   *
   * @param items An array of items, or a promise that resolves to an array of items
   * @param options VS Code options for the quick pick's behavior
   * @param token A token used to signal cancellation for the quick pick
   *
   * @see vscode.window.showQuickPick for more details
   */
  fun showQuickPick(
    items: js.array.ReadonlyArray<String>,
    options: vscode.QuickPickOptions = definedExternally,
    token: vscode.CancellationToken = definedExternally,
  ): Thenable<String?>

  /**
   *
   * @param items An array of items, or a promise that resolves to an array of items
   * @param options VS Code options for the quick pick's behavior
   * @param token A token used to signal cancellation for the quick pick
   *
   * @see vscode.window.showQuickPick for more details
   */
  fun showQuickPick(
    items: Thenable<js.array.ReadonlyArray<String>>,
    options: vscode.QuickPickOptions = definedExternally,
    token: vscode.CancellationToken = definedExternally,
  ): Thenable<String?>

  /**
   *
   * @param items An array of items, or a promise that resolves to an array of items
   * @param options VS Code options for the quick pick's behavior
   * @param token A token used to signal cancellation for the quick pick
   *
   * @see vscode.window.showQuickPick for more details
   */
  fun showQuickPick(
    items: js.array.ReadonlyArray<String>,
    options: ShowQuickPickOptions = definedExternally,
    token: vscode.CancellationToken = definedExternally,
  ): Thenable<Array<String>?>

  /**
   *
   * @param items An array of items, or a promise that resolves to an array of items
   * @param options VS Code options for the quick pick's behavior
   * @param token A token used to signal cancellation for the quick pick
   *
   * @see vscode.window.showQuickPick for more details
   */
  fun showQuickPick(
    items: Thenable<js.array.ReadonlyArray<String>>,
    options: ShowQuickPickOptions = definedExternally,
    token: vscode.CancellationToken = definedExternally,
  ): Thenable<Array<String>?>

  /**
   *
   * @param items An array of items, or a promise that resolves to an array of items
   * @param options VS Code options for the quick pick's behavior
   * @param token A token used to signal cancellation for the quick pick
   *
   * @see vscode.window.showQuickPick for more details
   */
  fun <T : vscode.QuickPickItem> showQuickPick(
    items: js.array.ReadonlyArray<T>,
    options: vscode.QuickPickOptions = definedExternally,
    token: vscode.CancellationToken = definedExternally,
  ): Thenable<T?>

  /**
   *
   * @param items An array of items, or a promise that resolves to an array of items
   * @param options VS Code options for the quick pick's behavior
   * @param token A token used to signal cancellation for the quick pick
   *
   * @see vscode.window.showQuickPick for more details
   */
  fun <T : vscode.QuickPickItem> showQuickPick(
    items: Thenable<js.array.ReadonlyArray<T>>,
    options: vscode.QuickPickOptions = definedExternally,
    token: vscode.CancellationToken = definedExternally,
  ): Thenable<T?>

  /**
   * Displays a message to the user, including any specified options.
   * @param message The message to display
   * @param options Any additional options for the message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun showMessage(
    message: String,
    options: GuiMessageOptionsString = definedExternally,
  ): Thenable<String?>

  /**
   * Displays a message to the user, including any specified options.
   * @param message The message to display
   * @param options Any additional options for the message
   * @return A thenable containing the selected item (if items were specified), or `undefined`
   */
  fun showMessage(
    message: String,
    options: GuiMessageOptionsMessageItem = definedExternally,
  ): Thenable<vscode.MessageItem?>

  /**
   * Helper type guard to check if a document object belong to VS Code's `TextDocument` interface
   * @param doc The object that may or may not be a `vscode.TextDocument`
   * @return Whether `doc` is a `vscode.TextDocument`
   */
  fun isTextDocument(doc: Any?): Boolean // doc is vscode.TextDocument

  /**
   * Show the given document in a text editor.
   * @param docOrUri The document or URI object to display
   * @param options Any options for the behavior of the text document
   * @return A promise that resolves to an editor
   *
   * @see vscode.window.showTextDocument for more details
   */
  fun showTextDocument(
    docOrUri: vscode.TextDocument,
    options: vscode.TextDocumentShowOptions = definedExternally,
  ): Thenable<vscode.TextEditor>

  /**
   * Show the given document in a text editor.
   * @param docOrUri The document or URI object to display
   * @param options Any options for the behavior of the text document
   * @return A promise that resolves to an editor
   *
   * @see vscode.window.showTextDocument for more details
   */
  fun showTextDocument(
    docOrUri: vscode.Uri,
    options: vscode.TextDocumentShowOptions = definedExternally,
  ): Thenable<vscode.TextEditor>

  /**
   * Show progress in the editor.
   * @param options Location and other details for the progress
   * @param task A callback that returns a promise
   * @return The promise that the task callback returned
   *
   * @see @see vscode.window.withProgress for more details
   */
  fun <R> withProgress(
    options: vscode.ProgressOptions,
    task: (progress: vscode.Progress<GuiProgress>, token: vscode.CancellationToken) -> Thenable<R>,
  ): Thenable<R>

  /**
   * Reports the progress of a Gui.withProgress action results in visual update for users.
   *
   * @export
   * @param {any} progress - Gui.withProgress progress
   * @param {number} valueLength - values array length used to calculate progress
   * @param {number} index - withProgress loop array's index
   * @param {string} action - the action the progress is reported for, ie. Uploading
   */
  fun reportProgress(
    progress: Any?,
    valueLength: Int,
    index: Int,
    action: String,
  )

  @Suppress("ClassName")
  object utils {
    /**
     * Determines whether a node has been double-clicked within a tree view.
     *
     * @param node The node that was just clicked
     * @param provider The tree provider that the node belongs to
     * @return Whether the node has been double-clicked.
     */
    fun <T> wasDoubleClicked(
      node: IZoweTreeNode,
      provider: IZoweTree<T>,
    ): Boolean
  }
}
