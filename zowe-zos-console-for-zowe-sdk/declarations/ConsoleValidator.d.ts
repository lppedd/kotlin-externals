import { ICollectParms, IIssueParms } from "./";
import { IZosmfIssueParms } from "./doc/zosmf/IZosmfIssueParms";
import { AbstractSession } from "@zowe/imperative";
/**
 * Class validates parameters for console commands
 * @export
 * @class ConsoleValidator
 */
export declare class ConsoleValidator {
    /**
     * Validate supplied parameters
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {string} consoleName name of the EMCS console that is used to issue the command
     * @param {IZosmfIssueParms} commandParms synchronous console issue parameters, @see {IZosmfIssueParms}
     * @memberof
     */
    static validateCommonParms(session: AbstractSession, consoleName: string, commandParms: IZosmfIssueParms): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {IIssueParms} parms console issue parameters, @see {IIssueParms}
     * @memberof ConsoleValidator
     */
    static validateIssueParms(session: AbstractSession, parms: IIssueParms): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {string} theCommand command to issue
     * @memberof ConsoleValidator
     */
    static validateIssueSimpleParms(session: AbstractSession, theCommand: string): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {ICollectParms} parms console collect parameters, @see {ICollectParms}
     * @memberof ConsoleValidator
     */
    static validateCollectParm(parms: ICollectParms): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {IIssueParms} parms console issue parameters, @see {IIssueParms}
     * @memberof ConsoleValidator
     */
    static validateIssueParm(parms: IIssueParms): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {string} consoleName name of the EMCS console that is used to issue the command
     * @param {string} commandResponseKey command response key from the Issue Command request
     * @memberof ConsoleValidator
     */
    static validateCollectCommonParms(session: AbstractSession, consoleName: string, commandResponseKey: string): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {ICollectParms} parms console collect parameters, @see {ICollectParms}
     * @memberof ConsoleValidator
     */
    static validateCollectParms(session: AbstractSession, parms: ICollectParms): void;
    /**
     * Validate session
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @memberof ConsoleValidator
     */
    private static validateSession;
    /**
     * Validate console name
     * @static
     * @param {string} consoleName
     * @memberof ConsoleValidator
     */
    private static validateConsoleName;
}
