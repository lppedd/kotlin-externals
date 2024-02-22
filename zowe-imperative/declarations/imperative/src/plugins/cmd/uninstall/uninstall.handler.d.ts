import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * The uninstall command handler for cli plugin install.
 *
 * @see {uninstallDefinition}
 */
export default class UninstallHandler implements ICommandHandler {
    /**
     * A logger for this class
     *
     * @private
     * @type {Logger}
     */
    private console;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @param {string[]} [params.arguments.plugin] This is the plugin to uninstall.
     *
     * @returns {Promise<ICommandResponse>} The command response
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
    /**
     * Call a plugin's lifecycle hook to enable a plugin to take some action
     * before the plugin is uninstalled.
     *
     * @param pluginPackageNm The package name of the plugin being installed.
     *
     * @throws ImperativeError.
     */
    private callPluginPreUninstall;
}
