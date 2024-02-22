@file:JsModule("@zowe/zosmf-for-zowe-sdk")

package zowe.sdk.zosmf.constants

import js.objects.Record
import zowe.imperative.messages.doc.IMessageDefinition

/**
 * Messages to be used as detail display error message when gathering z/OSMF information
 */
external val ZosmfMessages: Record<String, IMessageDefinition>
