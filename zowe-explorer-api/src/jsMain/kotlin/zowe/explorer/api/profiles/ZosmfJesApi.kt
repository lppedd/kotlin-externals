@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import js.promise.Promise
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.sdk.zos.jobs.doc.input.IDownloadAllSpoolContentParms
import zowe.sdk.zos.jobs.doc.input.IDownloadSpoolContentParms
import zowe.sdk.zos.jobs.doc.input.IGetJobsParms
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.doc.response.IJobFeedback
import zowe.sdk.zos.jobs.doc.response.IJobFile

/**
 * An implementation of the Zowe Explorer JES API interface for zOSMF.
 */
external class ZosmfJesApi : ZosmfApiCommon, ZoweExplorerApi.IJes {
  constructor(profile: IProfileLoaded = definedExternally)

  override fun getJobsByParameters(params: IGetJobsParms): Promise<Array<IJob>>

  override fun getJobsByOwnerAndPrefix(
    owner: String,
    prefix: String,
  ): Promise<Array<IJob>>

  override fun getJob(jobid: String): Promise<IJob>

  override fun getSpoolFiles(
    jobname: String,
    jobid: String,
  ): Promise<Array<IJobFile>>

  override fun downloadSpoolContent(parms: IDownloadAllSpoolContentParms): Promise<Unit>

  override fun downloadSingleSpool(parms: IDownloadSpoolContentParms): Promise<Unit>

  override fun getSpoolContentById(
    jobname: String,
    jobid: String,
    spoolId: Double,
  ): Promise<String>

  override fun getJclForJob(job: IJob): Promise<String>

  override fun submitJcl(
    jcl: String,
    internalReaderRecfm: String,
    internalReaderLrecl: String,
  ): Promise<IJob>

  override fun submitJob(jobDataSet: String): Promise<IJob>

  override fun deleteJob(
    jobname: String,
    jobid: String,
  ): Promise<Unit>

  override fun deleteJobWithInfo(
    jobname: String,
    jobid: String,
  ): Promise<IJobFeedback?>

  override fun cancelJob(job: IJob): Promise<Boolean>
}
