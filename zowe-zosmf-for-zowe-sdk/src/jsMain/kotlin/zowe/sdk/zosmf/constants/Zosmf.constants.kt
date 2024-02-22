@file:JsModule("@zowe/zosmf-for-zowe-sdk")

package zowe.sdk.zosmf.constants

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Constants to be used by the z/OSMF API
 */
external val ZosmfConstants: Record<String, Any>

/**
 * Object containing all options to be used by the Download data set API
 */
external val ZosFilesOptions: Record<String, ICommandOptionDefinition>
