import { IPluginPeerDepends } from "./IPluginPeerDepends";
import { IImperativeConfig } from "../../doc/IImperativeConfig";
/**
 * A plugin's configuration properties.
 * All are obtained from the plugin's package.json.
 */
export interface IPluginCfgProps {
    pluginName: string;
    npmPackageName: string;
    impConfig: IImperativeConfig;
    cliDependency: IPluginPeerDepends;
    impDependency: IPluginPeerDepends;
}
