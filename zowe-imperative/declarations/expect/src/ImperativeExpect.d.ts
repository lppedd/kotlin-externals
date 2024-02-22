import { ImperativeError } from "../../error";
/**
 * Helper class for paramter validation. Expectations that fail will throw an ImperativeError with a validation
 * error message.
 *
 * All methods allow keys to be specified as "property1.prop.lastprop" for example.
 *
 * @export
 * @class ImperativeExpect
 */
export declare class ImperativeExpect {
    /**
     * The error tag to append to each error message.
     * @static
     * @type {string}
     * @memberof ImperativeExpect
     */
    static readonly ERROR_TAG: string;
    /**
     * Expect a situation and transform the error (if expect fails).
     * Accepts two methods of your implementation to:
     * A) Test the expect (which is intended to throw an ImperativeError)
     * B) Transform and return a new ImperativeError
     * This allows you complete control over the contents of the error. If you are only interested in influencing the
     * message displayed, then use the msg parm on each of the expect functions.
     * @static
     * @param {() => void} expect - The method that contains your ImperativeExpect invocation
     * @param {(error: any) => ImperativeError} transform - Passed the error thrown by the expect and expects you
     * to return the ImperativeError you would like thrown.
     * @memberof ImperativeExpect
     */
    static expectAndTransform(expect: () => void, transform: (error: any) => ImperativeError): void;
    /**
     * Expect that values are equal (via "!==" operator).
     * @static
     * @param {*} value1 - Value 1
     * @param {*} value2 - Value 2
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static toBeEqual(value1: any, value2: any, msg?: string): void;
    /**
     * Expect that value matches the regular expression (via ".test()" method).
     * @static
     * @param {*} value - Value
     * @param {*} myRegex - Regular expression
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static toMatchRegExp(value: any, myRegex: string, msg?: string): void;
    /**
     * Expect the object passed to be defined.
     * @static
     * @param {*} obj - The object to check
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static toNotBeNullOrUndefined(obj: any, msg?: string): void;
    /**
     * Expect the object passed to be an array that contains a particular entry.
     * Your compare method is invoked to determine if the entry you're looking for is found within the array.
     * @static
     * @param {any[]} arr - the array to search
     * @param {(parms: any) => boolean} compare - compare method (passed the parms) - return true if the entry is
     * found within the array.
     * @param {string} [msg] - The message to throw - overrides the default message
     * @returns {*} - If a match is found, it will return the match.
     * @memberof ImperativeExpect
     */
    static arrayToContain(arr: any[], compare: (entry: any) => boolean, msg?: string): any;
    /**
     * Check if the input is one of several possibilities in a list.
     * @static
     * @param {*} value - The value to find in following array
     * @param {any[]} arr - The array of possible items we could be expecting
     * @param {string} [msg] - The message - overrides the default message
     * @returns {*} - If a match is found, it will return the match.
     * @memberof ImperativeExpect
     */
    static toBeOneOf(value: any, arr: any[], msg?: string): any;
    /**
     * Check if the input object is an array.
     * @static
     * @param {any[]} arr - The array to check
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static toBeAnArray(arr: any[], msg?: string): void;
    /**
     * Expect a set of keys (by name) to be defined, of type array, and optionally a non-zero length array.
     * @static
     * @param obj - the object for which you would like to assert that certain fields
     * @param nonZeroLength if true, the length of the array must be non zero
     * @param {...string[]} keys - keys in object that should be arrays
     * @param {string} [msg] - The message to throw - overrides the default message
     */
    static keysToBeAnArray(obj: {
        [key: string]: any;
    } | any, nonZeroLength: boolean, keys: string[], msg?: string): void;
    /**
     * Expect a set of keys (by name) are defined.
     * @static
     * @param {{[key: string]: any}} obj - object to test existence
     * @param {...string[]} keys - keys in object
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static keysToBeDefined(obj: {
        [key: string]: any;
    } | any, keys: string[], msg?: string): void;
    /**
     * Expect two values to be equal (via "===" operator).
     * @static
     * @param {*} value1 - Value 1
     * @param {*} value2 - Value 2
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static toNotBeEqual(value1: any, value2: any, msg?: string): void;
    /**
     * Expect that a set of keys are defined, of type string, and are non-blank (after trimming).
     * @static
     * @param {{[key: string]: string}} obj - object to test existence
     * @param {...string[]} keys - keys in object
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static keysToBeDefinedAndNonBlank(obj: {
        [key: string]: string;
    } | any, keys: string[], msg?: string): void;
    static toBeDefinedAndNonBlank(item: string, label: string, msg?: string): void;
    /**
     * Expect a set of keys to be of a certain type.
     * @static
     * @param {{ [key: string]: any }} obj - The input object
     * @param {string} type - The type to check for (only primatives - uses "typeof")
     * @param {...string[]} keys - A list of keys to check in the object
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static keysToBeOfType(obj: {
        [key: string]: any;
    } | any, type: string, keys: string[], msg?: string): void;
    /**
     * Expect a set of keys to be undefined.
     * @static
     * @param {{[key: string]: any}} obj - object to test existence
     * @param {...string[]} keys - keys in object
     * @param {string} [msg] - The message to throw - overrides the default message
     * @memberof ImperativeExpect
     */
    static keysToBeUndefined(obj: {
        [key: string]: any;
    }, keys: string[], msg?: string): void;
}
