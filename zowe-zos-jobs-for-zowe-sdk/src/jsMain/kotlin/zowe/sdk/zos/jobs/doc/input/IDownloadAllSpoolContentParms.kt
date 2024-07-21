package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for downloading all spool content with DownloadJobs API
 */
external interface IDownloadAllSpoolContentParms : IDownloadAllSpoolContentParmsBase {
  /**
   * Name of the job for which you want to download all output
   * e.g. MYJOBNM
   */
  var jobname: String

  /**
   * JOB ID of the job for which you want to download all output
   * e.g. JOB00001
   */
  var jobid: String

  /**
   * The codepage to use for translation from EBCDIC
   */
  var encoding: String?
}
