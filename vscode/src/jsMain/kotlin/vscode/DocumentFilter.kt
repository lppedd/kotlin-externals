package vscode

/**
 * A document filter denotes a document by different properties like
 * the [TextDocument.languageId], the [Uri.scheme] of
 * its resource, or a glob-pattern that is applied to the [TextDocument.fileName].
 *
 * Example:
 *
 * **A language filter that applies to typescript files on disk**
 * ```
 * { language: 'typescript', scheme: 'file' }
 * ```
 *
 * **A language filter that applies to all package.json paths**
 * ```
 * { language: 'json', pattern: '**​/package.json' }
 * ```
 */
external interface DocumentFilter {
  /**
   * A language id, like `typescript`.
   */
  val language: String?

  /**
   * The [NotebookDocument.notebookType] of a notebook, like `jupyter-notebook`. This allows
   * to narrow down on the type of a notebook that a [NotebookCell.document] belongs to.
   *
   * *Note* that setting the `notebookType`-property changes how `scheme` and `pattern` are interpreted. When set
   * they are evaluated against the [NotebookDocument.uri], not the document uri.
   *
   * Example:
   *
   * **Match python document inside jupyter notebook that aren't stored yet (`untitled`)**
   * ```
   * { language: 'python', notebookType: 'jupyter-notebook', scheme: 'untitled' }
   * ```
   */
  val notebookType: String?

  /**
   * A Uri [Uri.scheme], like `file` or `untitled`.
   */
  val scheme: String?

  /**
   * A [GlobPattern] that is matched on the absolute path of the document. Use a [RelativePattern]
   * to filter documents to a [WorkspaceFolder].
   */
  val pattern: GlobPattern?
}
