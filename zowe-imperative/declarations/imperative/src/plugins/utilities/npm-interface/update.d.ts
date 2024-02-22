/**
 * @TODO - allow multiple packages to be updated?
 * Common function that abstracts the update process.
 *
 * @param {string} packageName A package name. This value is a valid npm package name.
 *
 * @param {string} registry The npm registry.
 *
 */
export declare function update(packageName: string, registry: string): Promise<string>;
