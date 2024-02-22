import { Config } from "../../../../config";
/**
 * Constants used by the PMF.
 */
export declare class PMFConstants {
    /**
     * Internal singleton object for the instance of the constants. This is done
     * this way because some of the variables need Imperative to have been
     * initialized first. That initialization happens at run time and not
     * compile time.
     *
     * @private
     * @type {PMFConstants}
     */
    private static mInstance;
    /**
     * Get the singleton PMFConstants object. The first time this is requested, a
     * new object is created.
     *
     * @returns {PMFConstants} The constants class
     */
    static get instance(): PMFConstants;
    /**
     * The NPM package name for the command line app's core package.
     */
    readonly CLI_CORE_PKG_NAME: string;
    /**
     * The NPM package name for the command line app's core package.
     */
    readonly IMPERATIVE_PKG_NAME: string;
    /**
     * The namespace that we use for imperative and our CLI app.
     */
    readonly NPM_NAMESPACE: string;
    /**
     * The root directory for all plugin related items.
     * @type {string}
     */
    readonly PMF_ROOT: string;
    /**
     * The plugin.json config file location.
     *
     * @type {string}
     */
    readonly PLUGIN_JSON: string;
    /**
     * Installation directory for plugins
     * @type {string}
     */
    readonly PLUGIN_INSTALL_LOCATION: string;
    /**
     * This stores the plugin node_module location. Since linux and windows can
     * differ here, this will be PLUGIN_INSTALL_LOCATION appended with either
     * node_modules or lib/node_modules.
     *
     * @type {string}
     */
    readonly PLUGIN_NODE_MODULE_LOCATION: string[];
    /**
     * Indicates if we are using a configuration file
     *
     * @type {boolean}
     */
    readonly PLUGIN_USING_CONFIG: boolean;
    /**
     * The config object
     *
     * @type {Config}
     */
    readonly PLUGIN_CONFIG: Config;
    /**
     * The home location for plugins
     *
     * @type {string}
     */
    readonly PLUGIN_HOME_LOCATION: string;
    constructor();
}
