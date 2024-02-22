@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.utils

/**
 * Attributes for a set of files relating to how they will be uploaded to USS
 */
external class ZosFilesAttributes {
  constructor(attributesFileContents: String, basePath: String = definedExternally)

  fun fileShouldBeUploaded(path: String): Boolean

  fun fileShouldBeIgnored(path: String): Boolean

  fun getFileTransferMode(
    path: String,
    preferBinary: Boolean = definedExternally,
  ): TransferMode

  fun getRemoteEncoding(path: String): String

  fun getLocalEncoding(path: String): String

  companion object {
    fun loadFromFile(
      filePath: String = definedExternally,
      defaultDir: String = definedExternally,
    ): ZosFilesAttributes?
  }
}
