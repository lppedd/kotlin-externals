package vscode.workspace

import vscode.MarkdownString
import vscode.Union
import vscode.Uri

external interface RegisterFileSystemProviderOptions {
  /**
   * Whether the file system provider use case sensitive compare for [Uri.path]s.
   */
  val isCaseSensitive: Boolean?

  /**
   * Whether the file system provider is readonly, no modifications like write, delete, create are possible.
   * If a [MarkdownString] is given, it will be shown as the reason why the file system is readonly.
   */
  val isReadonly: Union<Boolean, MarkdownString>?
}
