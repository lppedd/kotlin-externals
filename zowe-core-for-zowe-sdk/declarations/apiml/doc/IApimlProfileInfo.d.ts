import { IApimlSvcAttrsLoaded } from "./IApimlSvcAttrsLoaded";
export interface IApimlProfileInfo {
    profName: string;
    profType: string;
    basePaths: string[];
    pluginConfigs: Set<IApimlSvcAttrsLoaded>;
    gatewayUrlConflicts: {
        [pluginName: string]: string[];
    };
}
