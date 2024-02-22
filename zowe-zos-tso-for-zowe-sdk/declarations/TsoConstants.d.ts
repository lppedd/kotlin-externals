import { IMessageDefinition } from "@zowe/imperative";
/**
 * Constants for TSO related info
 * @export
 * @class TsoConstants
 */
export declare class TsoConstants {
    /**
     * Quert id of logonProcedure passed to z/OSMF URI
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly PARM_PROC: string;
    /**
     * Quert id of character-set passed to z/OSMF URI
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly PARM_CHSET: string;
    /**
     * Quert id of code page passed to z/OSMF URI
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly PARM_CPAGE: string;
    /**
     * Quert id of rows passed to z/OSMF URI
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly PARM_ROWS: string;
    /**
     * Quert id of columns passed to z/OSMF URI
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly PARM_COLS: string;
    /**
     * Quert id of account number passed to z/OSMF URI
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly PARM_ACCT: string;
    /**
     * Quert id of region size passed to z/OSMF URI
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly PARM_RSIZE: string;
    /**
     * Default character-set value
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly DEFAULT_CHSET: string;
    /**
     * Default code page value
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly DEFAULT_CPAGE: string;
    /**
     * Default number of rows value
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly DEFAULT_ROWS: string;
    /**
     * Default number of columns value
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly DEFAULT_COLS: string;
    /**
     * Default region-size value
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly DEFAULT_RSIZE: string;
    /**
     * Default logonProcedure value
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly DEFAULT_PROC: string;
    /**
     * URI base for TSO API
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly RESOURCE: string;
    /**
     * URI for starting TSO
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly RES_START_TSO: string;
    /**
     * Param for not reading reply
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly RES_DONT_READ_REPLY: string;
    /**
     * URI for TSO Ping API
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly RES_PING: string;
    /**
     * Tso response message type - prompt
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly TSO_PROMPT = "TSO PROMPT";
    /**
     * Tso response message type - message
     * @static
     * @type {string}
     * @memberof TsoConstants
     */
    static readonly TSO_MESSAGE = "TSO MESSAGE";
}
/**
 * No Session provided error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noSessionTso: IMessageDefinition;
/**
 * No input parameters were provided error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noTsoStartInput: IMessageDefinition;
/**
 * No input parameters were provided error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noTsoIssueInput: IMessageDefinition;
/**
 * No input parameters for stop were provided error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noTsoStopInput: IMessageDefinition;
/**
 * No ZOSMF response was received error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noZosmfResponse: IMessageDefinition;
/**
 * No servlet key was provided for Ping command error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noPingInput: IMessageDefinition;
/**
 * No account number was provided error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noAccountNumber: IMessageDefinition;
/**
 * No servlet key was provided error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noServletKeyInput: IMessageDefinition;
/**
 * No data parameter string was supplied error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noDataInput: IMessageDefinition;
/**
 * No command text was provided error message
 * @static
 * @type {IMessageDefinition}
 * @memberof TsoConstants
 */
export declare const noCommandInput: IMessageDefinition;
