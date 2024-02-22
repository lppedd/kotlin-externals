import { IImperativeConfig } from "./doc/IImperativeConfig";
/**
 * Imperative-internal class to validate configuration
 * You should not need to call this from your CLI.
 */
export declare class ConfigurationValidator {
    /**
     * Validate a configuration object that has already been completely loaded from
     * the consumer of Imperative.
     * @throws errors if the configuration is not valid
     * @param {IImperativeConfig} config
     */
    static validate(config: IImperativeConfig): void;
    /**
     * Private utility to validate a consumer's chalk color setting
     * @param config - the config object  from the consumer
     * @param {string} colorProperty - the property of the config object
     * @param {string} colorPropertyDescriptiveName - the display name of the color you're validating
     */
    private static verifyChalkColor;
}
