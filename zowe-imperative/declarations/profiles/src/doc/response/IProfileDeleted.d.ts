/**
 * The success response to the profile "delete()" API.
 * @export
 * @interface IProfileDeleted
 */
export interface IProfileDeleted {
    /**
     * The path to the profile that was deleted.
     * @type {string}
     * @memberof IProfileDeleted
     */
    path: string;
    /**
     * The message - for display purposes - e.g. The profile was successfully deleted.
     * @type {string}
     * @memberof IProfileDeleted
     */
    message: string;
    /**
     * Specifies whether the default profile was cleared.
     * @type {boolean}
     * @memberof IProfileDeleted
     */
    defaultCleared?: boolean;
}
