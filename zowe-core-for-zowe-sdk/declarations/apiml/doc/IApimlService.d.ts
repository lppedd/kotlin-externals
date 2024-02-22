import { IApimlServiceApiInfo } from "./IApimlServiceApiInfo";
import { IApimlServiceAuthentication } from "./IApimlServiceAuthentication";
export interface IApimlService {
    serviceId: string;
    status: "DOWN" | "UP";
    apiml: {
        apiInfo: IApimlServiceApiInfo[];
        service: {
            title: string;
            description: string;
            homePageUrl: string;
        };
        authentication: IApimlServiceAuthentication[];
    };
    instances: {
        [key: string]: any;
    }[];
}
