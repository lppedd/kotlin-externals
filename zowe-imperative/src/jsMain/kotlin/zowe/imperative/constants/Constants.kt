@file:JsModule("@zowe/imperative")

package zowe.imperative.constants

/**
 * Imperative constants
 */
external class Constants {
  companion object {
    val FRAMEWORK_DISPLAY_NAME: String
    val IMPERATIVE_DEFAULT_HOME: String
    val IMPERATIVE_DIRECTORY: String
    val ERROR_EXIT_CODE: Int
    val PRIMARY_COMMAND: String
    val PROFILES_DIR: String

    /** Syntax diagram */
    val COMMAND_SEGMENT: String
    val GROUP_SEGMENT: String
    val OPTIONS_SEGMENT: String

    /**
     * Explanation of experimental features to be used in various places around the CLI
     */
    val DEFAULT_EXPERIMENTAL_COMMAND_EXPLANATION: String

    /** Segments */
    val PRIMARY_SEGMENT_NUMBER: Int
    val GROUP_SEGMENT_NUMBER: Int

    @JsString("default-profiles")
    val DEFAULT_SET_PROFILE_OBJECT: String

    @JsString("dbp")
    val DEFAULT_SET_PROFILE_OBJECT_ALIAS: String

    @JsString("set")
    val DEFAULT_SET_GROUP: String

    @JsString("loaded-profiles")
    val DEFAULT_LIST_PROFILE_OBJECT: String

    @JsString("lbp")
    val DEFAULT_LIST_PROFILE_OBJECT_ALIAS: String

    @JsString("list")
    val DEFAULT_LIST_GROUP: String

    var GLOBAL_GROUP: String

    @JsString("response-format-json")
    val JSON_OPTION: String

    @JsString("rfj")
    val JSON_OPTION_ALIAS: String

    @JsString("help")
    val HELP_OPTION: String

    @JsString("h")
    val HELP_OPTION_ALIAS: String

    @JsString("help-examples")
    val HELP_EXAMPLES: String

    @JsString("help-web")
    val HELP_WEB_OPTION: String

    @JsString("hw")
    val HELP_WEB_OPTION_ALIAS: String

    @JsString("stdin")
    val STDIN_OPTION: String

    @JsString("pipe")
    val STDIN_OPTION_ALIAS: String

    @JsString("Pipe data into this command via stdin")
    val STDIN_DEFAULT_DESCRIPTION: String

    @JsString("--")
    val OPT_LONG_DASH: String

    @JsString("-")
    val OPT_SHORT_DASH: String

    /**
     * If you use the stdin option, you will be able to access the contents buffer through this key
     * on your Arguments object in your command
     */
    val STDIN_CONTENT_KEY: String

    /** Create profile constants */
    @JsString("create")
    val CREATE_ACTION: String

    @JsString("profiles")
    val PROFILE_GROUP: String

    @JsString("profile")
    val PROFILE_OBJECT: String
    val PROFILE_ALIASES: Array<String>

    @JsString("profileName")
    val PROFILE_NAME_OPTION: String

    @JsString("pn")
    val PROFILE_NAME_OPTION_ALIAS: String

    @JsString("overwrite")
    val OVERWRITE_OPTION: String

    @JsString("disable-defaults")
    val DISABLE_DEFAULTS_OPTION: String

    @JsString("delete")
    val DELETE_ACTION: String

    @JsString("detail")
    val DETAILS_ACTION: String

    @JsString("show-dependencies")
    val SHOW_DEPS_ACTION: String

    @JsString("validate")
    val VALIDATE_ACTION: String

    @JsString("update")
    val UPDATE_ACTION: String

    @JsString("list")
    val LIST_ACTION: String

    @JsString("{{typeLetter}}n")
    val PROFILE_SET_OPTION_ALIAS: String

    @JsString("set-default")
    val SET_ACTION: String

    @JsString("delete-dependent-profiles")
    val PROFILE_DELETE_PROFILE_DEPS: String

    @JsString("ddp")
    val PROFILE_DELETE_PROFILE_DEPS_ALIAS: String

    @JsString("yellow")
    val DEFAULT_HIGHLIGHT_COLOR: String

    @JsString("PROMPT*")
    val DEFAULT_PROMPT_PHRASE: String

    @JsString("TRUE")
    val DEFAULT_MASK_OUTPUT: String

    @JsString("web-help")
    val WEB_HELP_DIR: String

    @JsString("web-diff")
    val WEB_DIFF_DIR: String

    /** Auth group constants */
    @JsString("auth")
    val AUTH_GROUP: String

    @JsString("login")
    val LOGIN_ACTION: String

    @JsString("li")
    val LOGIN_ACTION_ALIAS: String

    @JsString("logout")
    val LOGOUT_ACTION: String

    @JsString("lo")
    val LOGOUT_ACTION_ALIAS: String

    /** Auto Init constants */
    @JsString("auto-init")
    val AUTO_INIT_ACTION: String

    /**
     * ICommandProfileTypeConfiguration properties (used to omit from schemas registered via ProfileInfo)
     */
    val COMMAND_PROF_TYPE_PROPS: Array<String>
  }
}
