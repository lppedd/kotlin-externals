package zowe.sdk.zos.jobs.doc.input

import node.stream.Writable
import zowe.sdk.zos.jobs.doc.response.IJobFile

/**
 * Interface for downloading single spool file with DownloadJobs API
 */
external interface IDownloadSpoolContentParms : IDownloadAllSpoolContentParmsBase {
  /**
   * Job file document for job output we want to download
   */
  var jobFile: IJobFile?

  /**
   * Name of the job for which you want to download all output
   * e.g. MYJOBNM
   */
  var jobname: String?

  /**
   * JOB ID of the job for which you want to download all output
   * e.g. JOB00001
   */
  var jobid: String?

  /**
   * Optional stream to read the spool contents
   */
  var stream: Writable?
}
