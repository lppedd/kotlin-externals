import { ICommandProfileProperty } from "./ICommandProfileProperty";
import { IProfileSchema } from "../../../../../profiles";
/**
 * Externally exposed version of the profile schema with command options for auto-generated commands
 * @export
 * @interface ICommandProfileSchema
 * @extends {IProfileSchema}
 */
export interface ICommandProfileSchema extends IProfileSchema {
    /**
     * Command version of the properties field on the schema
     */
    properties: {
        /**
         * General mapping of property name to an ICommandProfileProperty object.
         * ICommandProfileProperty is the same as IProfileProperty except
         * that it can contain option definitions for auto-generated commands
         */
        [key: string]: ICommandProfileProperty;
    };
}
