@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.upload

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all options to be used by the Upload API
 */
external val UploadOptions: Record<String, ICommandOptionDefinition>
