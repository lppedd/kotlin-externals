@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.auto.init

import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

external class AutoInitConstants {
  companion object {
    var AUTO_INIT_OPTION_GROUP: String

    /**
     * Option used to specify whether or not to use the user layer of the config
     */
    var AUTO_INIT_OPTION_USER_CONFIG: ICommandOptionDefinition

    /**
     * Option used to specify whether or not to use the global layer of the config
     */
    var AUTO_INIT_OPTION_GLOBAL_CONFIG: ICommandOptionDefinition

    /**
     * Option used to specify whether or not to do a dry run of the initialization
     */
    var AUTO_INIT_OPTION_DRY_RUN: ICommandOptionDefinition

    /**
     * Option used to specify whether or not to open an editor for the config
     */
    var AUTO_INIT_OPTION_EDIT: ICommandOptionDefinition

    /**
     * Option used to specify whether or not to overwrite the config
     */
    var AUTO_INIT_OPTION_OVERWRITE: ICommandOptionDefinition

    /**
     * Option used to confirm an overwrite
     */
    var AUTO_INIT_OPTION_FOR_SURE: ICommandOptionDefinition
  }
}
