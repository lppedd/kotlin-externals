import { AbstractSession } from "@zowe/imperative";
import { IStartStopResponses } from "./doc/IStartStopResponses";
import { IStartTsoParms } from "./doc/input/IStartTsoParms";
import { IZosmfTsoResponse } from "./doc/zosmf/IZosmfTsoResponse";
/**
 * Start TSO address space and receive servlet key
 * @export
 * @class StartTso
 */
export declare class StartTso {
    /**
     * Start TSO address space with provided  parameters
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IStartTsoParms} commandParms - object with required parameters, @see {IStartTsoParms}
     * @returns {Promise<IZosmfTsoResponse>} z/OSMF response object, @see {IZosmfTsoResponse}
     * @memberof StartTso
     */
    static startCommon(session: AbstractSession, commandParms: IStartTsoParms): Promise<IZosmfTsoResponse>;
    /**
     * Start TSO address space with provided parameters.
     * @static
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string}  accountNumber - this key of IStartTsoParms required, because it cannot be default.
     * @param {IStartTsoParms} parms - optional object with required parameters, @see {IStartTsoParms}
     * @returns {Promise<IStartStopResponses>} command response on resolve, @see {IStartStopResponses}
     * @memberof StartTso
     */
    static start(session: AbstractSession, accountNumber: string, parms?: IStartTsoParms): Promise<IStartStopResponses>;
    /**
     * Sets required parameters by default if not provided. If some parameters provided
     * it uses received and the rest required parameters will be default
     * @static
     * @param {IStartTsoParms} parms - object with required parameters, @see {IStartTsoParms}
     * @param {string} accountNumber - this key of IStartTsoParms required, because it cannot be default.
     * @returns {IStartTsoParms} object with provided parameters if not the with default
     * @memberof StartTso
     */
    static setDefaultAddressSpaceParams(parms: IStartTsoParms, accountNumber: string): IStartTsoParms;
    /**
     * Builds a resources query from passed parameters which is needed for z/OSMF api URI.
     * @param {IStartTsoParms} parms - object with required parameters, @see {IStartTsoParms}
     * @returns {string} URI for z/OSMF REST call
     * @memberof StartTso
     */
    static getResourcesQuery(parms: IStartTsoParms): string;
}
