package vscode

/**
 * An extension context is a collection of utilities private to an
 * extension.
 *
 * An instance of an `ExtensionContext` is provided as the first
 * parameter to the `activate`-call of an extension.
 */
external interface ExtensionContext {
  /**
   * An array to which disposables can be added. When this
   * extension is deactivated the disposables will be disposed.
   *
   * *Note* that asynchronous dispose-functions aren't awaited.
   */
  val subscriptions: Array<Temp5>

  /**
   * A memento object that stores state in the context
   * of the currently opened [workspace.workspaceFolders workspace].
   */
  val workspaceState: Memento

  /**
   * A memento object that stores state independent
   * of the current opened [workspace.workspaceFolders workspace].
   */
  val globalState: ExtensionContextGlobalState

  /**
   * A storage utility for secrets. Secrets are persisted across reloads and are independent of the
   * current opened [workspace.workspaceFolders workspace].
   */
  val secrets: SecretStorage

  /**
   * The uri of the directory containing the extension.
   */
  val extensionUri: Uri

  /**
   * The absolute file path of the directory containing the extension. Shorthand
   * notation for [TextDocument.uri ExtensionContext.extensionUri.fsPath] (independent of the uri scheme).
   */
  val extensionPath: String

  /**
   * Gets the extension's global environment variable collection for this workspace, enabling changes to be
   * applied to terminal environment variables.
   */
  val environmentVariableCollection: GlobalEnvironmentVariableCollection

  /**
   * Get the absolute path of a resource contained in the extension.
   *
   * *Note* that an absolute uri can be constructed via {@linkcode Uri.joinPath} and
   * {@linkcode ExtensionContext.extensionUri extensionUri}, e.g. `vscode.Uri.joinPath(context.extensionUri, relativePath);`
   *
   * @param relativePath A relative path to a resource contained in the extension.
   * @return The absolute path of the resource.
   */
  fun asAbsolutePath(relativePath: String): String

  /**
   * The uri of a workspace specific directory in which the extension
   * can store private state. The directory might not exist and creation is
   * up to the extension. However, the parent directory is guaranteed to be existent.
   * The value is `undefined` when no workspace nor folder has been opened.
   *
   * Use {@linkcode ExtensionContext.workspaceState workspaceState} or
   * {@linkcode ExtensionContext.globalState globalState} to store key value data.
   *
   * @see {@linkcode FileSystem workspace.fs} for how to read and write files and folders from
   *  an uri.
   */
  val storageUri: Uri?

  /**
   * An absolute file path of a workspace specific directory in which the extension
   * can store private state. The directory might not exist on disk and creation is
   * up to the extension. However, the parent directory is guaranteed to be existent.
   *
   * Use {@linkcode ExtensionContext.workspaceState workspaceState} or
   * {@linkcode ExtensionContext.globalState globalState} to store key value data.
   *
   * @deprecated Use [ExtensionContext.storageUri storageUri] instead.
   */
  val storagePath: String?

  /**
   * The uri of a directory in which the extension can store global state.
   * The directory might not exist on disk and creation is
   * up to the extension. However, the parent directory is guaranteed to be existent.
   *
   * Use {@linkcode ExtensionContext.globalState globalState} to store key value data.
   *
   * @see {@linkcode FileSystem workspace.fs} for how to read and write files and folders from
   *  an uri.
   */
  val globalStorageUri: Uri

  /**
   * An absolute file path in which the extension can store global state.
   * The directory might not exist on disk and creation is
   * up to the extension. However, the parent directory is guaranteed to be existent.
   *
   * Use {@linkcode ExtensionContext.globalState globalState} to store key value data.
   *
   * @deprecated Use [ExtensionContext.globalStorageUri globalStorageUri] instead.
   */
  val globalStoragePath: String

  /**
   * The uri of a directory in which the extension can create log files.
   * The directory might not exist on disk and creation is up to the extension. However,
   * the parent directory is guaranteed to be existent.
   *
   * @see {@linkcode FileSystem workspace.fs} for how to read and write files and folders from
   *  an uri.
   */
  val logUri: Uri

  /**
   * An absolute file path of a directory in which the extension can create log files.
   * The directory might not exist on disk and creation is up to the extension. However,
   * the parent directory is guaranteed to be existent.
   *
   * @deprecated Use [ExtensionContext.logUri logUri] instead.
   */
  val logPath: String

  /**
   * The mode the extension is running in. See [ExtensionMode]
   * for possible values and scenarios.
   */
  val extensionMode: ExtensionMode

  /**
   * The current `Extension` instance.
   */
  val extension: Extension<Any?>
}
