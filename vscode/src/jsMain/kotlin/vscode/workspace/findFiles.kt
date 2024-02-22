@file:JsModule("vscode")

package vscode.workspace

import vscode.*

/**
 * Find files across all [vscode.workspace.workspaceFolders] in the workspace.
 *
 * Example:
 * ```
 * findFiles('**&#47;*.js', '**\/node_modules&#47;**', 10)
 * ```
 *
 * @param include A [GlobPattern] that defines the files to search for. The glob pattern
 *   will be matched against the file paths of resulting matches relative to their workspace. Use a [RelativePattern]
 *   to restrict the search results to a [WorkspaceFolder].
 * @param exclude  A [GlobPattern] that defines files and folders to exclude. The glob pattern
 *   will be matched against the file paths of resulting matches relative to their workspace. When `undefined`, default file-excludes (e.g. the `files.exclude`-setting
 *   but not `search.exclude`) will apply. When `null`, no excludes will apply.
 * @param maxResults An upper-bound for the result.
 * @param token A token that can be used to signal cancellation to the underlying search engine.
 * @return A thenable that resolves to an array of resource identifiers. Will return no results if no
 *   [vscode.workspace.workspaceFolders] are opened.
 */
external fun findFiles(
  include: GlobPattern,
  exclude: GlobPattern? = definedExternally,
  maxResults: Int = definedExternally,
  token: CancellationToken = definedExternally,
): Thenable<Array<Uri>>
