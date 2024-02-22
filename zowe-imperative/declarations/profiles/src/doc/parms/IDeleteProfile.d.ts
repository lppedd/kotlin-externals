/**
 * Parameters to the profile manager "delete" API.
 * @export
 * @interface IDeleteProfile
 */
export interface IDeleteProfile {
    /**
     * The name of the profile to delete - the type is specified by the current manager object.
     * @type {string}
     * @memberof IDeleteProfile
     */
    name: string;
    /**
     * If true, rejects the deletion of the profile if it is found to be a dependency of another profile.
     * @type {boolean}
     * @memberof IDeleteProfile
     */
    rejectIfDependency?: boolean;
}
