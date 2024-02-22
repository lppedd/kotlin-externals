/**
 * Class containing daemon utility functions.
 * @export
 * @class DaemonUtil
 */
export declare class DaemonUtil {
    /**
     * Get the directory that holds daemon-related runtime files.
     * Ensures that the directory exists, or we create it.
     *
     * @returns The absolute path to the daemon directory.
     */
    static getDaemonDir(): string;
}
