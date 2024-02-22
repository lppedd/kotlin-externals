import { IProfileTypeConfiguration } from "../../profiles";
import { IConfigSchema, IConfigUpdateSchemaOptions, IConfigUpdateSchemaPaths } from "./doc/IConfigSchema";
import { IConfig } from "./doc/IConfig";
export declare class ConfigSchema {
    /**
     * JSON schema URI stored in $schema property of the schema
     * @readonly
     * @memberof ConfigSchema
     */
    private static readonly JSON_SCHEMA;
    /**
     * Version number stored in $version property of the schema
     * @readonly
     * @memberof ConfigSchema
     */
    private static readonly SCHEMA_VERSION;
    /**
     * Pretty explanation of the schema objects
     * @readonly
     * @memberof ConfigSchema
     */
    private static readonly explainSchemaSummary;
    /**
     * Transform an Imperative profile schema to a JSON schema. Removes any
     * non-JSON-schema properties and translates anything useful.
     * @param schema The Imperative profile schema
     * @returns JSON schema for profile properties
     */
    private static generateSchema;
    /**
     * HELPER function for updating the active layer's schema files
     * This operation is divided in 2 steps:
     * 1. Update the schema file corresponding to the active layer
     * 2. Update the opposite (user/non-user) layer if it exists
     *
     * @param opts The various properties needed to accomplish a recursive UpdateSchema operation
     * @param forceSetSchema Indicates if we should force the creation of the schema file even if the config doesn't exist (e.g. config init)
     * @param checkContrastingLayer Indicates if we should check for the opposite (user/non-user) layer
     * @returns Object containing the updated schema paths
     */
    private static _updateSchemaActive;
    /**
     * HELPER function for updating global schema files
     * This operation is divided in 2 steps:
     * 1. Activate the global layer
     * 2. Call the Active helper
     *
     * @param opts The various properties needed to accomplish a recursive UpdateSchema operation
     * @returns Object containing the updated schema paths
     */
    private static _updateSchemaGlobal;
    /**
     * HELPER function for recursively updating schema files
     * This operation is divided in 3 steps:
     * 1. Traverse UP the directory structure while updating the corresponding schema files
     * 2. Update both (User and Non-User) Global configuration's schema files
     * 3. Traverse DOWN the directory structure based on the depth specified
     *
     * @param opts The various properties needed to accomplish a recursive UpdateSchema operation
     * @returns Object containing the updated schema paths
     */
    private static _updateSchemaAll;
    /**
     * Dynamically builds the config schema for this CLI.
     * @param profiles The profiles supported by this CLI
     * @returns JSON schema for all supported profile types
     */
    static buildSchema(profiles: IProfileTypeConfiguration[]): IConfigSchema;
    /**
     * Loads Imperative profile schema objects from a schema JSON file.
     * @param schema The schema JSON for config
     */
    static loadSchema(schema: IConfigSchema): IProfileTypeConfiguration[];
    /**
     * Updates Imperative Config Schema objects from a schema JSON file.
     * @param options        The options object
     * @param options.layer  The layer in which we should update the schema file(s). Defaults to the active layer.
     * @param options.schema The optional schema object to use. If not provided, we build the schema object based on loadedConfig.profiles
     * @returns List of updated paths with the new/loaded or given schema
     */
    static updateSchema(options?: IConfigUpdateSchemaOptions): IConfigUpdateSchemaPaths;
    /**
     * Find the type of a property based on schema info.
     * @param path Path to JSON property in config JSON
     * @param config Team config properties
     * @param schema Config schema definition. Defaults to profile schemas defined in Imperative config.
     */
    static findPropertyType(path: string, config: IConfig, schema?: IConfigSchema): string | undefined;
}
