@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

import js.promise.Promise

/**
 * Execute multiple promises in a pool with a maximum number of promises
 * executing at once
 *
 * @param poolLimit limit of how many promises should execute at once
 * @param array array of objects to convert to promises with iteratorFn
 * @param iteratorFn the function that turns an entry in the array into a promise
 */
external fun asyncPool(
  poolLimit: Int,
  array: Array<Any?>,
  iteratorFn: (item: Any?, array: Array<Any?>) -> Promise<Any?>,
): Promise<Any?>
