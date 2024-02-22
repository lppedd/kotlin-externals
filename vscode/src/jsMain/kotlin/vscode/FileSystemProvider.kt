package vscode

import js.array.JsTuple2
import js.typedarrays.Uint8Array
import kotlin.ts.Union

/**
 * The filesystem provider defines what the editor needs to read, write, discover,
 * and to manage files and folders. It allows extensions to serve files from remote places,
 * like ftp-servers, and to seamlessly integrate those into the editor.
 *
 * - *Note 1:* The filesystem provider API works with [Uri]s and assumes hierarchical
 *   paths, e.g. `foo:/my/path` is a child of `foo:/my/` and a parent of `foo:/my/path/deeper`.
 *
 * - *Note 2:* There is an activation event `onFileSystem:<scheme>` that fires when a file
 *   or folder is being accessed.
 *
 * - *Note 3:* The word 'file' is often used to denote all kinds ([FileType]) of files, e.g.
 *   folders, symbolic links, and regular files.
 */
external interface FileSystemProvider {
  /**
   * An event to signal that a resource has been created, changed, or deleted. This
   * event should fire for resources that are being watched ([FileSystemProvider.watch])
   * by clients of this provider.
   *
   * *Note:* It is important that the metadata of the file that changed provides an
   * updated `mtime` that advanced from the previous value in the [FileStat] and a
   * correct `size` value. Otherwise there may be optimizations in place that will not show
   * the change in an editor for example.
   */
  val onDidChangeFile: Event<Array<FileChangeEvent>>

  /**
   * Subscribes to file change events in the file or folder denoted by `uri`. For folders,
   * the option `recursive` indicates whether subfolders, sub-subfolders, etc. should
   * be watched for file changes as well. With `recursive: false`, only changes to the
   * files that are direct children of the folder should trigger an event.
   *
   * The `excludes` array is used to indicate paths that should be excluded from file
   * watching. It is typically derived from the `files.watcherExclude` setting that
   * is configurable by the user. Each entry can be be:
   * - the absolute path to exclude
   * - a relative path to exclude (for example `build/output`)
   * - a simple glob pattern (for example `**​/build`, `output&#47;**`)
   *
   * It is the file system provider's job to call [FileSystemProvider.onDidChangeFile]
   * for every change given these rules. No event should be emitted for files that match any of the provided
   * excludes.
   *
   * @param uri The uri of the file or folder to be watched.
   * @param options Configures the watch.
   * @return A disposable that tells the provider to stop watching the `uri`.
   */
  fun watch(
    uri: Uri,
    options: FileSystemProviderWatchOptions,
  ): IDisposable

  /**
   * Retrieve metadata about a file.
   *
   * Note that the metadata for symbolic links should be the metadata of the file they refer to.
   * Still, the [FileType.SymbolicLink]-type must be used in addition to the actual type, e.g.
   * `FileType.SymbolicLink | FileType.Directory`.
   *
   * @param uri The uri of the file to retrieve metadata about.
   * @return The file metadata about the file.
   * @throws FileSystemError.FileNotFound when `uri` doesn't exist.
   */
  fun stat(uri: Uri): Union<FileStat, Thenable<FileStat>> // FileStat | Thenable<FileStat>

  /**
   * Retrieve all entries of a [FileType.Directory].
   *
   * @param uri The uri of the folder.
   * @return An array of name/type-tuples or a thenable that resolves to such.
   * @throws FileSystemError.FileNotFound when `uri` doesn't exist.
   */
  fun readDirectory(
    uri: Uri,
  ): Union<Array<JsTuple2<String, FileType>>, Thenable<Array<JsTuple2<String, FileType>>>> // [ string, FileType ][] | Thenable<[ string, FileType ][]>

  /**
   * Create a new directory (Note, that new files are created via `write`-calls).
   *
   * @param uri The uri of the new folder.
   * @throws FileSystemError.FileNotFound when the parent of `uri` doesn't exist, e.g. no mkdirp-logic required.
   * @throws FileSystemError.FileExists when `uri` already exists.
   * @throws FileSystemError.NoPermissions when permissions aren't sufficient.
   */
  fun createDirectory(uri: Uri): Union<Unit, Thenable<Unit>> // void | Thenable<void>

  /**
   * Read the entire contents of a file.
   *
   * @param uri The uri of the file.
   * @return An array of bytes or a thenable that resolves to such.
   * @throws FileSystemError.FileNotFound when `uri` doesn't exist.
   */
  fun readFile(uri: Uri): Union<Uint8Array, Thenable<Uint8Array>> // Uint8Array | Thenable<Uint8Array>

  /**
   * Write data to a file, replacing its entire contents.
   *
   * @param uri The uri of the file.
   * @param content The new content of the file.
   * @param options Defines if missing files should or must be created.
   * @throws FileSystemError.FileNotFound when `uri` doesn't exist and `create` is not set.
   * @throws FileSystemError.FileNotFound when the parent of `uri` doesn't exist and `create` is set, e.g. no mkdirp-logic required.
   * @throws FileSystemError.FileExists when `uri` already exists, `create` is set but `overwrite` is not set.
   * @throws FileSystemError.NoPermissions when permissions aren't sufficient.
   */
  fun writeFile(
    uri: Uri,
    content: Uint8Array,
    options: FileSystemProviderWriteFileOptions,
  ): Union<Unit, Thenable<Unit>> // void | Thenable<void>

  /**
   * Delete a file.
   *
   * @param uri The resource that is to be deleted.
   * @param options Defines if deletion of folders is recursive.
   * @throws FileSystemError.FileNotFound when `uri` doesn't exist.
   * @throws FileSystemError.NoPermissions when permissions aren't sufficient.
   */
  fun delete(uri: Uri, options: FileSystemProviderDeleteOptions): Union<Unit, Thenable<Unit>> // void | Thenable<void>

  /**
   * Rename a file or folder.
   *
   * @param oldUri The existing file.
   * @param newUri The new location.
   * @param options Defines if existing files should be overwritten.
   * @throws FileSystemError.FileNotFound when `oldUri` doesn't exist.
   * @throws FileSystemError.FileNotFound when parent of `newUri` doesn't exist, e.g. no mkdirp-logic required.
   * @throws FileSystemError.FileExists when `newUri` exists and when the `overwrite` option is not `true`.
   * @throws FileSystemError.NoPermissions when permissions aren't sufficient.
   */
  fun rename(
    oldUri: Uri,
    newUri: Uri,
    options: FileSystemProviderRenameOptions,
  ): Union<Unit, Thenable<Unit>> // void | Thenable<void>

  /**
   * Copy files or folders. Implementing this function is optional but it will speedup
   * the copy operation.
   *
   * @param source The existing file.
   * @param destination The destination location.
   * @param options Defines if existing files should be overwritten.
   * @throws FileSystemError.FileNotFound when `source` doesn't exist.
   * @throws FileSystemError.FileNotFound when parent of `destination` doesn't exist, e.g. no mkdirp-logic required.
   * @throws FileSystemError.FileExists when `destination` exists and when the `overwrite` option is not `true`.
   * @throws FileSystemError.NoPermissions when permissions aren't sufficient.
   */
  fun copy(
    source: Uri,
    destination: Uri,
    options: FileSystemProviderCopyOptions,
  ): Union<Unit, Thenable<Unit>> // void | Thenable<void>
}
