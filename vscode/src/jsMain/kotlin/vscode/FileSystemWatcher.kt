package vscode

/**
 * A file system watcher notifies about changes to files and folders
 * on disk or from other [FileSystemProvider]s.
 *
 * To get an instance of a `FileSystemWatcher` use
 * [vscode.workspace.createFileSystemWatcher].
 */
external interface FileSystemWatcher : IDisposable {
  /**
   * true if this file system watcher has been created such that
   * it ignores creation file system events.
   */
  val ignoreCreateEvents: Boolean

  /**
   * true if this file system watcher has been created such that
   * it ignores change file system events.
   */
  val ignoreChangeEvents: Boolean

  /**
   * true if this file system watcher has been created such that
   * it ignores delete file system events.
   */
  val ignoreDeleteEvents: Boolean

  /**
   * An event which fires on file/folder creation.
   */
  val onDidCreate: Event<Uri>

  /**
   * An event which fires on file/folder change.
   */
  val onDidChange: Event<Uri>

  /**
   * An event which fires on file/folder deletion.
   */
  val onDidDelete: Event<Uri>
}
