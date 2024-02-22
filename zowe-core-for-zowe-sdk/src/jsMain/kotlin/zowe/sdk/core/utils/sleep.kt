@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

import js.promise.Promise

/**
 * This is a simple sleep function to help when waiting for a certain period of
 * time before continuing.
 *
 * Example:
 *
 * **Sleeping within code**
 * ```
 * async function doStuff() {
 *   await CoreUtils.sleep(10000);
 *   console.log("You will see this message 10 seconds after function was entered");
 * }
 * ```
 *
 * @param ms The number of milliseconds to sleep.
 * @return Resolves after the specified time is up.
 */
external fun sleep(ms: Int = definedExternally): Promise<Unit>
