/**
 * Constants related to team configuration
 */
export declare class ConfigConstants {
    /**
     * Number of spaces used for indentation in config JSONC files
     */
    static readonly INDENT: number;
    /**
     * A string used to hide the display of secure values
     */
    static readonly SECURE_VALUE = "(secure value)";
    /**
     * ID used for storing secure credentials in vault
     */
    static readonly SECURE_ACCT = "secure_config_props";
    /**
     * ID used for storing secure credentials in vault
     */
    static readonly SKIP_PROMPT = "- Press ENTER to skip: ";
}
