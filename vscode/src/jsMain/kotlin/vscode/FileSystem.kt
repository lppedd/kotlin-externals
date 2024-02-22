package vscode

import js.array.JsTuple2
import js.typedarrays.Uint8Array

/**
 * The file system interface exposes the editor's built-in and contributed
 * [FileSystemProvider]. It allows extensions to work
 * with files from the local disk as well as files from remote places, like the
 * remote extension host or ftp-servers.
 *
 * *Note* that an instance of this interface is available as {@linkcode workspace.fs}.
 */
external interface FileSystem {
  /**
   * Retrieve metadata about a file.
   *
   * @param uri The uri of the file to retrieve metadata about.
   * @return The file metadata about the file.
   */
  fun stat(uri: Uri): Thenable<FileStat>

  /**
   * Retrieve all entries of a [FileType.Directory directory].
   *
   * @param uri The uri of the folder.
   * @return An array of name/type-tuples or a thenable that resolves to such.
   */
  fun readDirectory(uri: Uri): Thenable<Array<JsTuple2<String, FileType> /* [ string, FileType ] */>>

  /**
   * Create a new directory (Note, that new files are created via `write`-calls).
   *
   * *Note* that missing directories are created automatically, e.g this call has
   * `mkdirp` semantics.
   *
   * @param uri The uri of the new folder.
   */
  fun createDirectory(uri: Uri): Thenable<Unit>

  /**
   * Read the entire contents of a file.
   *
   * @param uri The uri of the file.
   * @return An array of bytes or a thenable that resolves to such.
   */
  fun readFile(uri: Uri): Thenable<Uint8Array>

  /**
   * Write data to a file, replacing its entire contents.
   *
   * @param uri The uri of the file.
   * @param content The new content of the file.
   */
  fun writeFile(
    uri: Uri,
    content: Uint8Array,
  ): Thenable<Unit>

  /**
   * Delete a file.
   *
   * @param uri The resource that is to be deleted.
   * @param options Defines if trash can should be used and if deletion of folders is recursive
   */
  fun delete(
    uri: Uri,
    options: FileSystemDeleteOptions = definedExternally,
  ): Thenable<Unit>

  /**
   * Rename a file or folder.
   *
   * @param source The existing file.
   * @param target The new location.
   * @param options Defines if existing files should be overwritten.
   */
  fun rename(
    source: Uri,
    target: Uri,
    options: FileSystemRenameOptions = definedExternally,
  ): Thenable<Unit>

  /**
   * Copy files or folders.
   *
   * @param source The existing file.
   * @param target The destination location.
   * @param options Defines if existing files should be overwritten.
   */
  fun copy(
    source: Uri,
    target: Uri,
    options: FileSystemCopyOptions = definedExternally,
  ): Thenable<Unit>

  /**
   * Check if a given file system supports writing files.
   *
   * Keep in mind that just because a file system supports writing, that does
   * not mean that writes will always succeed. There may be permissions issues
   * or other errors that prevent writing a file.
   *
   * @param scheme The scheme of the filesystem, for example `file` or `git`.
   *
   * @return `true` if the file system supports writing, `false` if it does not
   *   support writing (i.e. it is readonly), and `undefined` if the editor does not
   *   know about the filesystem.
   */
  fun isWritableFileSystem(scheme: String): Boolean?
}
