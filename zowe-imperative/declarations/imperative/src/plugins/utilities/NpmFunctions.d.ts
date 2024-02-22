/**
 * Common function that returns npm command as a string.
 *
 * @return {string} command with npm path
 */
export declare function findNpmOnPath(): string;
/**
 * Common function that installs a npm package using the local npm cli.
 * @param {string} prefix Path where to install npm the npm package.
 *
 * @param {string} registry The npm registry to install from.
 *
 * @param {string} npmPackage The name of package to install.
 *
 * @return {string} command response
 *
 */
export declare function installPackages(prefix: string, registry: string, npmPackage: string): string;
/**
 * Get the registry to install to.
 *
 * @return {string}
 */
export declare function getRegistry(): string;
/**
 * NPM login to be able to install from secure registry
 * @param {string} registry The npm registry to install from.
 */
export declare function npmLogin(registry: string): void;
/**
 * Fetch name and version of NPM package that was installed
 * @param pkgSpec The package name as specified on NPM install
 */
export declare function getPackageInfo(pkgSpec: string): Promise<{
    name: string;
    version: string;
}>;
