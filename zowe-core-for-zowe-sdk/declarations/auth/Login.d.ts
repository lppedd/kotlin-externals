import { AbstractSession } from "@zowe/imperative";
/**
 * Class to handle logging onto APIML.
 * @export
 * @class Login
 */
export declare class Login {
    /**
     * Perform APIML login to obtain LTPA2 or other token types.
     * @static
     * @param {AbstractSession} session
     * @returns
     * @memberof Login
     */
    static apimlLogin(session: AbstractSession): Promise<string>;
}
