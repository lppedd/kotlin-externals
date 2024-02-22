/**
 * Imperative constants
 * @export
 * @class Constants
 */
export declare class Constants {
    static readonly FRAMEWORK_DISPLAY_NAME: string;
    static readonly IMPERATIVE_DEFAULT_HOME: string;
    static readonly IMPERATIVE_DIRECTORY: string;
    static readonly ERROR_EXIT_CODE: number;
    static readonly PRIMARY_COMMAND: string;
    static readonly PROFILES_DIR: string;
    /**
     * Syntax diagram
     */
    static readonly COMMAND_SEGMENT: string;
    static readonly GROUP_SEGMENT: string;
    static readonly OPTIONS_SEGMENT: string;
    /**
     * Explanation of experimental features to be used in various places around the CLI
     * @type {string}
     */
    static readonly DEFAULT_EXPERIMENTAL_COMMAND_EXPLANATION: string;
    /**
     * Segments
     */
    static readonly PRIMARY_SEGMENT_NUMBER: number;
    static readonly GROUP_SEGMENT_NUMBER: number;
    static readonly DEFAULT_SET_PROFILE_OBJECT = "default-profiles";
    static readonly DEFAULT_SET_PROFILE_OBJECT_ALIAS = "dbp";
    static readonly DEFAULT_SET_GROUP = "set";
    static readonly DEFAULT_LIST_PROFILE_OBJECT = "loaded-profiles";
    static readonly DEFAULT_LIST_PROFILE_OBJECT_ALIAS = "lbp";
    static readonly DEFAULT_LIST_GROUP = "list";
    static GLOBAL_GROUP: string;
    static readonly JSON_OPTION = "response-format-json";
    static readonly JSON_OPTION_ALIAS = "rfj";
    static readonly HELP_OPTION = "help";
    static readonly HELP_OPTION_ALIAS = "h";
    static readonly HELP_EXAMPLES = "help-examples";
    static readonly HELP_WEB_OPTION = "help-web";
    static readonly HELP_WEB_OPTION_ALIAS = "hw";
    static readonly STDIN_OPTION = "stdin";
    static readonly STDIN_OPTION_ALIAS = "pipe";
    static readonly STDIN_DEFAULT_DESCRIPTION = "Pipe data into this command via stdin";
    static readonly OPT_LONG_DASH = "--";
    static readonly OPT_SHORT_DASH = "-";
    /**
     * If you use the stdin option, you will be able to access the contents buffer
     * through this key on your Arguments object in your command
     * @type {string}
     */
    static readonly STDIN_CONTENT_KEY: string;
    /**
     * Create profile constants
     */
    static readonly CREATE_ACTION = "create";
    static readonly PROFILE_GROUP = "profiles";
    static readonly PROFILE_OBJECT = "profile";
    static readonly PROFILE_ALIASES: string[];
    static readonly PROFILE_NAME_OPTION = "profileName";
    static readonly PROFILE_NAME_OPTION_ALIAS = "pn";
    static readonly OVERWRITE_OPTION = "overwrite";
    static readonly DISABLE_DEFAULTS_OPTION = "disable-defaults";
    static readonly DELETE_ACTION = "delete";
    static readonly DETAILS_ACTION = "detail";
    static readonly SHOW_DEPS_ACTION = "show-dependencies";
    static readonly VALIDATE_ACTION = "validate";
    static readonly UPDATE_ACTION = "update";
    static readonly LIST_ACTION = "list";
    static readonly PROFILE_SET_OPTION_ALIAS = "{{typeLetter}}n";
    static readonly SET_ACTION = "set-default";
    static readonly PROFILE_DELETE_PROFILE_DEPS = "delete-dependent-profiles";
    static readonly PROFILE_DELETE_PROFILE_DEPS_ALIAS = "ddp";
    static readonly DEFAULT_HIGHLIGHT_COLOR = "yellow";
    static readonly DEFAULT_PROMPT_PHRASE = "PROMPT*";
    static readonly DEFAULT_MASK_OUTPUT = "TRUE";
    static readonly WEB_HELP_DIR = "web-help";
    static readonly WEB_DIFF_DIR = "web-diff";
    /**
     * Auth group constants
     */
    static readonly AUTH_GROUP = "auth";
    static readonly LOGIN_ACTION = "login";
    static readonly LOGIN_ACTION_ALIAS = "li";
    static readonly LOGOUT_ACTION = "logout";
    static readonly LOGOUT_ACTION_ALIAS = "lo";
    /**
     * Auto Init constants
     */
    static readonly AUTO_INIT_ACTION = "auto-init";
    /**
     * ICommandProfileTypeConfiguration properties
     * (used to omit from schemas registered via ProfileInfo)
     */
    static readonly COMMAND_PROF_TYPE_PROPS: string[];
}
