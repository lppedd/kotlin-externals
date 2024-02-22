/// <reference types="node" />
import { Writable } from "stream";
import { IJobFile } from "../response/IJobFile";
import { IDownloadAllSpoolContentParms } from "./IDownloadAllSpoolContentParms";
/**
 * Interface for downloading single spool file with DownloadJobs API
 * @export
 * @interface IDownloadAllSpoolContentParms
 */
export interface IDownloadSpoolContentParms extends Omit<IDownloadAllSpoolContentParms, "jobname" | "jobid"> {
    /**
     * Job file document for job output we want to download
     * @type {IJobFile}
     * @memberof IDownloadSpoolContentParms
     */
    jobFile?: IJobFile;
    /**
     * Name of the job for which you want to download all output
     * e.g. MYJOBNM
     * @type {string}
     * @memberof IDownloadAllSpoolContentParms
     */
    jobname?: string;
    /**
     * JOB ID of the job for which you want to download all output
     * e.g. JOB00001
     * @type {string}
     * @memberof IDownloadAllSpoolContentParms
     */
    jobid?: string;
    /**
     * Optional stream to read the spool contents
     * @type {Writable}
     * @memberof IDownloadAllSpoolContentParms
     */
    stream?: Writable;
}
