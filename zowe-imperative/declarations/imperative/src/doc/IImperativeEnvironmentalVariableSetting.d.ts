/**
 * Interface representing a single setting
 */
export interface IImperativeEnvironmentalVariableSetting {
    /**
     * The key to the process.env object
     * AKA. the environmental variable name
     * e.g. MYCLI_APP_LOG_LEVEL
     * @type {string}
     */
    key: string;
    /**
     * The value specified by the user for this variable, if any
     * e.g. "DEBUG"
     * @type {string}
     */
    value: string;
}
