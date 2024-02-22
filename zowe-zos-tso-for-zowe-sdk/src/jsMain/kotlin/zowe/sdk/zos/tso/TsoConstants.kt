@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import zowe.imperative.messages.doc.IMessageDefinition

/**
 * Constants for TSO related info
 */
external class TsoConstants {
  companion object {
    /**
     * Quert id of logonProcedure passed to z/OSMF URI
     */
    val PARM_PROC: String

    /**
     * Quert id of character-set passed to z/OSMF URI
     */
    val PARM_CHSET: String

    /**
     * Quert id of code page passed to z/OSMF URI
     */
    val PARM_CPAGE: String

    /**
     * Quert id of rows passed to z/OSMF URI
     */
    val PARM_ROWS: String

    /**
     * Quert id of columns passed to z/OSMF URI
     */
    val PARM_COLS: String

    /**
     * Quert id of account number passed to z/OSMF URI
     */
    val PARM_ACCT: String

    /**
     * Quert id of region size passed to z/OSMF URI
     */
    val PARM_RSIZE: String

    /**
     * Default character-set value
     */
    val DEFAULT_CHSET: String

    /**
     * Default code page value
     */
    val DEFAULT_CPAGE: String

    /**
     * Default number of rows value
     */
    val DEFAULT_ROWS: String

    /**
     * Default number of columns value
     */
    val DEFAULT_COLS: String

    /**
     * Default region-size value
     */
    val DEFAULT_RSIZE: String

    /**
     * Default logonProcedure value
     */
    val DEFAULT_PROC: String

    /**
     * URI base for TSO API
     */
    val RESOURCE: String

    /**
     * URI for starting TSO
     */
    val RES_START_TSO: String

    /**
     * Param for not reading reply
     */
    val RES_DONT_READ_REPLY: String

    /**
     * URI for TSO Ping API
     */
    val RES_PING: String

    /**
     * Tso response message type - prompt
     */
    @JsString("TSO PROMPT")
    val TSO_PROMPT: String

    /**
     * Tso response message type - message
     */
    @JsString("TSO MESSAGE")
    val TSO_MESSAGE: String
  }
}

/**
 * No Session provided error message
 */
external val noSessionTso: IMessageDefinition

/**
 * No input parameters were provided error message
 */
external val noTsoStartInput: IMessageDefinition

/**
 * No input parameters were provided error message
 */
external val noTsoIssueInput: IMessageDefinition

/**
 * No input parameters for stop were provided error message
 */
external val noTsoStopInput: IMessageDefinition

/**
 * No ZOSMF response was received error message
 */
external val noZosmfResponse: IMessageDefinition

/**
 * No servlet key was provided for Ping command error message
 */
external val noPingInput: IMessageDefinition

/**
 * No account number was provided error message
 */
external val noAccountNumber: IMessageDefinition

/**
 * No servlet key was provided error message
 */
external val noServletKeyInput: IMessageDefinition

/**
 * No data parameter string was supplied error message
 */
external val noDataInput: IMessageDefinition

/**
 * No command text was provided error message
 */
external val noCommandInput: IMessageDefinition
