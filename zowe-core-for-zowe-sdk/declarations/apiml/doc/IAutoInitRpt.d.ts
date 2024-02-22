import { IConfigLayer } from "@zowe/imperative";
import { IProfileRpt } from "./IProfileRpt";
/**
 * This structure is used to form the auto-init output report.
 */
export interface IAutoInitRpt {
    configFileNm: string;
    changeForConfig: string;
    startingConfig: IConfigLayer;
    endingConfig: IConfigLayer;
    profileRpts: IProfileRpt[];
}
