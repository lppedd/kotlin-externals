/**
 * This class contains logic to enable users to opt-in to features
 * that will become standard functionality in the next version of Zowe.
 * @export
 * @class NextVerFeatures
 */
export declare class NextVerFeatures {
    private static ENV_VAR_PREFIX;
    /**
     * Identify if we should use the V3 error message format.
     * That choice is determined by the value of the ZOWE_V3_ERR_FORMAT environment variable.
     *
     * TODO:V3_ERR_FORMAT - Remove in V3
     *
     * @returns {boolean} True -> Use the V3 format.
     */
    static useV3ErrFormat(): boolean;
}
