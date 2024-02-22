package vscode

import kotlin.ts.Union

/**
 * The decoration provider interfaces defines the contract between extensions and
 * file decorations.
 */
external interface FileDecorationProvider {
  /**
   * An optional event to signal that decorations for one or many files have changed.
   *
   * *Note* that this event should be used to propagate information about children.
   *
   * @see [EventEmitter]
   */
  var onDidChangeFileDecorations: Event<Union<Uri, Array<Uri>>?>? // undefined | Uri | Uri[]

  /**
   * Provide decorations for a given uri.
   *
   * *Note* that this function is only called when a file gets rendered in the UI.
   * This means a decoration from a descendent that propagates upwards must be signaled
   * to the editor via the [FileDecorationProvider.onDidChangeFileDecorations]-event.
   *
   * @param uri The uri of the file to provide a decoration for.
   * @param token A cancellation token.
   * @return A decoration or a thenable that resolves to such.
   */
  fun provideFileDecoration(
    uri: Uri,
    token: CancellationToken,
  ): ProviderResult<FileDecoration>
}
