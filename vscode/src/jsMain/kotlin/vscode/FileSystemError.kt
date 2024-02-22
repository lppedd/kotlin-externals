@file:JsModule("vscode")

package vscode

import js.errors.JsError

/**
 * A type that filesystem providers should use to signal errors.
 *
 * This class has factory methods for common error-cases, like `FileNotFound` when
 * a file or folder doesn't exist, use them like so: `throw vscode.FileSystemError.FileNotFound(someUri);`
 */
external class FileSystemError : JsError {
  /**
   * Creates a new filesystem error.
   *
   * @param messageOrUri Message or uri.
   */
  constructor(messageOrUri: String = definedExternally)
  constructor(messageOrUri: Uri = definedExternally)

  /**
   * A code that identifies this error.
   *
   * Possible values are names of errors, like [FileSystemError.FileNotFound],
   * or `Unknown` for unspecified errors.
   */
  val code: String

  companion object {
    /**
     * Create an error to signal that a file or folder wasn't found.
     * @param messageOrUri Message or uri.
     */
    fun FileNotFound(messageOrUri: String = definedExternally): FileSystemError

    /**
     * Create an error to signal that a file or folder wasn't found.
     * @param messageOrUri Message or uri.
     */
    fun FileNotFound(messageOrUri: Uri = definedExternally): FileSystemError

    /**
     * Create an error to signal that a file or folder already exists, e.g. when
     * creating but not overwriting a file.
     * @param messageOrUri Message or uri.
     */
    fun FileExists(messageOrUri: String = definedExternally): FileSystemError

    /**
     * Create an error to signal that a file or folder already exists, e.g. when
     * creating but not overwriting a file.
     * @param messageOrUri Message or uri.
     */
    fun FileExists(messageOrUri: Uri = definedExternally): FileSystemError

    /**
     * Create an error to signal that a file is not a folder.
     * @param messageOrUri Message or uri.
     */
    fun FileNotADirectory(messageOrUri: String = definedExternally): FileSystemError

    /**
     * Create an error to signal that a file is not a folder.
     * @param messageOrUri Message or uri.
     */
    fun FileNotADirectory(messageOrUri: Uri = definedExternally): FileSystemError

    /**
     * Create an error to signal that a file is a folder.
     * @param messageOrUri Message or uri.
     */
    fun FileIsADirectory(messageOrUri: String = definedExternally): FileSystemError

    /**
     * Create an error to signal that a file is a folder.
     * @param messageOrUri Message or uri.
     */
    fun FileIsADirectory(messageOrUri: Uri = definedExternally): FileSystemError

    /**
     * Create an error to signal that an operation lacks required permissions.
     * @param messageOrUri Message or uri.
     */
    fun NoPermissions(messageOrUri: String = definedExternally): FileSystemError

    /**
     * Create an error to signal that an operation lacks required permissions.
     * @param messageOrUri Message or uri.
     */
    fun NoPermissions(messageOrUri: Uri = definedExternally): FileSystemError

    /**
     * Create an error to signal that the file system is unavailable or too busy to
     * complete a request.
     * @param messageOrUri Message or uri.
     */
    fun Unavailable(messageOrUri: String = definedExternally): FileSystemError

    /**
     * Create an error to signal that the file system is unavailable or too busy to
     * complete a request.
     * @param messageOrUri Message or uri.
     */
    fun Unavailable(messageOrUri: Uri = definedExternally): FileSystemError
  }
}
