@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.compare

import js.promise.Promise
import node.buffer.Buffer
import zowe.cli.zosfiles.compare.doc.ICompareFileOptions
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.operations.doc.ITaskWithStatus
import zowe.imperative.utilities.diff.doc.IDiffNameOptions
import zowe.imperative.utilities.diff.doc.IDiffOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * Base helper for compare command to handle common operations through the comparison
 */
external class CompareBaseHelper {
  /**
   * Creates an instance of CompareBaseHelper
   * @param commandParameters Command parameters sent to the handler
   */
  constructor(commandParameters: IHandlerParameters)

  /**
   * file compare option for file1
   */
  var file1Options: ICompareFileOptions

  /**
   * file compare option for file2
   */
  var file2Options: ICompareFileOptions

  /**
   * responseTimeout option
   */
  var responseTimeout: Int

  /**
   * seqnum option
   */
  var seqnum: Boolean

  /**
   * contextLines option
   */
  var contextLines: Int

  /**
   * browserView option
   */
  var browserView: Boolean

  /**
   * task
   */
  var task: ITaskWithStatus

  /**
   * Parse the spool description and split them into individual properties
   * @param spoolDescription Colon-separated (:) spool descriptor
   * @return Object containing the name, job id, and spool id
   */
  fun prepareSpoolDescriptor(spoolDescription: String): CompareBaseHelperPrepareSpoolDescriptorResult

  /**
   * Helper function that compare-related handlers will use to get the contents of a local file
   * @param filePath Path to the file to compare against
   * @return Buffer with the contents of the file
   */
  fun prepareLocalFile(filePath: String): Buffer

  /**
   * This method will prepare the strings for comparison ready
   * @param content Content string or buffer of file 1
   * @param content2 Content string or buffer of file 2
   */
  fun prepareContent(content: String): String

  /**
   * This method will prepare the strings for comparison ready
   * @param content Content string or buffer of file 1
   * @param content2 Content string or buffer of file 2
   */
  fun prepareContent(content: Buffer): String

  /**
   * To get the difference string in terminal or in browser
   * @param string1 string of file 1 content
   * @param string2 string of file 2 content
   * @param options
   */
  fun getResponse(
    string1: String,
    string2: String,
    options: IDiffOptions = definedExternally,
  ): Promise<IZosFilesResponse<Any?>>

  /**
   * To get the difference string in terminal or in browser
   * @param string1 string of file 1 content
   * @param string2 string of file 2 content
   * @param options
   */
  fun getResponse(
    string1: String,
    string2: String,
    options: IDiffNameOptions = definedExternally,
  ): Promise<IZosFilesResponse<Any?>>
}
