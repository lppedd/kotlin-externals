import { AbstractSession } from "@zowe/imperative";
import { IStartTsoParms } from "./doc/input/IStartTsoParms";
import { IIssueResponse } from "./doc/IIssueResponse";
import { IIssueTsoParms } from "./doc/input/IIssueTsoParms";
/**
 * Class to handle issue command to TSO
 * @class IssueTso
 */
export declare class IssueTso {
    /**
     * API method to start a TSO address space, issue a command, collect responses until prompt is reached, and terminate the address space.
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} accountNumber - accounting info for Jobs
     * @param {string} command - command text to issue to the TSO address space.
     * @param {IStartTsoParms} startParams - optional object with required parameters for starting TSO address space, @see {IStartTsoParms}
     * @returns {Promise<IIssueResponse>} IssueTso response object, @see {IIssueResponse}
     * @memberof IssueTso
     */
    static issueTsoCommand(session: AbstractSession, accountNumber: string, command: string, startParams?: IStartTsoParms): Promise<IIssueResponse>;
    /**
     * API method to start a TSO address space with provided parameters, issue a command,
     * collect responses until prompt is reached, and terminate the address space.
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IIssueTsoParms} commandParms - object with required parameters, @see {IIssueTsoParms}
     * @returns {Promise<IIssueResponse>}
     */
    static issueTsoCommandCommon(session: AbstractSession, commandParms: IIssueTsoParms): Promise<IIssueResponse>;
}
