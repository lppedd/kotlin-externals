import { IProfLocOsLoc } from "./IProfLoc";
import { IProfMergedArg } from "./IProfMergedArg";
export interface IProfInfoRemoveKnownPropOpts extends IProfInfoRemoveKnownPropCommonOpts {
    /**
     * Merged arguments object describing the location of the property to update
     */
    mergedArgs: IProfMergedArg;
    /**
     * Optional osLoc information.
     * This will allow the updateKnownProperty function to switch active layer if needed
     */
    osLocInfo?: IProfLocOsLoc;
}
export interface IProfInfoRemoveKnownPropCommonOpts {
    /**
     * Property to remove
     */
    property: string;
}
