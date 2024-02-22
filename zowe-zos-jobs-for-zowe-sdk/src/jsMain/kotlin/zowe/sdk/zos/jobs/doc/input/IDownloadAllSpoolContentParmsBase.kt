package zowe.sdk.zos.jobs.doc.input

/**
 * Interface for downloading all spool content with DownloadJobs API
 */
external interface IDownloadAllSpoolContentParmsBase {
  /**
   * The directory to which you would like to download the output
   * Default value: DownloadJobs.DEFAULT_JOBS_OUTPUT_DIR
   */
  var outDir: String?

  /**
   * If you specify false or do not specify this field, a directory with the jobid of the job as the name
   * will automatically be appended to the outDir.
   * If you specify true, no directory will be appended to your outDir.
   */
  var omitJobidDirectory: Boolean?

  /**
   * The extension to use for the files. Defaults to `.txt`
   * e.g. .log
   */
  var extension: String?

  /**
   * If you specify true for this field, the file will be downloaded in binary mode
   */
  var binary: Boolean?

  /**
   * If you specify true for this field, the file will be downloaded in record mode
   */
  var record: Boolean?
}
