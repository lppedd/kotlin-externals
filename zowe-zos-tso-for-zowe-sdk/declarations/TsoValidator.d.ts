import { AbstractSession } from "@zowe/imperative";
import { IStartTsoParms } from "./doc/input/IStartTsoParms";
import { IStopTsoParms } from "./doc/input/IStopTsoParms";
import { IIssueTsoParms } from "./doc/input/IIssueTsoParms";
import { IZosmfPingResponse } from "./doc/zosmf/IZosmfPingResponse";
import { IZosmfTsoResponse } from "./doc/zosmf/IZosmfTsoResponse";
/**
 * Class validates parameters for TSO commands
 * @export
 * @class TsoValidator
 */
export declare class TsoValidator {
    /**
     * Validate session
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @memberof TsoValidator
     */
    static validateSession(session: AbstractSession): void;
    /**
     * Validate TSO start command parameters
     * @param {IStartTsoParms} parms - object with required parameters, @see {IStartTsoParms}
     * @memberof TsoValidator
     */
    static validateStartParams(parms: IStartTsoParms): void;
    /**
     * Validate TSO issue command parameters
     * @param {IStartTsoParms} parms - object with required parameters, @see {IIssueTsoParms}
     * @memberof TsoValidator
     */
    static validateIssueParams(parms: IIssueTsoParms): void;
    /**
     * Validate TSO stop command parameters
     * @param {IStopTsoParms} parms - object with required parameters, @see {IStopTsoParms}
     * @memberof TsoValidator
     */
    static validateStopParams(parms: IStopTsoParms): void;
    /**
     * Validate z/OSMF response, needed for service and filtering servlet key
     * @param {IZosmfTsoResponse} parms - object response from z/OSMF, @see {IZosmfTsoResponse}
     * @memberof TsoValidator
     */
    static validateStartZosmfResponse(parms: IZosmfTsoResponse): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} text - string to check if not empty or undefined
     * @param {string} errorMsg - message to show in text case validation fails
     * @memberof TsoValidator
     */
    static validatePingParms(session: AbstractSession, text: string, errorMsg: string): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {string} text - string to check if not null or undefined
     * @param {string} errorMsg - message to show in text case validation fails
     * @memberof TsoValidator
     */
    static validateString(text: string, errorMsg: string): void;
    /**
     * Validate supplied parameters
     * @static
     * @param {string} text - string to check if empty
     * @param {string} errorMsg - message to show in text case validation fails
     * @memberof TsoValidator
     */
    static validateNotEmptyString(text: string, errorMsg: string): void;
    /**
     * Validate z/OSMF response
     * @param {IZosmfPingResponse} parms - object response from z/OSMF, @see {IZosmfPingResponse}
     * @memberof TsoValidator
     */
    static validatePingZosmfResponse(parms: IZosmfPingResponse): void;
    /**
     * Validate z/OSMF response for errors
     * @param {IZosmfTsoResponse} zosmfResponse - object response from z/OSMF, @see {IZosmfTsoResponse}
     * @memberof TsoValidator
     */
    static validateErrorMessageFromZosmf(zosmfResponse: IZosmfTsoResponse): void;
}
