import { IProfile } from "../definition/IProfile";
/**
 * Parameters to the "validate()" profile manager APIs. Validates a profile structure (basic and schema)
 * @export
 * @interface IValidateProfile
 */
export interface IValidateProfile {
    /**
     * The name of the profile to validate.
     * @type {string}
     * @memberof IValidateProfile
     */
    name: string;
    /**
     * The profile contents to validate.
     * @type {IProfile}
     * @memberof IValidateProfile
     */
    profile: IProfile;
    /**
     * Specify true to indicate the "ban unknown properties" specification of JSON schema. Meaning, any properties
     * found on the input profile that are NOT specified on the schema cause the validation to fail.
     * @type {boolean}
     * @memberof IValidateProfile
     */
    strict?: boolean;
}
