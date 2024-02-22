/**
 * Imperative command arguments. Originally created by Yargs parse and
 * completed by Imperative. Passed to command handlers.
 *
 * The object contains two properties always present ($0 and _) and the rest of
 * the object will contain the option names, in both camel, kebab, and alias as
 * the keys with their values being plugged in by from CLI options, ENV vars,
 * profiles, or default values.
 */
export interface ICommandArguments {
    /**
     * The "executable" - normally the main entry point of the node application.
     * @example "main.js"
     * @type {string}
     */
    $0: string;
    /**
     * The set of command segments and positional operands in an array.
     * @type {string[]}
     * @example ["create", "file", "text.txt"]
     */
    _: string[];
    /**
     * Index signature.
     */
    [key: string]: any;
}
