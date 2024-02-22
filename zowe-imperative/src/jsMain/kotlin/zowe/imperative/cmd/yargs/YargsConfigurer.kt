@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.yargs

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.doc.response.parms.ICommandResponseParms
import zowe.imperative.cmd.help.doc.IHelpGeneratorFactory
import zowe.imperative.profiles.doc.api.IProfileManagerFactory

/**
 * Before invoking commands, this class configures some settings and callbacks in Yargs, including
 * what happens on syntax failures.
 */
external class YargsConfigurer {
  constructor(
    rootCommand: ICommandDefinition,
    yargs: Any?,
    commandRespParms: ICommandResponseParms,
    profileManagerFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>,
    helpGeneratorFactory: IHelpGeneratorFactory,
    experimentalCommandDescription: String,
    rootCommandName: String,
    commandLine: String,
    envVariablePrefix: String,
    promptPhrase: String,
  )

  fun configure()
}
