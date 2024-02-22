/**
 * Parameters for the setDefault Profile Manager API.
 * @export
 * @interface ISetDefaultProfile
 */
export interface ISetDefaultProfile {
    /**
     * The name of the profile to set as the default (the type is indicated by the profile manager object).
     * @type {string}
     * @memberof ISetDefaultProfile
     */
    name: string;
}
