import { IPluginCfgProps } from "./doc/IPluginCfgProps";
import { ICommandDefinition } from "../../../cmd";
import { IImperativeOverrides } from "../doc/IImperativeOverrides";
/**
 * This class is the main engine for the Plugin Management Facility. The
 * underlying class should be treated as a singleton and should be accessed
 * via PluginManagmentFacility.instance.
 */
export declare class PluginManagementFacility {
    /**
     * This is the variable that stores the specific instance of the PMF. Defined
     * as static so that it can be accessed from anywhere.
     *
     * @private
     * @type {PluginManagementFacility}
     */
    private static mInstance;
    /**
     * Gets a single instance of the PMF. On the first call of
     * PluginManagementFacility.instance, a new PMF is initialized and returned.
     * Every subsequent call will use the one that was first created.
     *
     * @returns {PluginManagementFacility} - The newly initialized PMF object.
     */
    static get instance(): PluginManagementFacility;
    /**
     * Internal reference to the set of configuration properties for all loaded plugins.
     */
    private mAllPluginCfgProps;
    /**
     * Get the set of configuration properties for all loaded plugins.
     */
    get allPluginCfgProps(): IPluginCfgProps[];
    /**
     * Internal reference to the overrides provided by plugins.
     */
    private mPluginOverrides;
    /**
     * Object that defines what overrides will be provided by all plugins.
     */
    get pluginOverrides(): IImperativeOverrides;
    /**
     * Used as a short-name access to PMF constants.
     */
    private pmfConst;
    /**
     * The CLI command tree with module globs already resolved.
     *
     * @private
     * @type {ICommandDefinition}
     */
    private resolvedCliCmdTree;
    /**
     * The property name within package.json that holds the
     * Imperative configuration object.
     *
     * @private
     * @type {string}
     */
    private readonly impConfigPropNm;
    /**
     * Used for internal imperative logging.
     *
     * @private
     * @type {Logger}
     */
    private impLogger;
    /**
     * A class with recorded issues for each plugin for which problems were detected.
     *
     * @private
     * @type {IPluginIssues}
     */
    private pluginIssues;
    /**
     * A set of bright dependencies used by plugins. Each item in the
     * set contains the dependency's property name, and the the version
     * of that dependency.
     *
     * @type {Object}
     */
    private readonly npmPkgNmProp;
    private readonly noPeerDependency;
    /**
     * The semantic versioning module (which does not have the
     * typing to do an 'import').
     */
    private readonly semver;
    /**
     * Tracker to ensure that [init]{@link PluginManagementFacility#init} was
     * called. Most methods cannot be used unless init was called first.
     *
     * @private
     * @type {boolean}
     */
    private wasInitCalled;
    /**
     * Initialize the PMF. Must be called to enable the various commands provided
     * by the facility.
     */
    init(): void;
    /**
     * Add all installed plugins' commands and profiles into the host CLI's command tree.
     *
     * @param resolvedCliCmdTree - The CLI command tree with
     *        module globs already resolved.
     */
    addAllPluginsToHostCli(resolvedCliCmdTree: ICommandDefinition): void;
    /**
     * Loads the configuration properties of each plugin. The configuration
     * information is used when overriding a piece of the imperative
     * infrastructure with a plugin's capability, when validating each plugin,
     * and when adding each plugin's commands to the CLI command tree.
     * Errors are recorded in PluginIssues.
     */
    loadAllPluginCfgProps(): void;
    /**
     * Produces a function that requires a module from a plugin using a relative
     * path name from the plugin's root to the module. Used as a callback function
     * from the ConfigurationLoader to load configuration handlers.
     *
     * @param {string} pluginName - The name of the plugin/module to load.
     *
     * @returns {function} - The method responsible for requiring the module
     */
    requirePluginModuleCallback(pluginName: string): ((relativePath: string) => any);
    /**
     * Add the specified plugin to the imperative command tree.
     *
     * @param {IPluginCfgProps} pluginCfgProps - The configuration properties for this plugin
     */
    private addPluginToHostCli;
    /**
     * Add a new command group into the host CLI's resolved command tree.
     * We had to wait until the host CLI was resolved, so that we could check for
     * name conflicts. So each  plugin's commands are added to the host CLI
     * command tree after both have been resolved.
     *
     * @param {string} pluginName - the name of the plugin to initialize
     *
     * @param {ICommandDefinition} cmdDefToAdd - command definition group to to be added.
     *
     * @returns True upon success. False upon error, and errors are recorded in pluginIssues.
     */
    private addCmdGrpToResolvedCliCmdTree;
    /**
     * Compare the version of a plugin version property with a version property
     * of its base CLI.
     *
     * If the versions do not intersect (according so semver rules), then a
     * PluginIssue is recorded.
     *
     * @param  pluginName - The name of the plugin.
     *
     * @param  pluginVerPropNm - The name of the plugin property containing a version.
     *
     * @param  pluginVerVal - value of the plugin's version.
     *
     * @param  cliVerPropNm - The name of the base CLI property containing a version.
     *
     * @param  cliVerVal - value of the base CLI's version.
     *
     */
    private comparePluginVersionToCli;
    /**
     * Get the package name of our base CLI.
     *
     * @returns The CLI package name contained in the package.json 'name' property.
     */
    private getCliPkgName;
    /**
     * Remove a command group that was previously added.
     * We remove a command group if we discover errors after
     * adding the command group.
     *
     * @param {ICommandDefinition} cmdDefToRemove - command definition to be removed.
     */
    private removeCmdGrpFromResolvedCliCmdTree;
    /**
     * Does the supplied pluginGroupNm match an existing top-level
     * name or alias in the imperative command tree?
     * If a conflict occurs, plugIssues.doesPluginHaveError() will return true.
     *
     * @param {string} pluginName - The name of the plugin that we are checking.
     *
     * @param {ICommandDefinition} pluginGroupDefinition - A plugin's command group definition..
     *
     * @param {ICommandDefinition} cmdTreeDef - A top-level command tree
     *        definition against which we compare the supplied
     *        pluginGroupNm. It is typically the imperative command tree.
     *
     * @returns {[boolean, string]} - {hasConflict, message} - hasConflict: True when we found a conflict.
     *                                False when find no conflicts.
     *                                message: the message describing the conflict
     */
    private conflictingNameOrAlias;
    /**
     * Form the absolute path to a runtime file for a plugin from a path name
     * that is relative to the plugin's root directory (where its package.json lives).
     *
     * @param {string} pluginName - The name of the plugin.
     *
     * @param {string} relativePath - A relative path from plugin's root.
     *        Typically supplied as ./lib/blah/blah/blah.
     *        If not supplied, (or supplied as an an empty string,
     *        the result will be a path to
     *        <The_PLUGIN_NODE_MODULE_LOCATION_ForTheBaseCLI>/<pluginName>.
     *        If an absolute path is supplied, it is returned exactly as supplied.
     *
     * @returns {string} - The absolute path to the file.
     */
    private formPluginRuntimePath;
    /**
     * Read a plugin's configuration properties. The properties are obtained
     * from the plugins package.json file, including it's imperative property.
     *
     * @param {string} pluginName - the name of the plugin
     *
     * @returns {IPluginCfgProps} - The plugin's configuration properties
     *    or null if the plugin's configuration cannot be retrieved.
     *    Errors are recorded in PluginIssues.
     */
    private loadPluginCfgProps;
    /**
     * Due to configuration errors, we use an override that purposely fails.
     *
     * @param {string} settingNm - The name of the setting being processed.
     * @param {string} overrideDispNm - The display name of override being processed.
     * @param {string} overridePluginNm - The name of plugin supplying the override.
     * @param {string} reasonText - The text describing the reason for the error.
     */
    private useOverrideThatFails;
    /**
     * Validates that the semver range strings specified by the plugin for
     * versions of the imperative framework and host CLI program are compatible
     * with those specified in the host CLI.
     *
     * Both range strings come from the package.json files of the plugin and the
     * hosting CLI. We consider the version ranges to be compatible if the two
     * ranges intersect. This should allow npm to download one common version
     * of core and of imperative to be owned by the base CLI and shared by the plugin.
     *
     * Any errors are recorded in PluginIssues.
     *
     * @param {IPluginCfgProps} pluginCfgProps - The configuration properties for this plugin
     */
    private validatePeerDepVersions;
    /**
     * Validate the plugin.
     *
     * @param {IPluginCfgProps} pluginCfgProps - The configuration properties for this plugin
     *
     * @param {ICommandDefinition} pluginCmdGroup - The command group to be added
     *        for this plugin, with all commands resolved into its children property.
     *
     * @returns {boolean} - True if valid. False otherwise.
     *        PluginIssues contains the set of issues.
     */
    private validatePlugin;
    /**
     * Validate a plugin's array of command definitions at the specified depth
     * within the plugin's command definition tree. This is a recursive function
     * used to navigate down through the command tree, validating as we go.
     * If errors occur, they are recorded in PlugIssues.
     *
     * @param {string} pluginName - The name of the plugin.
     *
     * @param {ICommandDefinition[]} pluginCmdDefs - Array of plugin commands.
     *
     * @param {number} cmdTreeDepth - The depth within the plugin command
     *        tree at which we are validating. It is used within error messages.
     */
    private validatePluginCmdDefs;
    /**
     * Validate a plugin's array of profiles
     * If errors occur, they are recorded in PlugIssues.
     *
     * @param {string} pluginName - The name of the plugin.
     *
     * @param {ICommandProfileTypeConfiguration[]} pluginProfiles - Array of profiles.
     */
    private validatePluginProfiles;
}
