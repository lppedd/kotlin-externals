package vscode.window

import vscode.WebviewPanelOptions

external interface RegisterCustomEditorProviderOptions {
  /**
   * Content settings for the webview panels created for this custom editor.
   */
  val webviewOptions: WebviewPanelOptions?

  /**
   * Only applies to `CustomReadonlyEditorProvider | CustomEditorProvider`.
   *
   * Indicates that the provider allows multiple editor instances to be open at the same time for
   * the same resource.
   *
   * By default, the editor only allows one editor instance to be open at a time for each resource. If the
   * user tries to open a second editor instance for the resource, the first one is instead moved to where
   * the second one was to be opened.
   *
   * When `supportsMultipleEditorsPerDocument` is enabled, users can split and create copies of the custom
   * editor. In this case, the custom editor must make sure it can properly synchronize the states of all
   * editor instances for a resource so that they are consistent.
   */
  val supportsMultipleEditorsPerDocument: Boolean?
}
