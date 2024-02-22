import { ImperativeError } from "../../../error";
import { IRestClientError } from "./doc/IRestClientError";
import { IImperativeErrorParms } from "../../../error/src/doc/IImperativeErrorParms";
export declare class RestClientError extends ImperativeError {
    mDetails: IRestClientError;
    /**
     * Creates an instance of RestClientError.
     * @param {IRestClientError} mDetails - The IRestClientError details provided by the rest client. Contains
     *                                      "relevant" diagnostic information such as host/port/request details, etc.
     * @param {IImperativeErrorParms} [parms] - Imperative error parameters.
     */
    constructor(mDetails: IRestClientError, parms?: IImperativeErrorParms);
    /**
     * Accessor for IRestClientError error details.
     * @type {IRestClientError}
     */
    get details(): IRestClientError;
}
