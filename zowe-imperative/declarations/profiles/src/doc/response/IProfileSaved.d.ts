import { IProfile } from "../definition/IProfile";
/**
 * The success response to the profile "save()" API.
 * @export
 * @interface IProfileSaved
 */
export interface IProfileSaved {
    /**
     * The path that the new profile was written to
     * @type {string}
     * @memberof IProfileSaved
     */
    path: string;
    /**
     * A message describing the result of the profile creation - for display purposes
     * @type {string}
     * @memberof IProfileSaved
     */
    message: string;
    /**
     * True if the profile saved overwrote an existing profile of the same name/type.
     *
     * @type {boolean}
     * @memberof IProfileSaved
     */
    overwritten: boolean;
    /**
     * The contents of the profile saved.
     * @type {IProfile}
     * @memberof IProfileSaved
     */
    profile?: IProfile;
}
