/**
 * Input to the help generator factory - normally built by imperative and passed to the command definition
 * infrastructure - Each instance of the help generator is created with the command being issued (and the
 * full command tree).
 * @export
 * @interface IHelpGeneratorFactoryParms
 */
export interface IHelpGeneratorFactoryParms {
    /**
     * The root command for your CLI (i.e. the command that identifies your CLI/binary)
     * @type {string}
     * @memberof IHelpGeneratorFactoryParms
     */
    rootCommandName: string;
    /**
     * Produce a markdown file (rather than the normal help text output). Useful for providing CLI documentation
     * @type {boolean}
     * @memberof IHelpGeneratorFactoryParms
     */
    produceMarkdown?: boolean;
    /**
     * The primary highlight color - for the chalk package (coloring of console output)
     * @type {string}
     * @memberof IHelpGeneratorFactoryParms
     */
    primaryHighlightColor?: string;
}
