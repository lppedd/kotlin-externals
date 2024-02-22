@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.upload

import js.promise.Promise
import node.buffer.Buffer
import node.stream.Readable
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.upload.doc.IUploadOptions

external class Upload {
  companion object {
    /**
     * Upload content from file to data set
     * @param session z/OS connection info
     * @param inputFile path to a file
     * @param dataSetName Name of the data set to write to
     * @param options Uploading options. Default: {}
     *
     * @return A response indicating the out come
     *
     * @throws ImperativeError When encounter error scenarios.
     *
     */
    fun fileToDataset(
      session: AbstractSession,
      inputFile: String,
      dataSetName: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Upload content from a directory to a PDS
     * @param session z/OS connection info
     * @param inputDir path to a file
     * @param dataSetName Name of the data set to write to
     * @param options Uploading options. Default: {}
     *
     * @return A response indicating the out come
     *
     * @throws ImperativeError When encounter error scenarios.
     *
     */
    fun dirToPds(
      session: AbstractSession,
      inputDir: String,
      dataSetName: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Writing data buffer to a data set.
     * @param session z/OS connection info
     * @param fileBuffer Data buffer to be written
     * @param dataSetName Name of the data set to write to
     * @param options Uploading options. Default: {}
     *
     * @return A response indicating the outcome
     *
     * @throws ImperativeError When encounter error scenarios.
     */
    fun bufferToDataSet(
      session: AbstractSession,
      fileBuffer: Buffer,
      dataSetName: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Writing data buffer to a data set.
     * @param session z/OS connection info
     * @param fileBuffer Data buffer to be written
     * @param dataSetName Name of the data set to write to
     * @param options Uploading options. Default: {}
     *
     * @return A response indicating the out come
     *
     * @throws ImperativeError When encounter error scenarios.
     */
    fun streamToDataSet(
      session: AbstractSession,
      fileStream: Readable,
      dataSetName: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Upload content from input path to dataSet or PDS members
     *
     * Example:
     * ```
     * pathToDataSet(session, "file.txt", "ps.name")
     * pathToDataset(session, "file.txt", "psd.name(member)")
     * pathToDataSet(session, "directory", "pds.name")
     * pathToDataset(session, "/full/path/file.txt", "ps.name")
     * ```
     *
     * Note:
     * This method does everything needed to do from checking if path is file or directory
     * and if data set is sequential file or PDS to determine what name to be used when
     * upload content to data set.  All you have to specify is a directory and a dsname.
     *
     * @param session z/OS connection info
     * @param inputPath User input path to file or directory
     * @param dataSetName Name of the data set to write to
     * @param options Uploading options. Default: {}
     *
     * @param task use this to be updated on the current status of the upload operation
     * @return A response indicating the out come
     *
     * @throws ImperativeError When encounter error scenarios.
     */
    fun pathToDataSet(
      session: AbstractSession,
      inputPath: String,
      dataSetName: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Upload content to USS file
     * @param session z/OS connection info
     * @param ussname Name of the USS file to write to
     * @param buffer Data to be written
     * @param options Uploading options. Default: {}
     */
    fun bufferToUssFile(
      session: AbstractSession,
      ussname: String,
      buffer: Buffer,
      options: IUploadOptions = definedExternally,
    ): Promise<String>

    /**
     * Upload content to USS file
     * @param session z/OS connection info
     * @param ussname Name of the USS file to write to
     * @param uploadStream Data to be written
     * @param options Uploading options. Default: {}
     * @return A response indicating the outcome
     */
    fun streamToUssFile(
      session: AbstractSession,
      ussname: String,
      uploadStream: Readable,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Upload content from a local file to remote USS file
     * @param session z/OS connection info
     * @param inputFile Path to local file
     * @param ussname Name of USS file to write to
     * @param options Uploading options
     * @return A response indicating the outcome
     */
    fun fileToUssFile(
      session: AbstractSession,
      inputFile: String,
      ussname: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Upload local directory to USS directory
     * @param session z/OS connection info
     * @param inputDirectory the path of local directory
     * @param ussname the name of uss folder
     * @param options Uploading options. Default: {}
     */
    fun dirToUSSDir(
      session: AbstractSession,
      inputDirectory: String,
      ussname: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Check if USS directory exists
     * @param session z/OS connection info
     * @param ussname the name of uss folder
     */
    fun isDirectoryExist(
      session: AbstractSession,
      ussname: String,
    ): Promise<Boolean>

    /**
     * Upload directory to USS recursively
     * @param session z/OS connection info
     * @param inputDirectory the path of local directory
     * @param ussname the name of uss folder
     * @param options Uploading options. Default: {}
     */
    fun dirToUSSDirRecursive(
      session: AbstractSession,
      inputDirectory: String,
      ussname: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
