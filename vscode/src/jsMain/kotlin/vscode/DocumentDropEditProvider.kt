package vscode

/**
 * Provider which handles dropping of resources into a text editor.
 *
 * This allows users to drag and drop resources (including resources from external apps) into the editor. While dragging
 * and dropping files, users can hold down `shift` to drop the file into the editor instead of opening it.
 * Requires `editor.dropIntoEditor.enabled` to be on.
 */
external interface DocumentDropEditProvider {
  /**
   * Provide edits which inserts the content being dragged and dropped into the document.
   *
   * @param document The document in which the drop occurred.
   * @param position The position in the document where the drop occurred.
   * @param dataTransfer A [DataTransfer] object that holds data about what is being dragged and dropped.
   * @param token A cancellation token.
   *
   * @return A [DocumentDropEdit] or a thenable that resolves to such. The lack of a result can be
   *   signaled by returning `undefined` or `null`.
   */
  fun provideDocumentDropEdits(
    document: TextDocument,
    position: Position,
    dataTransfer: DataTransfer,
    token: CancellationToken,
  ): ProviderResult<DocumentDropEdit>
}
