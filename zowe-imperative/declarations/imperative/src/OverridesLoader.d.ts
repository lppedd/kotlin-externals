import { IImperativeConfig } from "./doc/IImperativeConfig";
/**
 * Imperative-internal class to load overrides
 * You should not need to call this from your CLI.
 */
export declare class OverridesLoader {
    private static readonly ZOWE_CLI_PACKAGE_NAME;
    /**
     * Apply overrides to all applicable facilities and use our defaults where
     * an override is not provided.
     *
     * @param {IImperativeConfig} config - the current {@link Imperative#loadedConfig}
     * @param {any} packageJson - the current package.json
     */
    static load(config: IImperativeConfig, packageJson: any): Promise<void>;
    /**
     * Ensure the Credential Manager is initialized for team config.
     */
    static ensureCredentialManagerLoaded(): Promise<void>;
    /**
     * Initialize the Credential Manager using the supplied override when provided.
     *
     * @param {IImperativeConfig} config - the current {@link Imperative#loadedConfig}
     * @param {any} packageJson - the current package.json
     * @param {boolean} useTeamConfig - specify True if team config is active
     */
    private static loadCredentialManager;
    /**
     * Check if the DefaultCredentialManager which uses keytar should be enabled.
     * We require that keytar is listed as a dependency in package.json, and one of the following is true:
     *  1. AppSettings are not initialized (SDK usage)
     *  2. Team config is active (CLI with v2 profiles)
     *  3. CredentialManager override is host package name (CLI with v1 profiles)
     * @param packageJson The current package.json of the CLI package
     * @param useTeamConfig Specify True if team config is active
     * @returns True if DefaultCredentialManager should be used
     */
    private static shouldUseKeytar;
    /**
     * After the plugins and secure credentials are loaded, rebuild the configuration with the
     * secure values
     */
    private static loadSecureConfig;
}
