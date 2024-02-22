/**
 * Command profile loader internal parameters. Indicates the profile to be loaded (by name) and
 * other options/control parameters.
 * @export
 * @interface ICommandLoadProfile
 */
export interface ICommandLoadProfile {
    /**
     * The type of the profile to load.
     * @type {string}
     * @memberof ICommandLoadProfile
     */
    type: string;
    /**
     * The name of the profile to load for the type specified.
     * @type {string}
     * @memberof ICommandLoadProfile
     */
    name: string;
    /**
     * Indicates that the user specifically named this profile to be loaded (not a default, etc.)
     * @type {boolean}
     * @memberof ICommandLoadProfile
     */
    userSpecified: boolean;
    /**
     * Load the default profile for the group. If this option is specified, name is ignored.
     * @type {boolean}
     * @memberof ICommandLoadProfile
     */
    loadDefault: boolean;
    /**
     * Indicates that a failure to load this profile is not a problem.
     * @type {boolean}
     * @memberof ICommandLoadProfile
     */
    optional: boolean;
}
