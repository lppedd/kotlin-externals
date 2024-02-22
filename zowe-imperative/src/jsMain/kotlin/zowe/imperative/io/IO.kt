@file:JsModule("@zowe/imperative")

package zowe.imperative.io

import js.promise.Promise
import node.buffer.Buffer
import node.stream.Readable
import node.stream.Writable
import zowe.imperative.error.ImperativeError

/**
 * This class will handle common sequences of node I/O and issue messages / throw errors as
 * neccessary.
 */
external class IO {
  companion object {
    /**
     * File delimiter
     */
    val FILE_DELIM: String

    /**
     * UTF8 identifier
     */
    @JsString("utf8")
    val UTF8: String

    /**
     * Windows OS identifier
     */
    @JsString("win32")
    val OS_WIN32: String

    /**
     * Mac OS identifier
     */
    @JsString("darwin")
    val OS_MAC: String

    /**
     * Linux OS identifier
     */
    @JsString("linux")
    val OS_LINUX: String

    /**
     * Return whether input file is a directory or file
     *
     * @param dirOrFile file path
     * @return true if file path is a directory, false otherwise
     */
    fun isDir(dirOrFile: String): Boolean

    /**
     * Take an extension and prefix with a '.' identifier
     *
     * @param extension extension to normalize
     * @return '.bin' for input 'bin' for example
     */
    fun normalizeExtension(extension: String): String

    /**
     * Wraps fs.existsSync so that we dont have to import fs unnecessarily
     *
     * @param file file to validate existence against
     * @return true if file exists
     */
    fun existsSync(file: String): Boolean

    /**
     * Create a directory if it does not yet exist synchronously.
     *
     * @param dir directory to create
     */
    fun createDirSync(dir: String)

    /**
     * Create all needed directories for an input directory in the form of: first/second/third where
     * first will contain director second and second will contain directory third
     *
     * @param dir directory to create all sub directories for
     */
    fun createDirsSync(dir: String)

    /**
     * Create all necessary directories for a fully qualified file and its path, for example, if
     * filePath = oneDir/twoDir/threeDir/file.txt, oneDir, twoDir, and threeDir will be created.
     */
    fun createDirsSyncFromFilePath(filePath: String)

    /**
     * Create a symbolic link to a directory. If the symbolic link already exists, re-create it with
     * the specified target directory.
     *
     * @param newSymLinkPath the path new symbolic link to be created
     * @param existingDirPath the path the existing directory that we will link to
     */
    fun createSymlinkToDir(
      newSymLinkPath: String,
      existingDirPath: String,
    )

    /**
     * Uses the fs-extra package to create a directory (and all subdirectories)
     *
     * @param dir the directory (do not include a file name)
     */
    fun mkdirp(dir: String)

    /**
     * Wraps fs.readFileSync so that we dont have to import fs unnecessarily or specify encoding.
     *
     * @param file file to read
     * @param normalizeNewLines remove Windows line endings (\r\n) in favor of \n
     * @param binary should the file be read in binary mode? If so, normalizeNewLines is ignored.
     *   If false, the file will be read in UTF-8 encoding
     * @return Buffer - the content of the file
     */
    fun readFileSync(
      file: String,
      normalizeNewLines: Boolean = definedExternally,
      binary: Boolean = definedExternally,
    ): Buffer

    /**
     * Create a Node.js Readable stream from a file
     *
     * @param file the file from which to create a read stream
     * @return Buffer - the content of the file
     */
    fun createReadStream(file: String): Readable

    /**
     * Create a Node.js Readable stream from a file
     *
     * @param file the file from which to create a read stream
     * @return Buffer - the content of the file
     */
    fun createWriteStream(file: String): Writable

    /**
     * Process a string so that its line endings are operating system appropriate before you save it
     * to disk (basically, if the user is on Windows, change \n to \r\n)
     *
     * @param original original input
     * @param lastByte last byte of previous input, if it is being processed in chunks
     * @return input with removed newlines
     */
    fun processNewlines(
      original: String,
      lastByte: Byte = definedExternally,
    ): String

    /**
     * Get default text editor for a given operating system
     *
     * @return text editor launch string
     */
    fun getDefaultTextEditor(): String

    /**
     * Create a file
     *
     * @param file file to create
     */
    fun createFileSync(file: String)

    /**
     * Set file access permissions so that only the current user will have access to the file. On
     * windows, it means "full control" for the current user. On posix, it means read & write access
     * for the current user. Obviously, the current user must have permission to change permissions
     * on the specified file.
     *
     * @param fileName file name for which we modify access.
     * @throws ImperativeError when the operation fails.
     */
    fun giveAccessOnlyToOwner(fileName: String)

    /**
     * Create a file asynchronously
     *
     * @param file file to create
     * @param content content to write in the file
     */
    fun writeFileAsync(
      file: String,
      content: String,
    ): Promise<Unit>

    /**
     * Write a file
     *
     * @param file file to create
     * @param content content to write
     */
    fun writeFile(
      file: String,
      content: Buffer,
    )

    /**
     * Write an object to a file and set consistent formatting on the serialized JSON object.
     *
     * @param configFile file to create
     * @param object object to serialize
     */
    fun writeObject(
      configFile: String,
      `object`: Any,
    )

    /**
     * Delete a file
     *
     * @param file The file to delete
     */
    fun deleteFile(file: String)

    /**
     * Delete a directory
     *
     * @param dir The directory to delete
     */
    fun deleteDir(dir: String)

    /**
     * Recursively delete all files and subdirectories of the specified directory. Ensure that we do
     * not follow a symlink. Just delete the link.
     *
     * @param pathToTreeToDelete Path to top directory of the tree to delete.
     */
    fun deleteDirTree(pathToTreeToDelete: String)

    /**
     * Delete a symbolic link.
     *
     * @param symLinkPath the path to a symbolic link to be deleted
     */
    fun deleteSymLink(symLinkPath: String)
  }
}
