@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import js.promise.Promise
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.sdk.zos.files.doc.IDataSet
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.copy.doc.ICopyDatasetOptions
import zowe.sdk.zos.files.methods.create.CreateDataSetTypeEnum
import zowe.sdk.zos.files.methods.create.doc.ICreateDataSetOptions
import zowe.sdk.zos.files.methods.delete.doc.IDeleteDatasetOptions
import zowe.sdk.zos.files.methods.download.doc.IDownloadOptions
import zowe.sdk.zos.files.methods.list.doc.IDsmListOptions
import zowe.sdk.zos.files.methods.list.doc.IListOptions
import zowe.sdk.zos.files.methods.upload.doc.IUploadOptions
import kotlin.ts.Partial

/**
 * An implementation of the Zowe Explorer MVS API interface for zOSMF.
 */
external class ZosmfMvsApi : ZosmfApiCommon, ZoweExplorerApi.IMvs {
  constructor(profile: IProfileLoaded = definedExternally)

  override fun dataSet(
    filter: String,
    options: IListOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun allMembers(
    dataSetName: String,
    options: IListOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun getContents(
    dataSetName: String,
    options: IDownloadOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun putContents(
    inputFilePath: String,
    dataSetName: String,
    options: IUploadOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun createDataSet(
    dataSetType: CreateDataSetTypeEnum,
    dataSetName: String,
    options: @Partial ICreateDataSetOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun createDataSetMember(
    dataSetName: String,
    options: IUploadOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun allocateLikeDataSet(
    dataSetName: String,
    likeDataSetName: String,
  ): Promise<IZosFilesResponse<Any?>>

  // TODO(Edoardo): this shouldn't be overridden here!
  override fun copyDataSetMember(
    param0: IDataSet,
    param1: IDataSet,
    options: IMvsCopyDataSetMemberOptions,
  ): Promise<IZosFilesResponse<Any?>>

  fun copyDataSetMember(
    param0: IDataSet,
    param1: IDataSet,
    options: ICopyDatasetOptions = definedExternally,
  ): Promise<IZosFilesResponse<Any?>>

  override fun renameDataSet(
    currentDataSetName: String,
    newDataSetName: String,
  ): Promise<IZosFilesResponse<Any?>>

  override fun renameDataSetMember(
    dataSetName: String,
    currentMemberName: String,
    newMemberName: String,
  ): Promise<IZosFilesResponse<Any?>>

  override fun hMigrateDataSet(dataSetName: String): Promise<IZosFilesResponse<Any?>>

  override fun hRecallDataSet(dataSetName: String): Promise<IZosFilesResponse<Any?>>

  override fun deleteDataSet(
    dataSetName: String,
    options: IDeleteDatasetOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun dataSetsMatchingPattern(
    filter: Array<String>,
    options: IDsmListOptions,
  ): Promise<IZosFilesResponse<Any?>>

  override fun copyDataSet(
    fromDataSetName: String,
    toDataSetName: String,
    enq: String,
    replace: Boolean,
  ): Promise<IZosFilesResponse<Any?>>
}
