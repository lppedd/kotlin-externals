import { Logger } from "../../../logger";
/**
 * Imperative Standard Error - All Imperative services/utils must thrown an Imperative Error (not a generic Error).
 * The Imperative Error collects additional diagnostics and most (if not all) Imperative Promises
 * @export
 * @interface IImperativeErrorParms
 */
export interface IImperativeErrorParms {
    /**
     * Logger for the Imperative Error (logs messages and the node report that is generated upon request)
     * @type {Logger}
     * @memberof IImperativeErrorParms
     */
    logger?: Logger;
    /**
     * Message tag - prepended to the error message specified. Useful for categorizing error messages
     * (e.g. "Profile IO Error"). A ": " is appended automatically (e.g. "Profile IO Error: ")
     * @type {string}
     * @memberof IImperativeErrorParms
     */
    tag?: string;
}
