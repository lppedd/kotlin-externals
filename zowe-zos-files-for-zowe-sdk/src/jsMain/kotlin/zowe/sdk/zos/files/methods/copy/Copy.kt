@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.copy

import js.errors.JsError
import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.core.rest.ZosmfRestClient
import zowe.sdk.zos.files.doc.IDataSet
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.copy.doc.ICopyDatasetOptions
import zowe.sdk.zos.files.methods.copy.doc.ICrossLparCopyDatasetOptions
import zowe.sdk.zos.files.methods.get.doc.IGetOptions

/**
 * This class holds helper functions that are used to copy the contents of datasets through the
 * z/OSMF APIs.
 */
external class Copy {
  companion object {
    /**
     * Copy the contents of a dataset
     *
     * See https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.1.0/com.ibm.zos.v2r1.izua700/IZUHPINFO_API_PutDataSetMemberUtilities.htm
     *
     * @param session z/OSMF connection info
     * @param toDataSet The data set to copy to
     * @param options Options
     *
     * @return A response indicating the status of the copying
     *
     * @throws ImperativeError Data set name must be specified as a non-empty string
     * @throws JsError When the [ZosmfRestClient] throws an error
     *
     */
    fun dataSet(
      session: AbstractSession,
      toDataSet: IDataSet, // TODO(Edaordo): fix to { dsn: toDataSetName, member: toMemberName }: IDataSet
      options: ICopyDatasetOptions,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Copy the contents of a dataset from one LPAR to another LPAR
     *
     * @param sourceSession Source z/OSMF connection info
     * @param toDataSet The data set to copy to
     * @param targetOptions Options for target file and connection
     * @param sourceOptions Options for source file
     * @param options Common options
     * @param console Command console object
     *
     * @return A response indicating the status of the copying
     *
     * @throws ImperativeError Data set name must be specified as a non-empty string
     * @throws JsError When the [ZosmfRestClient] throws an error
     *
     */
    fun dataSetCrossLPAR(
      sourceSession: AbstractSession,
      toDataSet: IDataSet,
      targetOptions: ICrossLparCopyDatasetOptions,
      sourceOptions: IGetOptions,
      targetSession: AbstractSession,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
