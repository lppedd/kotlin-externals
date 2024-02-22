@file:JsModule("@zowe/imperative")

package zowe.imperative.logger

import zowe.imperative.*
import zowe.imperative.cmd.*
import zowe.imperative.cmd.builders.*
import zowe.imperative.cmd.constants.*
import zowe.imperative.cmd.doc.*
import zowe.imperative.cmd.doc.args.*
import zowe.imperative.cmd.doc.handler.*
import zowe.imperative.cmd.doc.option.*
import zowe.imperative.cmd.doc.parms.*
import zowe.imperative.cmd.doc.processor.*
import zowe.imperative.cmd.doc.profiles.*
import zowe.imperative.cmd.doc.profiles.definition.*
import zowe.imperative.cmd.doc.response.*
import zowe.imperative.cmd.doc.response.response.*
import zowe.imperative.cmd.handlers.*
import zowe.imperative.cmd.help.*
import zowe.imperative.cmd.help.abstract.*
import zowe.imperative.cmd.help.doc.*
import zowe.imperative.cmd.profiles.*
import zowe.imperative.cmd.response.*
import zowe.imperative.cmd.syntax.*
import zowe.imperative.cmd.types.*
import zowe.imperative.cmd.utils.*
import zowe.imperative.cmd.yargs.*
import zowe.imperative.cmd.yargs.doc.*
import zowe.imperative.config.*
import zowe.imperative.config.api.*
import zowe.imperative.config.doc.*
import zowe.imperative.console.*
import zowe.imperative.console.doc.*
import zowe.imperative.constants.*
import zowe.imperative.error.*
import zowe.imperative.error.doc.*
import zowe.imperative.expect.*
import zowe.imperative.imperative.*
import zowe.imperative.imperative.api.*
import zowe.imperative.imperative.api.doc.*
import zowe.imperative.imperative.auth.builders.*
import zowe.imperative.imperative.auth.doc.*
import zowe.imperative.imperative.auth.handlers.*
import zowe.imperative.imperative.config.*
import zowe.imperative.imperative.doc.*
import zowe.imperative.imperative.env.*
import zowe.imperative.imperative.handlers.*
import zowe.imperative.imperative.help.*
import zowe.imperative.imperative.plugins.*
import zowe.imperative.imperative.plugins.cmd.install.*
import zowe.imperative.imperative.plugins.cmd.list.*
import zowe.imperative.imperative.plugins.cmd.showfirststeps.*
import zowe.imperative.imperative.plugins.cmd.uninstall.*
import zowe.imperative.imperative.plugins.cmd.update.*
import zowe.imperative.imperative.plugins.cmd.validate.*
import zowe.imperative.imperative.plugins.doc.*
import zowe.imperative.imperative.plugins.errors.*
import zowe.imperative.imperative.plugins.utilities.*
import zowe.imperative.imperative.profiles.*
import zowe.imperative.imperative.profiles.builders.*
import zowe.imperative.imperative.profiles.handlers.*
import zowe.imperative.interfaces.doc.*
import zowe.imperative.interfaces.types.*
import zowe.imperative.io.*
import zowe.imperative.logger.doc.*
import zowe.imperative.messages.*
import zowe.imperative.messages.doc.*
import zowe.imperative.operations.*
import zowe.imperative.operations.doc.*
import zowe.imperative.profiles.*
import zowe.imperative.profiles.abstract.*
import zowe.imperative.profiles.constants.*
import zowe.imperative.profiles.doc.api.*
import zowe.imperative.profiles.doc.config.*
import zowe.imperative.profiles.doc.definition.*
import zowe.imperative.profiles.doc.parms.*
import zowe.imperative.profiles.doc.response.*
import zowe.imperative.profiles.utils.*
import zowe.imperative.profiles.validation.api.*
import zowe.imperative.profiles.validation.doc.*
import zowe.imperative.rest.client.*
import zowe.imperative.rest.client.doc.*
import zowe.imperative.rest.client.types.*
import zowe.imperative.rest.session.*
import zowe.imperative.rest.session.doc.*
import zowe.imperative.security.*
import zowe.imperative.security.abstract.*
import zowe.imperative.security.doc.*
import zowe.imperative.security.errors.*
import zowe.imperative.settings.*
import zowe.imperative.settings.doc.*
import zowe.imperative.settings.errors.*
import zowe.imperative.settings.persistance.*
import zowe.imperative.utilities.*
import zowe.imperative.utilities.diff.*
import zowe.imperative.utilities.diff.doc.*
import zowe.imperative.utilities.doc.*

external class LoggerUtils {
  companion object {
    @JsString("****")
    val CENSOR_RESPONSE: String

    /**
     * NOTE(Kelosky): Ideally we might have a consolidated list for secure fields, but for now we'll
     * just make sure they're collocated within the same class.
     */
    var CENSORED_OPTIONS: Array<String>
    var SECURE_PROMPT_OPTIONS: Array<String>

    /**
     * Copy and censor any sensitive CLI arguments before logging/printing
     */
    fun censorCLIArgs(args: Array<String>): Array<String>

    /**
     * Copy and censor a yargs argument object before logging
     *
     * @param args the args to censor
     * @return a censored copy of the arguments
     */
    fun censorYargsArguments(args: ICommandArguments): ICommandArguments

    val profileSchemas: Array<ICommandProfileTypeConfiguration>

    fun setProfileSchemas(_schemas: Map<String, IProfileSchema>)

    /**
     * Specifies whether a given property path (e.g. "profiles.lpar1.properties.host") is a special
     * value or not. Special value: Refers to any value defined as secure in the schema definition.
     * These values should be already masked by the application (and/or plugin) developer.
     *
     * @param prop Property path to determine if it is a special value
     * @return True - if the given property is to be treated as a special value; False - otherwise
     */
    var isSpecialValue: (prop: String) -> Boolean

    /**
     * Copy and censor any sensitive CLI arguments before logging/printing
     */
    fun censorRawData(
      data: String,
      category: String = definedExternally,
    ): String
  }
}
