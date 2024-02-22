import { IConfig } from "./IConfig";
/**
 * This enum represents the type of location for a property.
 * Note that properties with location types of ENV and DEFAULT
 * cannot be stored back to disk. Thus the consumer app must
 * make its own decision about where to store the property.
 */
export declare enum ProfLocType {
    OLD_PROFILE = 0,
    TEAM_CONFIG = 1,
    ENV = 2,
    DEFAULT = 3
}
/** The attributes used to identify the location of a given property */
export interface IProfLoc {
    /**
     * The type of location for this property
     */
    locType: ProfLocType;
    /**
     * For OLD_PROFILE and TEAM_CONFIG, this is the path to
     * the file on disk which contains the argument.
     * For ENV, this is the name of the environment variable.
     * This is not used for DEFAULT.
     */
    osLoc?: string[];
    /**
     * For SOURCE_TEAM_CONFIG, this is the dotted path into
     * the JSON configuration object for the profile.
     * This property is not used (undefined) for SOURCE_OLD_PROFILE,
     * because the old-school profiles use a simple name/value pair like:
     *      ArgumentName: value
     * This property is also not used for ENV or DEFAULT.
     */
    jsonLoc?: string;
}
/**
 * Layer information for IProfLocOsLoc
 */
export interface IProfLocOsLocLayer {
    /**
     * Determines if the osLoc is coming from a user layer
     */
    user: boolean;
    /**
     * Determines if the osLoc is coming form a global layer
     */
    global: boolean;
}
/**
 * The extended osLoc information
 */
export interface IProfLocOsLoc extends IProfLocOsLocLayer {
    /**
     * The name of the profile
     */
    name: string;
    /**
     * Contains the osLoc path information
     */
    path: string;
}
/**
 * Information to identify the arguments corresponding to the team config
 */
export interface IArgTeamConfigLoc {
    /**
     * the profile name
     */
    profileName: string;
    /**
     * the property name
     */
    propName: string;
    /**
     * the config properties
     */
    configProperties?: IConfig;
    /**
     * the osLoc information
     */
    osLocInfo: IProfLocOsLoc;
}
