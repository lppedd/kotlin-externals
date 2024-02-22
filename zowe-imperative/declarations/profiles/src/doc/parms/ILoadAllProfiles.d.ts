/**
 * Optional parameters to profile manager load all profiles
 * @export
 * @interface ILoadAllProfiles
 */
export interface ILoadAllProfiles {
    /**
     * If true, do not load secure fields
     * @type {boolean}
     * @memberof ILoadAllProfiles
     */
    noSecure?: boolean;
    /**
     * If true, loads only the profiles of the current instance of the profile
     * managers "type" - specified when allocating the profile manager.
     * @type {boolean}
     * @memberof ILoadAllProfiles
     */
    typeOnly?: boolean;
}
