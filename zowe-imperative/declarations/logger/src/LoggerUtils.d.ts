import { Arguments } from "yargs";
import { ICommandProfileTypeConfiguration } from "../../cmd/src/doc/profiles/definition/ICommandProfileTypeConfiguration";
import { IProfileSchema } from "../../profiles/src/doc/definition/IProfileSchema";
export declare class LoggerUtils {
    static readonly CENSOR_RESPONSE = "****";
    /**
     * NOTE(Kelosky): Ideally we might have a consolidated list for secure fields, but for now we'll just
     * make sure they're collocated within the same class.
     */
    static CENSORED_OPTIONS: string[];
    static SECURE_PROMPT_OPTIONS: string[];
    /**
     * Copy and censor any sensitive CLI arguments before logging/printing
     * @param {string[]} args
     * @returns {string[]}
     */
    static censorCLIArgs(args: string[]): string[];
    /**
     * Copy and censor a yargs argument object before logging
     * @param {yargs.Arguments} args the args to censor
     * @returns {yargs.Arguments}  a censored copy of the arguments
     */
    static censorYargsArguments(args: Arguments): Arguments;
    /**
     * Singleton implementation of an internal reference of ImperativeConfig.instance.config
     */
    private static mConfig;
    private static get config();
    /**
     * Singleton implementation of an internal reference to the active layer
     * This should help with performance since one a single copy will be created for censoring data
     */
    private static mLayer;
    private static get layer();
    /**
     * Singleton implementation of an internal reference to the secure fields stored in the config
     */
    private static mSecureFields;
    private static get secureFields();
    /**
     * Singleton implementation of an internal reference to the loaded profiles
     */
    private static mProfiles;
    static get profileSchemas(): ICommandProfileTypeConfiguration[];
    static setProfileSchemas(_schemas: Map<string, IProfileSchema>): void;
    /**
     * Specifies whether a given property path (e.g. "profiles.lpar1.properties.host") is a special value or not.
     * Special value: Refers to any value defined as secure in the schema definition.
     *                These values should be already masked by the application (and/or plugin) developer.
     * @param prop Property path to determine if it is a special value
     * @returns True - if the given property is to be treated as a special value; False - otherwise
     */
    static isSpecialValue: (prop: string) => boolean;
    /**
     * Copy and censor any sensitive CLI arguments before logging/printing
     * @param {string} data
     * @returns {string}
     */
    static censorRawData(data: string, category?: string): string;
}
