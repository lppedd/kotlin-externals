import { IProfile } from "../definition/IProfile";
/**
 * Parameters to update a profile - The basic implementation simply overwrites the existing profile with the new
 * contents specified, unless merge is true, and the contents of the old profile are merged with the contents from
 * the update profile.
 *
 * Note: This profile could contains the following additional arguments,
 *       which will only be kept in memory (for a short period of time) and NOT saved to a file.
 *   @type {string} username - The username to be securely saved to this profile.
 *   @type {string} password - The password for the username to be securely saved to this profile.
 *
 * @export
 * @interface IUpdateProfile
 */
export interface IUpdateProfile {
    /**
     * The name of the profile to update.
     * @type {string}
     * @memberof IUpdateProfile
     */
    name?: string;
    /**
     * Should the contents of the new profile be merged with the contents of the old one?
     * @type {boolean}
     */
    merge?: boolean;
    /**
     * The contents of the profile for the update - if merge is NOT specified, simply overwrites the existing
     * profile with the contents specified here.
     * @type {IProfile}
     * @memberof IUpdateProfile
     */
    profile?: IProfile;
}
