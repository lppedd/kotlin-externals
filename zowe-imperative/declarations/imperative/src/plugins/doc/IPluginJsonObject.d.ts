/**
 * Information about an installed plugin
 */
export interface IPluginJsonObject {
    /**
     * The package location. If this is an npm package, this will be no different
     * than the key in the JSON file.
     *
     * @type {string}
     */
    package: string;
    /**
     *  The npm registry to install from.
     *
     *  @type {string}
     */
    registry: string;
    /**
     * The version of the installed plugin.
     *
     * @type {string}
     */
    version: string;
}
