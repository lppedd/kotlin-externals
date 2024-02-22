import { IImperativeError } from "./doc/IImperativeError";
import { IImperativeErrorParms } from "./doc/IImperativeErrorParms";
/**
 *
 * @export
 * @class ImperativeError
 * @extends {Error}
 */
export declare class ImperativeError extends Error {
    mDetails: IImperativeError;
    /**
     * The message generated/specified for the error - used for display/message/diagnostic purposes
     * @private
     * @type {string}
     * @memberof ImperativeError
     */
    private mMessage;
    /**
     * Construct the Imperative error object. Contains the defaults of the error and optionally captures diagnostics
     * and other information.
     * @param {IImperativeError} details - the error details and text (stack, messages, etc.)
     * @param {IImperativeErrorParms} parms - control parameters to indicate logging of node-report and more
     */
    constructor(mDetails: IImperativeError, parms?: IImperativeErrorParms);
    /**
     * Return causeErrors
     * @readonly
     * @type {any[]}
     * @memberof ImperativeError
     */
    get causeErrors(): any;
    /**
     * Return additionalDetails
     * @readonly
     * @type {string}
     * @memberof ImperativeError
     */
    get additionalDetails(): string;
    /**
     * Return IImperativeError object
     * @readonly
     * @type {IImperativeError}
     * @memberof ImperativeError
     */
    get details(): IImperativeError;
    /**
     * Return errorCode
     * @readonly
     * @type {string}
     * @memberof ImperativeError
     */
    get errorCode(): string;
    /**
     * Return whether or not the error dump should be suppressed
     * @readonly
     * @type {string}
     * @memberof ImperativeError
     */
    get suppressDump(): boolean;
    /**
     * Return stack info
     * @readonly
     * @type {string}
     * @memberof ImperativeError
     */
    get stack(): string;
    /**
     * Accessor for the error message.
     * @readonly
     * @return {string}: The error message
     * @memberof ImperativeError
     */
    get message(): string;
}
