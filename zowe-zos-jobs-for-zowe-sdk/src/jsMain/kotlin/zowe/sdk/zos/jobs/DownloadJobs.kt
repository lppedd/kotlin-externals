@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.jobs.doc.input.IDownloadAllSpoolContentParms
import zowe.sdk.zos.jobs.doc.input.IDownloadSpoolContentParms
import zowe.sdk.zos.jobs.doc.response.IJobFile

/**
 * Class to handle downloading of job information
 */
external class DownloadJobs {
  companion object {
    /**
     * Default directory where output will be placed
     */
    val DEFAULT_JOBS_OUTPUT_DIR: String

    /**
     * Default extension of downloaded folders
     */
    val DEFAULT_JOBS_OUTPUT_FILE_EXT: String

    /**
     * Download spool content to a the default download directory
     * @param session z/OSMF connection info
     * @param jobFile spool file to download
     * @return content downloaded
     */
    fun downloadSpoolContent(
      session: AbstractSession,
      jobFile: IJobFile,
    ): Promise<Unit>

    /**
     * Download all job output (spool content) for a job to a the local directory
     * @param session z/OSMF connection info
     * @param parms parameter object (see IDownloadAllSpoolContentParms for details)
     * @return a promise which will resolve when the download is complete
     */
    fun downloadAllSpoolContentCommon(
      session: AbstractSession,
      parms: IDownloadAllSpoolContentParms,
    ): Promise<Unit>

    /**
     * Download spool content to specified directory
     * @param session z/OSMF connection info
     * @param parms parm object (see IDownloadSpoolContentParms interface for details)
     * @return promise that resolves when the file is downloaded
     */
    fun downloadSpoolContentCommon(
      session: AbstractSession,
      parms: IDownloadSpoolContentParms,
    ): Promise<Unit>

    /**
     * Get the file where a specified spool file (IJobFile) would be downloaded to
     * @param jobFile the spool file that would be downloaded
     * @param omitJobidDirectory if true, the job ID of the jobFile will not be included in the file path
     * @param outDir parent output directory you would like to download to
     * @return the file path that the spool file would be downloaded to
     */
    @Deprecated("Use getSpoolDownloadFilePath instead")
    fun getSpoolDownloadFile(
      jobFile: IJobFile,
      omitJobidDirectory: Boolean = definedExternally,
      outDir: String = definedExternally,
    ): String

    /**
     * Get the file where a specified spool file (IJobFile) would be downloaded to
     * @param parms parm object (see IDownloadSpoolContentParms interface for details)
     * @return the file path that the spool file would be downloaded to
     */
    fun getSpoolDownloadFilePath(parms: IDownloadSpoolContentParms): String
  }
}
