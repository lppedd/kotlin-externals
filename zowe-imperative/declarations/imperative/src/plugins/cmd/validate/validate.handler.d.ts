import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * The validate command handler for the cli plugin validate command.
 *
 * @see {validateDefinition}
 */
export default class ValidateHandler implements ICommandHandler {
    /**
     * A class with recorded issues for each plugin for which problems were detected.
     *
     * @private
     * @type {IPluginIssues}
     */
    private pluginIssues;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params - Parameters supplied by yargs
     *
     * @param {string[]} [params.arguments.plugin] - The name of
     *        a plugin to validate. If omitted all installed plugins
     *        will be validated.
     *
     * @returns {Promise<ICommandResponse>} The command response
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
    /**
     * Display the issues assocated with the specified plugin.
     *
     * @param {string} pluginName - The name of the plugin.
     *
     * @param {IHandlerResponseApi} cmdResponse - Used to supply the response from the command.
     */
    private displayPluginIssues;
}
