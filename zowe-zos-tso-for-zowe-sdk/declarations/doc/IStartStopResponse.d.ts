import { IZosmfTsoResponse } from "./zosmf/IZosmfTsoResponse";
import { ImperativeError } from "@zowe/imperative";
export interface IStartStopResponse {
    /**
     * True if the command was issued and the responses were collected.
     * @type {boolean}
     * @memberof IStartStopResponse
     */
    success: boolean;
    /**
     * Response from z/OSMF to start rest call
     * @type {IZosmfTsoResponse}
     * @memberof IStartStopResponse
     */
    zosmfTsoResponse: IZosmfTsoResponse;
    /**
     * If an error occurs, returns the ImperativeError, which contains cause error.
     * @type {ImperativeError}
     * @memberof IStartStopResponse
     */
    failureResponse?: ImperativeError;
    /**
     * Servlet key from IZosmfTsoResponse
     * @type {string}
     * @memberof IStartStopResponse
     */
    servletKey: string;
}
