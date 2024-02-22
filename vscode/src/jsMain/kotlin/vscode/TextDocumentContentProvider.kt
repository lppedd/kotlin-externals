package vscode

/**
 * A text document content provider allows to add readonly documents
 * to the editor, such as source from a dll or generated html from md.
 *
 * Content providers are registered ([vscode.workspace.registerTextDocumentContentProvider])
 * for a [Uri.scheme]. When a uri with that scheme is to
 * be loaded ([vscode.workspace.openTextDocument]) the content provider is
 * asked.
 */
external interface TextDocumentContentProvider {
  /**
   * An event to signal a resource has changed.
   */
  var onDidChange: Event<Uri>?

  /**
   * Provide textual content for a given uri.
   *
   * The editor will use the returned string-content to create a readonly
   * [TextDocument]. Resources allocated should be released when
   * the corresponding document has been closed ([vscode.workspace.onDidCloseTextDocument]).
   *
   * **Note**: The contents of the created [TextDocument] might not be
   * identical to the provided text due to end-of-line-sequence normalization.
   *
   * @param uri An uri which scheme matches the scheme this provider was registered ([vscode.workspace.registerTextDocumentContentProvider]) for.
   * @param token A cancellation token.
   * @return A string or a thenable that resolves to such.
   */
  fun provideTextDocumentContent(
    uri: Uri,
    token: CancellationToken,
  ): ProviderResult<String>
}
