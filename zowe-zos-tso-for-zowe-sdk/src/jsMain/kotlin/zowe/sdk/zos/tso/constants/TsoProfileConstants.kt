@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso.constants

import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

external class TsoProfileConstants {
  companion object {
    val TSO_OPTION_GROUP: String
    val TSO_OPTION_ACCOUNT: ICommandOptionDefinition
    val TSO_OPTION_ACCOUNT_PROFILE: ICommandOptionDefinition
    val TSO_OPTION_CHAR_SET: ICommandOptionDefinition
    val TSO_OPTION_CODE_PAGE: ICommandOptionDefinition
    val TSO_OPTION_COLUMNS: ICommandOptionDefinition
    val TSO_OPTION_LOGON_PROCEDURE: ICommandOptionDefinition
    val TSO_OPTION_REGION_SIZE: ICommandOptionDefinition
    val TSO_OPTION_ROWS: ICommandOptionDefinition
    val TSO_PROFILE_OPTIONS: Array<ICommandOptionDefinition>
  }
}
