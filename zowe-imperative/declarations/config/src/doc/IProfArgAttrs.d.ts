import { IProfLoc } from "./IProfLoc";
/** The type of data for this property */
export declare type IProfDataType = "string" | "number" | "boolean" | "array" | "object";
/** The value for the argument */
export declare type IProfArgValue = string | number | boolean | string[] | object;
/**
 * The attributes of a profile argument.
 */
export interface IProfArgAttrs {
    /** The name of the argument */
    argName: string;
    /** The type of data for this property */
    dataType: IProfDataType;
    /** The value for the argument */
    argValue: IProfArgValue;
    /** The location of this argument */
    argLoc: IProfLoc;
    /** Whether the argument value is stored securely */
    secure?: boolean;
    /** Whether the argument value is defined in the schema file */
    inSchema?: boolean;
}
