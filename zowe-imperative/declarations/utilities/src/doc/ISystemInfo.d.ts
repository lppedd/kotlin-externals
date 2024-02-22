/**
 * Information interface for basic system information
 * @export
 * @interface ISystemInfo
 */
export interface ISystemInfo {
    /**
     * The system's CPU architecture
     * @type {string}
     * @memberof ISystemInfo
     */
    arch: string;
    /**
     * The OS platform in use
     * @type {string}
     * @memberof ISystemInfo
     */
    platform: string;
}
