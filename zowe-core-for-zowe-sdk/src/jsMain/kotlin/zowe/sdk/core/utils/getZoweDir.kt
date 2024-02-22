@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

/**
 * Retrieves the Zowe CLI home directory. In the situation Imperative has
 * not initialized it we mock a default value.
 *
 * @return Returns the Zowe home directory
 */
external fun getZoweDir(): String
