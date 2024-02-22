/**
 * Response to the Basic profile manager's initialize API - normally provided as an array to the caller indicating
 * each profile type that was initialized.
 * @export
 * @interface IProfileInitialized
 */
export interface IProfileInitialized {
    /**
     * The message indicating that the profile type was initialized or re-initialized.
     * @type {string}
     * @memberof IProfileInitialized
     */
    message: string;
}
