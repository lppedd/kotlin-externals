import { IPluginJsonObject } from "./IPluginJsonObject";
/**
 * Format of plugins.json file. Represents the list of installed plugins.
 */
export interface IPluginJson {
    /**
     * Each object key is the name of a plugin and the value is information about
     * said plugin.
     *
     * @type {IPluginJsonObject}
     */
    [key: string]: IPluginJsonObject;
}
