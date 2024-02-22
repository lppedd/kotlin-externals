/**
 * Object to hold a plugin's peer dependencies version numbers.
 */
export interface IPluginPeerDepends {
    /**
     * Each object key is the name of a plugin's peer dependency
     * and the value is the version string for that dependency.
     */
    peerDepName: string;
    peerDepVer: string;
}
