import { IDataSet } from "@zowe/zos-files-for-zowe-sdk";
/**
 * @deprecated - use @zowe/zos-files-for-zowe-sdk's ZosFilesUtils.getDataSetFromName instead
 * Converts the name of a data set to an IDataSet
 * @param {string} name  - the name in the form USER.DATA.SET | USER.DATA.SET(mem1)
 */
export declare function getDataSet(name: string): IDataSet;
