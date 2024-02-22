import { IConfig } from "./IConfig";
export interface IConfigConvertResult {
    config: IConfig;
    profilesConverted: {
        [key: string]: string[];
    };
    profilesFailed: {
        name?: string;
        type: string;
        error: Error;
    }[];
}
