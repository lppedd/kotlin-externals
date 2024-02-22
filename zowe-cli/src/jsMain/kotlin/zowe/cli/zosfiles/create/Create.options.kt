@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.create

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the Create API
 */
external val ZosFilesCreateExtraOptions: Record<String, ICommandOptionDefinition>

/**
 * Object containing all options to be used by the Create API
 */
external val ZosFilesCreateOptions: Record<String, ICommandOptionDefinition>
