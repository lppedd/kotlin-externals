@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.create.ussDir

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Specifies the file or directory permission bits to be used in creating the file or directory.
 */
external val UssCreateOptions: Record<String, ICommandOptionDefinition>
