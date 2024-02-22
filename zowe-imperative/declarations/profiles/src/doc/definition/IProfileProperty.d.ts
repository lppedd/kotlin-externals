/**
 * A single field in a profile schema which can be serialized to a profile file
 */
export interface IProfileProperty {
    /**
     * See ICommandProfileProperty.ts for how to include option definitions
     * on your schema for auto-generated commands
     */
    type: string | string[];
    items?: any;
    /**
     * Nested properties e.g. banana.origin.zipcode, banana.origin.country
     */
    properties?: any;
    /**
     * Indicates if the given property should be securely stored
     */
    secure?: boolean;
    /**
     * Should this property be defined in a new config JSON template?
     * @type {boolean}
     * @memberof IProfileProperty
     */
    includeInTemplate?: boolean;
}
