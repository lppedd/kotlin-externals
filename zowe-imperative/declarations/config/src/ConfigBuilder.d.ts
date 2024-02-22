import { IImperativeConfig } from "../../imperative";
import { IConfig } from "./doc/IConfig";
import { IConfigBuilderOpts } from "./doc/IConfigBuilderOpts";
import { IConfigConvertResult } from "./doc/IConfigConvertResult";
import { ICommandProfileTypeConfiguration } from "../../cmd";
export declare class ConfigBuilder {
    /**
     * Build a new Config object from an Imperative CLI app configuration.
     * @param impConfig The Imperative CLI app configuration.
     * @param opts Options to control aspects of the builder.
     */
    static build(impConfig: IImperativeConfig, opts?: IConfigBuilderOpts): Promise<IConfig>;
    static buildDefaultProfile(profile: ICommandProfileTypeConfiguration, opts?: IConfigBuilderOpts): {
        type: string;
        properties: Record<string, any>;
        secure: string[];
    };
    /**
     * Convert existing v1 profiles to a Config object and report any conversion failures.
     * @param profilesRootDir Root directory where v1 profiles are stored.
     * @returns Results object including new config and error details for profiles that failed to convert.
     */
    static convert(profilesRootDir: string): Promise<IConfigConvertResult>;
    /**
     * Convert a set of known property names that have been renamed for
     * V2 conformance to their new names.
     *
     * @param conversionResult The conversion result structure in which we shall
     *      rename obsolete property names to their V2-compliant names.
     */
    private static convertPropNames;
    /**
     * Returns empty value that is appropriate for the property type.
     * @param propType The type of profile property
     * @returns Null or empty object
     */
    private static getDefaultValue;
}
