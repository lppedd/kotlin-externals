import { IConfig } from "./IConfig";
export interface IConfigLayer {
    path: string;
    exists: boolean;
    properties: IConfig;
    global: boolean;
    user: boolean;
}
