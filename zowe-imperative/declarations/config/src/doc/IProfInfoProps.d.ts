/**
 * Options that will affect the behavior of the ProfileInfo class.
 * They are supplied on the ProfileInfo getAllProfiles method.
 */
export interface IGetAllProfilesOptions {
    /**
     * Indicates if the home directory should be excluded
     * The default is false.
     */
    excludeHomeDir?: boolean;
}
