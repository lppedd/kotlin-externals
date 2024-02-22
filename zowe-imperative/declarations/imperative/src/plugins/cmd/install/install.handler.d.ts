import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * The install command handler for cli plugin install.
 *
 * @see {installDefinition}
 */
export default class InstallHandler implements ICommandHandler {
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
     * @param {string[]} [params.arguments.plugin=[]] This is an array of plugins to install. Plugins can be anything
     *                                                 that is acceptable to an `npm install` command. NOTE: If you want
     *                                                 to use a local plugin with a relative path, be sure to include
     *                                                 at least one / or \ character. Ex: you have a local plugin called
     *                                                 "test-plugin" in your cwd, you need to do `cli plugin install
     *                                                 ./test-plugin` as test-plugin will be interpreted as a remote npm
     *                                                 package name. When this argument is empty, we will attempt to use
     *                                                 a plugins.json file to install the plugins from.
     *
     * @param {string} [params.arguments.registry] This is the npm registry to install from, if this parameter is not
     *                                             specified by the command line, then we will use the value returned by
     *                                             `npm config get registry.
     *
     * @param {string} [params.arguments.file] This option specifies the location of a plugins.json file to be used for
     *                                         the install. When no packages are specified, all plugins specified in this
     *                                         file will be installed to the base cli and the contents will be copied over
     *                                         to plugins.json.
     *
     *                                         If this argument is missing and no packages are specified,
     *                                         we will install from the actual plugins.json file (which may or may not
     *                                         have plugins in it). The reason for this logic is because plugins may be
     *                                         deleted when a base cli is updated. However, someone could issue a command
     *                                         like, `cli plugin install`, to get everything back after an update.
     *
     * @returns {Promise<ICommandResponse>} The command response
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
}
