import { IProfLoc } from "./IProfLoc";
/**
 * The identifying attributes of a profile.
 */
export interface IProfAttrs {
    /** The name of the profile */
    profName: string;
    /** The profile type (eg. "zosmf") */
    profType: string;
    /** Indicates if this is the default profile for this type */
    isDefaultProfile: boolean;
    /**
     * Location of this profile.
     * profNmLoc.ProfLocType can never be ProfLocType.ENV or
     * ProfLocType.DEFAULT, because this is the location of a profile,
     * not an argument value.
     */
    profLoc: IProfLoc;
}
