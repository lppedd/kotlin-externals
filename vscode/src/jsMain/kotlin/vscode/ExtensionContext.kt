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
  val subscriptions: Array<IDisposable>

  /**
   * A memento object that stores state in the context
   * of the currently opened workspace ([vscode.workspace.workspaceFolders]).
   */
  val workspaceState: Memento

  /**
   * A memento object that stores state independent
   * of the current opened workspace ([vscode.workspace.workspaceFolders]).
   */
  val globalState: ExtensionContextGlobalState

  /**
   * A storage utility for secrets. Secrets are persisted across reloads and are independent of the
   * current opened workspace ([vscode.workspace.workspaceFolders]).
   */
  val secrets: SecretStorage

  /**
   * The uri of the directory containing the extension.
   */
  val extensionUri: Uri

  /**
   * The absolute file path of the directory containing the extension. Shorthand
   * notation for `TextDocument.uri ExtensionContext.extensionUri.fsPath` (independent of the uri scheme).
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
   * *Note* that an absolute uri can be constructed via [Uri.joinPath] and
   * [ExtensionContext.extensionUri], e.g. `vscode.Uri.joinPath(context.extensionUri, relativePath);`
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
   * Use [ExtensionContext.workspaceState] or [ExtensionContext.globalState] to store key value data.
   *
   * See FileSystem ([vscode.workspace.fs]) for how to read and write files and folders from an uri.
   */
  val storageUri: Uri?

  /**
   * An absolute file path of a workspace specific directory in which the extension
   * can store private state. The directory might not exist on disk and creation is
   * up to the extension. However, the parent directory is guaranteed to be existent.
   *
   * Use [ExtensionContext.workspaceState] or [ExtensionContext.globalState] to store key value data.
   */
  @Deprecated("Use ExtensionContext.storageUri instead")
  val storagePath: String?

  /**
   * The uri of a directory in which the extension can store global state.
   * The directory might not exist on disk and creation is
   * up to the extension. However, the parent directory is guaranteed to be existent.
   *
   * Use [ExtensionContext.globalState] to store key value data.
   *
   * See FileSystem ([vscode.workspace.fs]) for how to read and write files and folders from an uri.
   */
  val globalStorageUri: Uri

  /**
   * An absolute file path in which the extension can store global state.
   * The directory might not exist on disk and creation is
   * up to the extension. However, the parent directory is guaranteed to be existent.
   *
   * Use [ExtensionContext.globalState] to store key value data.
   */
  @Deprecated("Use ExtensionContext.globalStorageUri instead")
  val globalStoragePath: String

  /**
   * The uri of a directory in which the extension can create log files.
   * The directory might not exist on disk and creation is up to the extension. However,
   * the parent directory is guaranteed to be existent.
   *
   * See FileSystem ([vscode.workspace.fs]) for how to read and write files and folders from an uri.
   */
  val logUri: Uri

  /**
   * An absolute file path of a directory in which the extension can create log files.
   * The directory might not exist on disk and creation is up to the extension. However,
   * the parent directory is guaranteed to be existent.
   */
  @Deprecated("Use ExtensionContext.logUri instead")
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
