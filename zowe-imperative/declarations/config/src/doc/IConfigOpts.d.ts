import { IConfigVault } from "./IConfigVault";
export interface IConfigOpts {
    /**
     * Directory where global config files are located. Defaults to `~/.appName`.
     */
    homeDir?: string;
    /**
     * Directory where project config files are located. Defaults to working directory.
     * Specify `false` to disable loading of project config files.
     */
    projectDir?: string | false;
    /**
     * Vault object with methods for loading and saving secure credentials
     */
    vault?: IConfigVault;
    /**
     * Do not attempt to load the config, meant for when the config is broken
     */
    noLoad?: boolean;
}
