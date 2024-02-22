@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.constants

import js.objects.Record
import zowe.imperative.messages.doc.IMessageDefinition

/**
 * Messages to be used as command responses for different scenarios
 */
external val ZosFilesMessages: Record<String, IMessageDefinition>
