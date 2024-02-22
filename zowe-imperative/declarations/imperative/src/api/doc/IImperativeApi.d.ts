import { Logger } from "../../../../logger";
export interface IImperativeApi {
    "imperativeLogger": Logger;
    "appLogger": Logger;
    [keys: string]: any;
}
