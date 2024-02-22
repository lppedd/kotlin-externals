@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles

import zowe.sdk.zos.files.doc.IDataSet

/**
 * Converts the name of a data set to an IDataSet
 * @param name the name in the form USER.DATA.SET | USER.DATA.SET(mem1)
 */
@Deprecated("use @zowe/zos-files-for-zowe-sdk's ZosFilesUtils.getDataSetFromName instead")
external fun getDataSet(name: String): IDataSet
