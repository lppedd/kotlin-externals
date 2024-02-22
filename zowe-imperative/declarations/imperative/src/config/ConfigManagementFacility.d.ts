export declare class ConfigManagementFacility {
    private static mInstance;
    /**
     * Used for internal imperative logging.
     *
     * @private
     * @type {Logger}
     */
    private impLogger;
    /**
     * Gets a single instance of the CMF. On the first call of
     * ConfigManagementFacility.instance, a new CMF is initialized and returned.
     * Every subsequent call will use the one that was first created.
     *
     * @returns {ConfigManagementFacility} - The newly initialized CMF object.
     */
    static get instance(): ConfigManagementFacility;
    /**
     * Initialize the CMF. Must be called to enable the various commands provided
     * by the facility.
     */
    init(): void;
}
