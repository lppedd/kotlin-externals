import { ILoadProfile } from "../../../../../profiles";
/**
 * Profile Manager "loadProfile" input parameters. Indicates which profile to load (named or default) and if
 * not finding the profile should be considered and error, etc.
 * @export
 * @interface ICliLoadProfile
 * @extends ILoadProfile
 */
export interface ICliLoadProfile extends ILoadProfile {
}
