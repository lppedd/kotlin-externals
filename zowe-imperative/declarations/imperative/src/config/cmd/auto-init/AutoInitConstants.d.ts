import { ICommandOptionDefinition } from "../../../../../cmd";
export declare class AutoInitConstants {
    static AUTO_INIT_OPTION_GROUP: string;
    /**
     * Option used to specify whether or not to use the user layer of the config
     */
    static AUTO_INIT_OPTION_USER_CONFIG: ICommandOptionDefinition;
    /**
     * Option used to specify whether or not to use the global layer of the config
     */
    static AUTO_INIT_OPTION_GLOBAL_CONFIG: ICommandOptionDefinition;
    /**
     * Option used to specify whether or not to do a dry run of the initialization
     */
    static AUTO_INIT_OPTION_DRY_RUN: ICommandOptionDefinition;
    /**
     * Option used to specify whether or not to open an editor for the config
     */
    static AUTO_INIT_OPTION_EDIT: ICommandOptionDefinition;
    /**
     * Option used to specify whether or not to overwrite the config
     */
    static AUTO_INIT_OPTION_OVERWRITE: ICommandOptionDefinition;
    /**
     * Option used to confirm an overwrite
     */
    static AUTO_INIT_OPTION_FOR_SURE: ICommandOptionDefinition;
}
