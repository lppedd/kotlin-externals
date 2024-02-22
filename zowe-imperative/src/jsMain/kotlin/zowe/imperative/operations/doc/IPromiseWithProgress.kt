@file:JsModule("@zowe/imperative")

package zowe.imperative.operations.doc

import js.promise.Promise

/**
 * A promise object that also can be tracked for progress bars/ GUIS
 */
external class IPromiseWithProgress<T> : Promise<T> {
  var progress: ITaskWithStatus
}
