/**
 * Help generator API. See the AbstractHelpGenerator+DefaultHelpGenerator for the base implementation.
 * @export
 * @interface IHelpGenerator
 */
export interface IHelpGenerator {
    /**
     * Constructs the help text for a command/group.
     * @returns {string}
     * @memberof IHelpGenerator
     */
    buildHelp(): string;
}
