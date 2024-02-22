@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

import js.promise.Promise
import node.buffer.Buffer

/**
 * Utility function to read complete standard in contents from a handler
 * Can be awaited from async methods
 */
external fun readStdin(): Promise<Buffer>
