@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.rename

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * Class to handle renaming data sets
 */
external class Rename {
  companion object {
    /**
     * Rename a data set
     * @param session z/OSMF connection info
     * @param beforeDataSetName the name of the data set to rename
     * @param afterDataSetName the new name of the data set
     */
    fun dataSet(
      session: AbstractSession,
      beforeDataSetName: String,
      afterDataSetName: String,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Rename a data set member
     * @param session z/OSMF connection info
     * @param dataSetName the name of the data set the member belongs to
     * @param beforeMemberName the current name of the member
     * @param afterMemberName the new name of the member
     */
    fun dataSetMember(
      session: AbstractSession,
      dataSetName: String,
      beforeMemberName: String,
      afterMemberName: String,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
