export declare class RestStandAloneUtils {
    /**
     * Obtain user name from a base 64 credential
     * @param {string} auth - base 64 encoded credentials
     * @returns {string} - user name
     */
    static getUsernameFromAuth(auth: string): string;
    /**
     * Obtain password from a base 64 credential
     * @param {string} auth - base 64 encoded credentials
     * @returns {string} - password
     */
    static getPasswordFromAuth(auth: string): string;
    private static readonly BASIC;
}
