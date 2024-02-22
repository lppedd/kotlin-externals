import { IImperativeOverrides } from "../../../imperative/src/doc/IImperativeOverrides";
/**
 * This interface defines the structure of the settings file.
 */
export interface ISettingsFile {
    /**
     * The overrides object determines which items will be used for any overrides in
     * the overrides loader. Overrides can come from the base cli or plugins.
     */
    overrides: {
        [K in keyof IImperativeOverrides]-?: false | string;
    };
}
