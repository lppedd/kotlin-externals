import { IBaseProfileOverride } from "..";
import { IAltProfile } from "./IAltProfile";
/**
 * As part of the auto-init output report, this structure
 * represents the set of profiles created or modified by
 * the auto-init command.
 */
export interface IProfileRpt {
    changeForProf: string;
    profName: string;
    profType: string;
    basePath: string;
    pluginNms: string[];
    altProfiles: IAltProfile[];
    baseOverrides: IBaseProfileOverride[];
}
