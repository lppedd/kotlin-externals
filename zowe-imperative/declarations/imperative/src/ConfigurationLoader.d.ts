/**
 * Imperative-internal class to load configuration
 * You should not need to call this from your CLI.
 */
import { IImperativeConfig } from "./doc/IImperativeConfig";
export declare class ConfigurationLoader {
    /**
     *
     * @param {IImperativeConfig} providedConfig - the configuration provided through the "init"
     *                             Imperative API. Pass undefined if no config specified
     * @param packageJson - caller's full package.json contents as an object. Used if
     *                             providedConfig is undefined.
     * @param callerFileRequirer - function that, when provided a string,
     *                             returns the require()d contents of a file relative
     *                             to where the caller initialized from
     * @returns {IImperativeConfig}
     */
    static load(providedConfig: IImperativeConfig, packageJson: any, callerFileRequirer: (file: string) => any): IImperativeConfig;
}
