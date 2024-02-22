/**
 * Updates `extenders.json` and returns a list of types to remove from the schema, if applicable.
 * @param npmPackage The package name for the plug-in that's being uninstalled
 * @returns A list of types to remove from the schema
 */
export declare const updateAndGetRemovedTypes: (npmPackage: string) => string[];
/**
 * @TODO - allow multiple packages to be uninstalled?
 * Common function that abstracts the uninstall process.
 *
 * @param {string} packageName A package name. This value is a valid npm package name.
 *
 */
export declare function uninstall(packageName: string): void;
