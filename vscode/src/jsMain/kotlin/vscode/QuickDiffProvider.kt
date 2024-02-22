package vscode

/**
 * A quick diff provider provides a [Uri uri] to the original state of a
 * modified resource. The editor will use this information to render ad'hoc diffs
 * within the text.
 */
external interface QuickDiffProvider {
  /**
   * Provide a [Uri] to the original resource of any given resource uri.
   *
   * @param uri The uri of the resource open in a text editor.
   * @param token A cancellation token.
   * @return A thenable that resolves to uri of the matching original resource.
   */
  fun provideOriginalResource(
    uri: Uri,
    token: CancellationToken,
  ): ProviderResult<Uri>
}
