import { ImperativeError } from "../../../error";
/**
 * Definition for a promise rejection method that provides an ImperativeError (or subclass)
 */
export declare type ImperativeReject = (error: ImperativeError) => void;
