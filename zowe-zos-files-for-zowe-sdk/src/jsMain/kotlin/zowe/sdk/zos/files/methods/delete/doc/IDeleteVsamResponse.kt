package zowe.sdk.zos.files.methods.delete.doc

import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.delete.Delete

/**
 * This interface defines the response type of [Delete.vsam]
 */
external interface IDeleteVsamResponse : IZosFilesResponse<IZosFilesResponse<Any?>> {
  /**
   * Delete VSAM calls the invoke api, which returns an [IZosFilesResponse]
   * object. So the api response will be set to that return object.
   */
  override var apiResponse: IZosFilesResponse<Any?>
}
