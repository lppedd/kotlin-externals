package zowe.imperative.imperative.doc

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileAutoInitConfig
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration

/**
 * All of the configuration required to set up your Imperative CLI app
 */
external interface IImperativeConfig {
  /**
   * Boolean flag control whether plugins are enable or disable. This option is assumed to be true
   * by default.
   */
  var allowPlugins: Boolean?

  /**
   * Boolean flag control whether config command group is enabled or disabled. This option is
   * assumed to be true by default.
   */
  var allowConfigGroup: Boolean?

  /**
   * A path to a module (javascript file) that will return a complete IImperativeConfig object. If
   * you use this option, anything else you specify in package.json or your manually provided config
   * object (i.e. Imperative.init({...}) will be ignored. Relative to the file that you call
   * Imperative.init() from, unless an absolute path is provided.
   */
  var configurationModule: String?

  /**
   * Array of globs (see npm glob package for details) relative to the file that you call
   * Imperative.init() from. The globs should match modules (javascript files) that contain command
   * definition trees as the default export. Each tree from each matching file will be treated as
   * children of the root command Note: absolute file names will also work
   */
  var commandModuleGlobs: Array<String>?

  /**
   * Rather than using modules, you can provide an array of definition trees of commands that will
   * be treated as children of the root command.
   *
   * If your configuration object is being used for a plugin, these command definitions will be
   * added to the set of commands of the CLI into which the plugin is installed.
   */
  var definitions: Array<ICommandDefinition>?

  /**
   * The description that will be displayed if the user issues your root command (e.g. if your CLI's
   * main command, in the "bin" field of package.json, is "banana", they will see this when they
   * issue "banana --help") Typically, this is an overview description of your CLI as a whole --
   * it's purpose, syntax, and information the user needs the first time they use your CLI
   *
   * If your configuration object is being used for a plugin, this property will be used as the
   * description for the plugin's top-level group. For plugins, this property must be specified.
   * Also see the 'name' property.
   */
  var rootCommandDescription: String?

  /**
   * A path to a module that implements the AbstractHelpGenerator. Use this
   */
  var customHelpGenerator: String?

  /**
   * characters that will be looped through in a progress bar e.g. "\|/-". If you don't specify
   * this, a default spinner will be used.
   */
  var progressBarSpinner: String?

  /**
   * The home directory for your CLI's configuration, logging, extensions, etc. e.g. "~"/.myapp"
   * Defaults to ~/.yourcliname
   */
  var defaultHome: String?

  /**
   * Environmental variable name prefix used to construct configuration environmental variables for
   * your CLI. For example, <your_envVariablePrefix_IMPERATIVE_LOG_LEVEL>. Note that the prefix
   * chosen should adhere to the platform env var naming standards for which your CLI is intended to
   * run.
   *
   * Optional
   *
   * Default: "name" value in this config (which defaults from package.json "name")
   */
  var envVariablePrefix: String?

  /**
   * Identifier of your CLI following the convention of "name" as is required in a package.json.
   *
   * If your configuration object is being used for a plugin, the name property is used as the group
   * name for your plugin. All plugin commands will be underneath this group. For example, if the
   * name property is YourPluginName, the plugin supplies a command named YourPluginCmd, and you
   * install YourPluginName into YourBaseCLI, you would issue a command like: YourBaseCLI
   * YourPluginName YourPluginCmd Also see the 'rootCommandDescription' property.
   *
   * Optional
   *
   * Default: package.json ==> name
   */
  var name: String?

  /**
   * The display name for your CLI, used in messages
   */
  var productDisplayName: String?

  /**
   * Use this property to configure the available profile types for your CLI. The "type" indicates a
   * homogeneous grouping of profiles (think 'category'). The "schema" dictates the structure of
   * this profile type and assists Imperative with validating profile structure (on load) and helps
   * imperative auto-generate profile manipulation commands.
   *
   * If your configuration object is being used for a plugin, these profiles will be added to the
   * set of profiles of the CLI into which the plugin is installed.
   */
  var profiles: Array<ICommandProfileTypeConfiguration>?

  /**
   * Use this property to configure a base profile for your CLI. A base profile can store shared
   * values for fields used by other profile types.
   */
  var baseProfile: ICommandProfileTypeConfiguration?

  /**
   * Use this property to customize the command definitions for the auth command group.
   */
  var authGroupConfig: IImperativeAuthGroupConfig?

  /**
   * Use this property to customize the command definition for the config init command.
   */
  var configAutoInitCommandConfig: ICommandProfileAutoInitConfig?

  /**
   * If you specify a list of profile configurations, you can set this to true to automatically add
   * a set of commands to your CLI to create, update, delete, and otherwise manage user profiles.
   * Set this to false to avoid generating these commands. l Default: true (will generate profile
   * commands if you have defined any profiles)
   */
  var autoGenerateProfileCommands: Boolean?

  /**
   * Use this property to configure imperative logs, your CLI logs, console logs, and create new logs.
   */
  var logging: IImperativeLogsConfig?

  /**
   * Optional - choose a color that will be used for help headings and other highlighting
   */
  var primaryTextColor: String?

  /**
   * Optional - choose a secondary color that will be used for things like highlighting search
   * results and other rarer
   */
  var secondaryTextColor: String?

  /**
   * Optional - List of overrides you wish Imperative to use instead of the defaults.
   */
  var overrides: IImperativeOverrides?

  /**
   * A path to a plugin's module (javascript file) that extends the AbstractPluginLifeCycle class.
   * The functions of that class enable a plugin to perform an action immediately after its
   * installation and to perform an action before its un-installation.
   *
   * See AbstractPluginLifeCycle for the detailed functions.
   */
  var pluginLifeCycle: String?

  /**
   * A path to a module (javascript file) that will perform a health check for a plugin. The health
   * check should verify the health of the plugin. The implementor of a plugin determines what
   * actions can confirm that the plugin is in an operational state.
   *
   * The health check should return true if all plugin health checks pass. It should return false
   * otherwise.
   *
   * This property is unused for a base CLI.
   *
   * No Zowe CLI command currently calls the health check function.
   *
   * **Deprecated**: this property is deprecated. Plugins that want to perform a health check can
   *   specify the pluginLifeCycle property to load a class from the plugin. The plugin can
   *   implement the postInstall() function of that class to perform a health check, or any other
   *   desired operation. Our intention is to remove the pluginHealthCheck property in Zowe V3.
   */
  @Deprecated("See KDoc")
  var pluginHealthCheck: String?

  /**
   * If the project you are configuring is an Imperative plugin, you can assign aliases to the group
   * that is added when a user installs your plugin.
   *
   * So, if your plugin's name is "my-special-plugin" and you specify ["msp"] as your value for
   * pluginAliases, users can issue the command "mycli my-special-plugin my-command" or "mycli msp
   * my-command"
   *
   * Note: For plugins only. Ignored when specified on a core/base CLI
   *
   * Example:
   * ```
   * const config: IImperativeConfig = { ... pluginAliases: ["msp"] ... }
   * ```
   */
  var pluginAliases: Array<String>?

  /**
   * If the project you are configuring is an Imperative plugin, you can assign a summary to the
   * plugin that is showed in the root level help for the core CLI. The summary is a short
   * description of your plugin's functionality.
   *
   * Note: For plugins only. Ignored when specified on a core/base CLI
   *
   * Example:
   * ```
   * const config: IImperativeConfig = { ... pluginSummary: "a brief summary of your group" ... }
   * ```
   */
  var pluginSummary: String?

  /**
   * If the project you are configuring is an Imperative plugin, you can assign the first steps to
   * the plugin, where it will be visible when running the firststeps command in the root plugins
   * level help for the core CLI.
   *
   * The first steps are a short list of steps required to set up your plugin for use.
   *
   * Note: For plugins only. Ignored when specified on a core/base CLI
   *
   * Example:
   * ```
   * const config: IImperativeConfig = { ... pluginFirstSteps: "a list of first steps for your plugin" ... }
   * ```
   */
  var pluginFirstSteps: String?

  /**
   * Optionally override the block of text that appears in the help text for commands that are set
   * to experimental:true in their definition. You can use this to describe what a command being
   * experimental means to your CLI. If you omit this, a generic block of text
   * (Constants.DEFAULT_EXPERIMENTAL_COMMAND_EXPLANATION) will be used by default.
   */
  var experimentalCommandDescription: String?

  /**
   * Optionally specify path to an image of logo for your CLI.
   * It will be displayed at the top of web help pages.
   */
  var webHelpLogoImgPath: String?

  /**
   * Optionally specify path to a custom CSS file for web help.
   * It will replace the main.css file that controls the style of the page.
   */
  var webHelpCustomCssPath: String?

  /**
   * The set of attributes used to lookup (within the API Mediation Layer) the connection properties
   * for the REST service associated with this command group. We use an array of such attributes in
   * case the command group is compatible with multiple versions of the associated REST service.
   */
  var apimlConnLookup: Array<IApimlSvcAttrs>?

  /**
   * If Imperative should run in Daemon mode This should only be specified for CLIs
   */
  var daemonMode: Boolean?
}
