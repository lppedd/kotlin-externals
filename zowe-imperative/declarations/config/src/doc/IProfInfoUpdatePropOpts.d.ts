import { IProfArgValue } from "./IProfArgAttrs";
import { IProfLocOsLoc } from "./IProfLoc";
import { IProfMergedArg } from "./IProfMergedArg";
/**
 * Required options to update any property from the ProfileInfo class.
 */
export interface IProfInfoUpdatePropOpts extends IProfInfoUpdatePropCommonOpts {
    /**
     * Type of the active profile
     */
    profileType: string;
    /**
     * Name of the active profile
     */
    profileName: string;
    /**
     * Force the update to the profile specified even if the property comes from somehwere else
     * @example Token Value could be in the base profile (not in the service profile specified)
     *          and the programmer has the intention of storing the token in the service profile
     * @default false When the property is not specified, the updateProperty method follows current
     *          procedure of updating the property in the known jsonLoc (e.g. base profile). Otherwise,
     *          the updateProperty method updates the specified profile name-type combination.
     */
    forceUpdate?: boolean;
}
/**
 * Required options to update known properties from the ProfileInfo class.
 */
export interface IProfInfoUpdateKnownPropOpts extends IProfInfoUpdatePropCommonOpts {
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
export interface IProfInfoUpdatePropCommonOpts {
    /**
     * Property to update
     */
    property: string;
    /**
     * Value to use when updating the given property
     */
    value: IProfArgValue | undefined;
    /**
     * Specifies if the property should be stored securely or not
     */
    setSecure?: boolean;
}
