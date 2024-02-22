import { AbstractSession } from "@zowe/imperative";
/**
 * Class to handle logging out of APIML.
 * @export
 * @class Logout
 */
export declare class Logout {
    /**
     * Perform APIML logout to invalidate LTPA2 or other token types.
     * @static
     * @param session
     * @return
     * @memberof Logout
     */
    static apimlLogout(session: AbstractSession): Promise<void>;
}
