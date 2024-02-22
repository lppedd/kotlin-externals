import { IPluginIssues, IPluginIssue } from "../doc/IPluginIssues";
import { IPluginJson } from "../doc/IPluginJson";
/**
 * This enum represents the possible severity types of a plugin issue.
 */
export declare enum IssueSeverity {
    /**
     * Configuration errors. We cannot even properly define this plugin.
     * The plugin cannot be used.
     */
    CFG_ERROR = "CfgError",
    /**
     * An error in a plugin's set of commands.
     * The plugin's commands will not be loaded into the host CLI app.
     * It's overrides may be used.
     */
    CMD_ERROR = "CmdError",
    /**
     * An error in a plugin's override component.
     * The plugin's overrides will not be used by imperative
     * It's commands may be added to the host CLI app.
     */
    OVER_ERROR = "OverrideError",
    /**
     * Warnings identify optional items not implemented by a plugin.
     */
    WARNING = "Warning"
}
/**
 * This class is used to record and access plugin errors and warnings.
 * It is a singleton and should be accessed via PluginIssues.instance.
 */
export declare class PluginIssues {
    /**
     * This is the variable that stores the specific instance of the PluginIssues.
     * Defined as static so that it can be accessed from anywhere.
     *
     * @private
     * @type {PluginIssues}
     */
    private static mInstance;
    /**
     * A map containing issues  for each plugin for which problems were detected.
     *
     * @private
     * @type {IPluginIssues}
     */
    private pluginIssues;
    /**
     * The set of installed plugins. We access this class property only
     * through its accompanying function
     * [getInstalledPlugins]{@link PluginIssues#getInstalledPlugins}
     * to ensure that we only read the file once and reduce excessive I/O.
     *
     * @private
     * @type {IPluginJson}
     */
    private installedPlugins;
    /**
     * Gets a single instance of the PluginIssues. On the first call of
     * PluginIssues.instance, a new Plugin Issues object is initialized and returned.
     * Every subsequent call will use the one that was first created.
     *
     * @returns {PluginIssues} The newly initialized PMF object.
     */
    static get instance(): PluginIssues;
    /**
     * Reports whether or not a plugin has any issues with any of the specified
     * severities.
     *
     * @param {string} pluginName - The name of the plugin
     *
     * @param {string} issueSevs - An array of issue severities.
     *
     * @returns {boolean} - True if any plugin issues have any of the severities.
     *                      False otherwise.
     */
    doesPluginHaveIssueSev(pluginName: string, issueSevs: IssueSeverity[]): boolean;
    /**
     * Get the issues recorded for all plugins.
     * @returns {IPluginIssues} - Map of plugin names to their array of issues.
     */
    getAllIssues(): IPluginIssues;
    /**
     * Get the set of installed plugins. This function should be the only means
     * used to access our installedPlugins class variable.
     *
     * @returns {IPluginJson} - The set of installed plugins.
     */
    getInstalledPlugins(): IPluginJson;
    /**
     * Get the array of issues for the specified plugin.
     * @param {string} pluginName - The name of the plugin
     * @returns {IPluginIssue[]} - Array of issues for the plugin.
     *                             If no issues, an empty array is returned.
     */
    getIssueListForPlugin(pluginName: string): IPluginIssue[];
    /**
     * Remove the specified plugin from the collection of plugin issues.
     * @param {string} pluginName - The name of the plugin to remove
     */
    removeIssuesForPlugin(pluginName: string): void;
    /**
     * Record an issue that was discovered in a plugin into an in-memory structure.
     * The plugin issues can later be accessed to report the health of a plugin.
     * @param {string} pluginName - The name of the plugin
     * @param {IssueSeverity} issueSev - The severity of the issue.
     *                            Use PluginIssues.ERROR or PluginIssues.WARNING
     * @param {string} issueText - The issue message text to record.
     */
    recordIssue(pluginName: string, issueSev: IssueSeverity, issueText: string): void;
}
