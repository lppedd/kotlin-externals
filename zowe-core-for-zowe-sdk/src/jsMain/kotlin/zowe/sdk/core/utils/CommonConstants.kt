@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

import zowe.imperative.messages.doc.IMessageDefinition

/**
 * Error message that no z/OSMF version parameter string was supplied.
 */
external val nozOSMFVersion: IMessageDefinition

/**
 * Error message that no session was supplied.
 */
external val noSession: IMessageDefinition
