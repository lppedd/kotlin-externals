export interface IConfigMergeOpts {
    /**
     * Indicates whether we should mask off secure properties.
     * @defaultValue `false`
     */
    maskSecure?: boolean;
    /**
     * Indicates whether we should exclude global layers.
     * @defaultValue `false`
     */
    excludeGlobalLayer?: boolean;
    /**
     * Indicates whether we should clone layers to prevent accidental edits.
     * If maskSecure is true, then it is implied that cloneLayers is true.
     * @defaultValue `true`
     */
    cloneLayers?: boolean;
}
