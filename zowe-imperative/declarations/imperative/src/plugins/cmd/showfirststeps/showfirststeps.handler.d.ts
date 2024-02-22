import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * The firststeps command handler for cli plugin firststeps.
 *
 * @see {firststepsDefinition}
 */
export default class FirststepsHandler implements ICommandHandler {
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
     * @param {string[]} [params.arguments.plugin] This is the plugin to show the first steps for.
     *
     * @param {IPluginCfgProps} pluginCfgProps - The configuration properties for this plugin
     *
     * @returns {Promise<ICommandResponse>} The command response
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
}
