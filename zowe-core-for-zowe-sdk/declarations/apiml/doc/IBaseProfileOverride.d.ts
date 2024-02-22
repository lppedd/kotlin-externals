/**
 * As part of the auto-init output report, this structure
 * represents profile properties that override properties
 * defined in the base profile.
 */
export interface IBaseProfileOverride {
    propName: string;
    secure: boolean;
    priorityValue?: any;
    baseValue?: any;
}
