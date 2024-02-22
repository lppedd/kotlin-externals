@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import js.promise.Promise
import node.buffer.Buffer
import zowe.explorer.api.utils.FileAttributes
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.download.doc.IDownloadOptions
import zowe.sdk.zos.files.methods.upload.doc.IUploadOptions

/**
 * An implementation of the Zowe Explorer USS API interface for zOSMF.
 */
external class ZosmfUssApi : ZosmfApiCommon, ZoweExplorerApi.IUss {
  constructor(profile: IProfileLoaded = definedExternally)

  override fun fileList(ussFilePath: String): Promise<IZosFilesResponse<Any?>>

  override fun isFileTagBinOrAscii(ussFilePath: String): Promise<Boolean>

  override fun getContents(
    ussFilePath: String,
    options: IDownloadOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun copy(outputPath: String, options: Any /* Omit<object, "request"> */): Promise<Buffer>

  /**
   * API method to wrap to the newer `putContent`.
   */
  @Deprecated("")
  override fun putContents(
    inputFilePath: String,
    ussFilePath: String,
    binary: Boolean,
    localEncoding: String,
    etag: String,
    returnEtag: Boolean,
  ): Promise<IZosFilesResponse<Any?>>

  override fun putContent(
    inputFilePath: String,
    ussFilePath: String,
    options: IUploadOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun updateAttributes(
    ussPath: String,
    attributes: FileAttributes, // Note(Edoardo): should be Partial<FileAttributes>
  ): Promise<IZosFilesResponse<Any?>>

  override fun uploadDirectory(
    inputDirectoryPath: String,
    ussDirectoryPath: String,
    options: IUploadOptions,
  ): Promise<IZosFilesResponse<Any?>>

  // Note(Edoardo): artificial overload
  fun uploadDirectory(
    inputDirectoryPath: String,
    ussDirectoryPath: String,
  ): Promise<IZosFilesResponse<Any?>>

  override fun create(
    ussPath: String,
    type: String,
    mode: String,
  ): Promise<IZosFilesResponse<Any?>>

  override fun delete(
    ussPath: String,
    recursive: Boolean,
  ): Promise<IZosFilesResponse<Any?>>

  override fun rename(
    currentUssPath: String,
    newUssPath: String,
  ): Promise<IZosFilesResponse<Any?>>

  override fun getTag(ussPath: String): Promise<String>
}
