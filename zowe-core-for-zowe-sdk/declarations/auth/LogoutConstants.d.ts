/**
 * Class for various logout constants.
 * @export
 * @class LogoutConstants
 */
export declare class LogoutConstants {
    /**
     * URI base jobs API
     * @static
     * @type {string}
     * @memberof LogoutConstants
     */
    static readonly APIML_V1_RESOURCE: string;
    /**
     * Zowe Token Expired Error Code
     * @static
     * @type {string}
     * @memberof LogoutConstants
     */
    static readonly APIML_V1_TOKEN_EXP_ERR: string;
    /**
     * Zowe Token Expired Error Codes
     * @static
     * @type {string}
     * @memberof LogoutConstants
     */
    static readonly APIML_V2_LOGOUT_ERR_LIST: {
        [key: string]: string;
    };
}
