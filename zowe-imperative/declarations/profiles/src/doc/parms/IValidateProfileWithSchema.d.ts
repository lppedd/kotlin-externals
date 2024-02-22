import { IProfileSchema } from "../definition/IProfileSchema";
import { IValidateProfile } from "./IValidateProfile";
/**
 * Input to the "validateProfile" internal API. Indicates the schema document to be used for the validation.
 * @export
 * @interface IValidateProfileWithSchema
 * @extends {IValidateProfile}
 */
export interface IValidateProfileWithSchema extends IValidateProfile {
    /**
     * The profile JSON schema document.
     * @type {IProfileSchema}
     * @memberof IValidateProfileWithSchema
     */
    schema: IProfileSchema;
}
