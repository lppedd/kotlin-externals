/**
 * Syntax validator response.
 * TODO - In the future, when we supply an the ability to override/extend the SyntaxValidator, we should change the
 * TODO - validator from printing the syntax errors itself to returning an object with a structured error list.
 * @export
 * @interface ICommandValidatorResponse
 */
export interface ICommandValidatorResponse {
    /**
     * Indicates if the syntax/parameters supplied by the user were valid.
     * @type {boolean}
     * @memberof ICommandValidatorResponse
     */
    valid: boolean;
}
