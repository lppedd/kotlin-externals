import { IConfigProfile } from "./IConfigProfile";
export interface IConfig {
    $schema?: string;
    defaults: {
        [key: string]: string;
    };
    profiles: {
        [key: string]: IConfigProfile;
    };
    autoStore?: boolean;
    plugins?: string[];
}
