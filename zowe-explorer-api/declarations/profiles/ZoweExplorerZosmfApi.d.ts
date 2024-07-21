/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 *
 */
/// <reference types="node" />
import * as zowe from "@zowe/cli";
import { ZoweExplorerApi } from "./ZoweExplorerApi";
import { FileAttributes } from "../utils/files";
/**
 * An implementation of the Zowe Explorer API Common interface for zOSMF.
 */
declare class ZosmfApiCommon implements ZoweExplorerApi.ICommon {
    profile?: zowe.imperative.IProfileLoaded;
    static getProfileTypeName(): string;
    private session;
    constructor(profile?: zowe.imperative.IProfileLoaded);
    getProfileTypeName(): string;
    getSessionFromCommandArgument(cmdArgs: zowe.imperative.ICommandArguments): zowe.imperative.Session;
    getSession(profile?: zowe.imperative.IProfileLoaded): zowe.imperative.Session;
    private _getSession;
    getStatus(validateProfile?: zowe.imperative.IProfileLoaded, profileType?: string): Promise<string>;
    getTokenTypeName(): string;
    login(session: zowe.imperative.Session): Promise<string>;
    logout(session: zowe.imperative.Session): Promise<void>;
}
/**
 * An implementation of the Zowe Explorer USS API interface for zOSMF.
 */
export declare class ZosmfUssApi extends ZosmfApiCommon implements ZoweExplorerApi.IUss {
    fileList(ussFilePath: string): Promise<zowe.IZosFilesResponse>;
    isFileTagBinOrAscii(ussFilePath: string): Promise<boolean>;
    getContents(inputFilePath: string, options: zowe.IDownloadOptions): Promise<zowe.IZosFilesResponse>;
    copy(outputPath: string, options?: Omit<object, "request">): Promise<Buffer>;
    /**
     * API method to wrap to the newer `putContent`.
     * @deprecated
     */
    putContents(inputFilePath: string, ussFilePath: string, binary?: boolean, localEncoding?: string, etag?: string, returnEtag?: boolean): Promise<zowe.IZosFilesResponse>;
    putContent(inputFilePath: string, ussFilePath: string, options: zowe.IUploadOptions): Promise<zowe.IZosFilesResponse>;
    updateAttributes(ussPath: string, attributes: Partial<FileAttributes>): Promise<zowe.IZosFilesResponse>;
    uploadDirectory(inputDirectoryPath: string, ussDirectoryPath: string, options?: zowe.IUploadOptions): Promise<zowe.IZosFilesResponse>;
    create(ussPath: string, type: string, mode?: string): Promise<zowe.IZosFilesResponse>;
    delete(ussPath: string, recursive?: boolean): Promise<zowe.IZosFilesResponse>;
    rename(currentUssPath: string, newUssPath: string): Promise<zowe.IZosFilesResponse>;
    getTag(ussPath: string): Promise<string>;
}
/**
 * An implementation of the Zowe Explorer MVS API interface for zOSMF.
 */
export declare class ZosmfMvsApi extends ZosmfApiCommon implements ZoweExplorerApi.IMvs {
    dataSet(filter: string, options?: zowe.IListOptions): Promise<zowe.IZosFilesResponse>;
    allMembers(dataSetName: string, options?: zowe.IListOptions): Promise<zowe.IZosFilesResponse>;
    getContents(dataSetName: string, options?: zowe.IDownloadOptions): Promise<zowe.IZosFilesResponse>;
    putContents(inputFilePath: string, dataSetName: string, options?: zowe.IUploadOptions): Promise<zowe.IZosFilesResponse>;
    createDataSet(dataSetType: zowe.CreateDataSetTypeEnum, dataSetName: string, options?: Partial<zowe.ICreateDataSetOptions>): Promise<zowe.IZosFilesResponse>;
    createDataSetMember(dataSetName: string, options?: zowe.IUploadOptions): Promise<zowe.IZosFilesResponse>;
    allocateLikeDataSet(dataSetName: string, likeDataSetName: string): Promise<zowe.IZosFilesResponse>;
    copyDataSetMember({ dsn: fromDataSetName, member: fromMemberName }: zowe.IDataSet, { dsn: toDataSetName, member: toMemberName }: zowe.IDataSet, options?: zowe.ICopyDatasetOptions): Promise<zowe.IZosFilesResponse>;
    renameDataSet(currentDataSetName: string, newDataSetName: string): Promise<zowe.IZosFilesResponse>;
    renameDataSetMember(dataSetName: string, oldMemberName: string, newMemberName: string): Promise<zowe.IZosFilesResponse>;
    hMigrateDataSet(dataSetName: string): Promise<zowe.IZosFilesResponse>;
    hRecallDataSet(dataSetName: string): Promise<zowe.IZosFilesResponse>;
    deleteDataSet(dataSetName: string, options?: zowe.IDeleteDatasetOptions): Promise<zowe.IZosFilesResponse>;
    dataSetsMatchingPattern(filter: string[], options?: zowe.IDsmListOptions): Promise<zowe.IZosFilesResponse>;
    copyDataSet(fromDataSetName: string, toDataSetName: string, enq?: string, replace?: boolean): Promise<zowe.IZosFilesResponse>;
}
/**
 * An implementation of the Zowe Explorer JES API interface for zOSMF.
 */
export declare class ZosmfJesApi extends ZosmfApiCommon implements ZoweExplorerApi.IJes {
    getJobsByParameters(params: zowe.IGetJobsParms): Promise<zowe.IJob[]>;
    getJobsByOwnerAndPrefix(owner: string, prefix: string): Promise<zowe.IJob[]>;
    getJob(jobid: string): Promise<zowe.IJob>;
    getSpoolFiles(jobname: string, jobid: string): Promise<zowe.IJobFile[]>;
    downloadSpoolContent(parms: zowe.IDownloadAllSpoolContentParms): Promise<void>;
    downloadSingleSpool(parms: zowe.IDownloadSpoolContentParms): Promise<void>;
    getSpoolContentById(jobname: string, jobid: string, spoolId: number): Promise<string>;
    getJclForJob(job: zowe.IJob): Promise<string>;
    submitJcl(jcl: string, internalReaderRecfm?: string, internalReaderLrecl?: string): Promise<zowe.IJob>;
    submitJob(jobDataSet: string): Promise<zowe.IJob>;
    deleteJob(jobname: string, jobid: string): Promise<void>;
    deleteJobWithInfo(jobname: string, jobid: string): Promise<undefined | zowe.IJobFeedback>;
    cancelJob(job: zowe.IJob): Promise<boolean>;
}
/**
 * An implementation of the Zowe Explorer Command API interface for zOSMF.
 */
export declare class ZosmfCommandApi extends ZosmfApiCommon implements ZoweExplorerApi.ICommand {
    issueTsoCommand(command: string, acctNum: string): Promise<zowe.IIssueResponse>;
    issueTsoCommandWithParms(command: string, parms: zowe.IStartTsoParms): Promise<zowe.IIssueResponse>;
    issueMvsCommand(command: string, consoleName?: string): Promise<zowe.IConsoleResponse>;
}
export {};
