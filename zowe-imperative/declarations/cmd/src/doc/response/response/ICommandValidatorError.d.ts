/**
 * Describes the operand in error and provides the full definition for the option/operand - normally exposed when the
 * JSON response format is requested.
 * @export
 * @interface ICommandValidatorError
 */
export interface ICommandValidatorError {
    /**
     * The validation error message.
     * @type {string}
     * @memberof ICommandValidatorError
     */
    message: string;
    /**
     * The option that failed validation.
     * @type {string}
     * @memberof ICommandValidatorError
     */
    optionInError?: string;
    /**
     * The option definition that failed.
     * @type {*}
     * @memberof ICommandValidatorError
     */
    definition?: any;
}
