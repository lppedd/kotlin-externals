/**
 * Interface describing syntax validation rule where specifying a certain
 * value means that the user must also specify other options
 */
export interface ICommandOptionValueImplications {
    /**
     * What option names are implied if the value in question is specified
     * @type {string[]}
     * @memberof ICommandOptionValueImplications
     */
    impliedOptionNames: string[];
    /**
     * Is the value case sensitive?
     * If yes, the strings will be compared with "===".
     * Otherwise they will be uppercased before comparing
     * @type {boolean}
     * @memberof ICommandOptionValueImplications
     */
    isCaseSensitive?: boolean;
}
