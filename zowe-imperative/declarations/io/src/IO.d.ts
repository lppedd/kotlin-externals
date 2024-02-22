/// <reference types="node" />
/// <reference types="node" />
import { Readable, Writable } from "stream";
/**
 * This class will handle common sequences of node I/O and issue messages /
 * throw errors as neccessary.
 * @export
 * @class IO
 */
export declare class IO {
    /**
     * File delimiter
     * @static
     * @type {string}
     * @memberof IO
     */
    static readonly FILE_DELIM: string;
    /**
     * UTF8 identifier
     * @static
     * @memberof IO
     */
    static readonly UTF8 = "utf8";
    /**
     * Windows OS identifier
     * @static
     * @memberof IO
     */
    static readonly OS_WIN32 = "win32";
    /**
     * Mac OS identifier
     * @static
     * @memberof IO
     */
    static readonly OS_MAC = "darwin";
    /**
     * Linux OS identifier
     * @static
     * @memberof IO
     */
    static readonly OS_LINUX = "linux";
    /**
     * Return whether input file is a directory or file
     * @static
     * @param {string} dirOrFile - file path
     * @returns {boolean} - true if file path is a directory, false otherwise
     * @memberof IO
     */
    static isDir(dirOrFile: string): boolean;
    /**
     * Take an extension and prefix with a '.' identifier
     * @static
     * @param {string} extension - extension to normalize
     * @returns {string} - '.bin' for input 'bin' for example
     * @memberof IO
     */
    static normalizeExtension(extension: string): string;
    /**
     * Wraps fs.existsSync so that we dont have to import fs unnecessarily
     * @static
     * @param  {string} file - file to validate existence against
     * @returns true if file exists
     * @memberof IO
     */
    static existsSync(file: string): boolean;
    /**
     * Create a directory if it does not yet exist synchronously.
     * @static
     * @param  {string} dir - directory to create
     * @return {undefined}
     * @memberof IO
     */
    static createDirSync(dir: string): void;
    /**
     * Create all needed directories for an input directory in the form of:
     * first/second/third where first will contain director second and second
     * will contain directory third
     * @static
     * @param {string} dir - directory to create all sub directories for
     * @memberof IO
     */
    static createDirsSync(dir: string): void;
    /**
     * Create all necessary directories for a fully qualified file and its path,
     * for example, if filePath = oneDir/twoDir/threeDir/file.txt,
     * oneDir, twoDir, and threeDir will be created.
     * @static
     * @param  {string} filePath [description]
     * @return {[type]}          [description]
     * @memberof IO
     */
    static createDirsSyncFromFilePath(filePath: string): void;
    /**
     * Create a symbolic link to a directory. If the symbolic link already exists,
     * re-create it with the specified target directory.
     *
     * @param {string} newSymLinkPath - the path new symbolic link to be created
     * @param {string} existingDirPath - the path the existing directory that we will link to
     */
    static createSymlinkToDir(newSymLinkPath: string, existingDirPath: string): void;
    /**
     * Uses the fs-extra package to create a directory (and all subdirectories)
     * @static
     * @param {string} dir - the directory (do not include a file name)
     * @memberof IO
     */
    static mkdirp(dir: string): void;
    /**
     * Wraps fs.readFileSync so that we dont have to import fs unnecessarily
     * or specify encoding.
     * @static
     * @param  {string} file - file to read
     * @param normalizeNewLines - remove Windows line endings (\r\n)  in favor of \n
     * @param binary - should the file be read in binary mode? If so, normalizeNewLines is ignored. If false,
     *                 the file will be read in UTF-8 encoding
     * @return Buffer - the content of the file
     * @memberof IO
     */
    static readFileSync(file: string, normalizeNewLines?: boolean, binary?: boolean): Buffer;
    /**
     * Create a Node.js Readable stream from a file
     * @param file - the file from which to create a read stream
     * @return Buffer - the content of the file
     * @memberof IO
     */
    static createReadStream(file: string): Readable;
    /**
     * Create a Node.js Readable stream from a file
     * @param file - the file from which to create a read stream
     * @return Buffer - the content of the file
     * @memberof IO
     */
    static createWriteStream(file: string): Writable;
    /**
     * Process a string so that its line endings are operating system
     * appropriate before you save it to disk
     * (basically, if the user is on Windows, change  \n to \r\n)
     * @static
     * @param {string} original - original input
     * @param {number} lastByte - last byte of previous input, if it is being processed in chunks
     * @returns {string} - input with removed newlines
     * @memberof IO
     */
    static processNewlines(original: string, lastByte?: number): string;
    /**
     * Get default text editor for a given operating system
     * @static
     * @returns {string} - text editor launch string
     * @memberof IO
     */
    static getDefaultTextEditor(): string;
    /**
     * Create a file
     * @static
     * @param  {string} file - file to create
     * @memberof IO
     */
    static createFileSync(file: string): void;
    /**
     * Set file access permissions so that only the current user will have access to the file.
     * On windows, it means "full control" for the current user.
     * On posix, it means read & write access for the current user.
     * Obviously, the current user must have permission to change permissions
     * on the specified file.
     *
     * @param  {string} fileName - file name for which we modify access.
     * @throws An ImperativeError when the operation fails.
     */
    static giveAccessOnlyToOwner(fileName: string): void;
    /**
     * Create a file asynchronously
     * @static
     * @param  {string} file    - file to create
     * @param  {string} content - content to write in the file
     * @return {[type]}         [description]
     * @memberof IO
     */
    static writeFileAsync(file: string, content: string): Promise<void>;
    /**
     * Write a file
     * @static
     * @param  {string} file - file to create
     * @param  {string} content    - content to write
     * @return {undefined}
     * @memberof IO
     */
    static writeFile(file: string, content: Buffer): void;
    /**
     * Write an object to a file and set consistent formatting on the serialized
     * JSON object.
     * @static
     * @param  {string} configFile - file to create
     * @param  {Object} object     - object to serialize
     * @return {undefined}
     * @memberof IO
     */
    static writeObject(configFile: string, object: object): void;
    /**
     * Delete a file
     * @static
     * @param {string} file: The file to delete
     * @memberof IO
     */
    static deleteFile(file: string): void;
    /**
     * Delete a directory
     * @static
     * @param {string} dir: The directory to delete
     * @memberof IO
     */
    static deleteDir(dir: string): void;
    /**
     * Recursively delete all files and subdirectories of the specified directory.
     * Ensure that we do not follow a symlink. Just delete the link.
     *
     * @params {string} pathToTreeToDelete - Path to top directory of the tree
     *      to delete.
     */
    static deleteDirTree(pathToTreeToDelete: string): void;
    /**
     * Delete a symbolic link.
     *
     * @param {string} symLinkPath - the path to a symbolic link to be deleted
     */
    static deleteSymLink(symLinkPath: string): void;
}
