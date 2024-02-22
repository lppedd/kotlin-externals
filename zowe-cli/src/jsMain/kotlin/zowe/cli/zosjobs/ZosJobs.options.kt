@file:JsModule("@zowe/cli")

package zowe.cli.zosjobs

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

external val ZosJobsOptions: Record<String, ICommandOptionDefinition>
