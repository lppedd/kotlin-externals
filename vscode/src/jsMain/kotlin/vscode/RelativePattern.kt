@file:JsModule("vscode")

package vscode

/**
 * A relative pattern is a helper to construct glob patterns that are matched
 * relatively to a base file path. The base path can either be an absolute file
 * path as string or uri or a [WorkspaceFolder], which is the
 * preferred way of creating the relative pattern.
 */
external class RelativePattern {
  /**
   * Creates a new relative pattern object with a base file path and pattern to match. This pattern
   * will be matched on file paths relative to the base.
   *
   * Example:
   * ```ts
   * const folder = vscode.workspace.workspaceFolders?.[0];
   * if (folder) {
   *
   *   // Match any TypeScript file in the root of this workspace folder
   *   const pattern1 = new vscode.RelativePattern(folder, '*.ts');
   *
   *   // Match any TypeScript file in `someFolder` inside this workspace folder
   *   const pattern2 = new vscode.RelativePattern(folder, 'someFolder&#47;*.ts');
   * }
   * ```
   *
   * @param base A base to which this pattern will be matched against relatively. It is recommended
   *   to pass in a [WorkspaceFolder] if the pattern should match inside the workspace.
   *   Otherwise, a uri or string should only be used if the pattern is for a file path outside the workspace.
   * @param pattern A file glob pattern like `*.{ts,js}` that will be matched on paths relative to the base.
   */
  constructor(base: WorkspaceFolder, pattern: String)
  constructor(base: Uri, pattern: String)
  constructor(base: String, pattern: String)

  /**
   * A base file path to which this pattern will be matched against relatively. The
   * file path must be absolute, should not have any trailing path separators and
   * not include any relative segments (`.` or `..`).
   */
  var baseUri: Uri

  /**
   * A base file path to which this pattern will be matched against relatively.
   *
   * This matches the `fsPath` value of [RelativePattern.baseUri].
   *
   * *Note:* updating this value will update [RelativePattern.baseUri] to
   * be a uri with `file` scheme.
   */
  @Deprecated("This property is deprecated, please use RelativePattern.baseUri instead", ReplaceWith("baseUri"))
  var base: String

  /**
   * A file glob pattern like `*.{ts,js}` that will be matched on file paths
   * relative to the base path.
   *
   * Example: Given a base of `/home/work/folder` and a file path of `/home/work/folder/index.js`,
   * the file glob pattern will match on `index.js`.
   */
  var pattern: String
}
