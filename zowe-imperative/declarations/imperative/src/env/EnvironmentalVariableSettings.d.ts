import { IImperativeEnvironmentalVariableSettings } from "../doc/IImperativeEnvironmentalVariableSettings";
/**
 * Service for reading environmental variable settings
 * exposed for CLIs built on Imperative CLI framework
 * @export
 * @class EnvironmentalVariableSettings
 */
export declare class EnvironmentalVariableSettings {
    /**
     * The end of the environmental variable for configuring the log level for the imperative logger of your CLI
     * The prefix will be added to the beginning of this value to construct the full key
     * @type {string}
     * @memberof EnvironmentalVariableSettings
     */
    static readonly IMPERATIVE_LOG_LEVEL_KEY_SUFFIX = "_IMPERATIVE_LOG_LEVEL";
    /**
     * The end of the environmental variable for configuring the log level for the appLogger of your CLI
     * The prefix will be added to the beginning of this value to construct the full key
     * @type {string}
     * @memberof EnvironmentalVariableSettings
     */
    static readonly APP_LOG_LEVEL_KEY_SUFFIX = "_APP_LOG_LEVEL";
    /**
     * The end of the environmental variable for configuring the ability to mask output of your CLI
     * The prefix will be added to the beginning of this value to construct the full key
     * @type {string}
     * @memberof EnvironmentalVariableSettings
     */
    static readonly APP_MASK_OUTPUT_SUFFIX = "_APP_MASK_OUTPUT";
    /**
     * The end of the environmental variable for configuring the home directory for your CLI
     * The prefix will be added to the beginning of this value to construct the full key
     * @type {string}
     * @memberof EnvironmentalVariableSettings
     */
    static readonly CLI_HOME_SUFFIX = "_CLI_HOME";
    /**
     * The end of the environmental variable for configuring the prompt phrase for your CLI
     * The prefix will be added to the beginning of this value to construct the full key
     * @type {string}
     * @memberof EnvironmentalVariableSettings
     */
    static readonly PROMPT_PHRASE_SUFFIX = "_PROMPT_PHRASE";
    /**
     * The end of the environmental variable for configuring the plugins directory for your CLI
     * The prefix will be added to the beginning of this value to contruct the full key
     * @type {string}
     * @memberof EnvironmentalVariableSettings
     */
    static readonly CLI_PLUGINS_DIR_SUFFIX = "_CLI_PLUGINS_DIR";
    /**
     * Read all environmental variable settings for a CLI
     * @param {string} prefix - the environmental variables for a CLI will begin with this prefix e.g. "SAMPLE_CLI".
     *                          by default, this should be the same as the Imperative.loadedConfig.name field
     *                          unless you specify envVariablePrefix on your Imperative configuration
     * @returns {IImperativeEnvironmentalVariableSettings} - object populated with the settings specified by the user
     * @memberof EnvironmentalVariableSettings
     */
    static read(prefix: string): IImperativeEnvironmentalVariableSettings;
}
