import { IProfile } from "../definition/IProfile";
/**
 * The success response to the profile "update()" API.
 * @export
 * @interface IProfileUpdated
 */
export interface IProfileUpdated {
    /**
     * The path to the profile that was updated
     */
    path: string;
    /**
     * A message for display purposes
     */
    message: string;
    /**
     * The contents of the profile
     */
    profile?: IProfile;
}
