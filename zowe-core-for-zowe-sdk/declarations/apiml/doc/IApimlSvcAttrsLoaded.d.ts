import { IApimlSvcAttrs } from "@zowe/imperative";
/**
 * Once getPluginApimlConfigs() has processed the loaded ImperativeConfig,
 * and plugin properties, it returns an array of these structures.
 */
export interface IApimlSvcAttrsLoaded extends IApimlSvcAttrs {
    /**
     * Once getPluginApimlConfigs() has processed the loaded ImperativeConfig,
     * the connProfType will be a required property in the resulting object.
     */
    connProfType: string;
    /**
     * The plugin name from which these attributes were retrieved.
     * If retrieved from the core CLI, then the CLI name is used.
     */
    pluginName: string;
}
