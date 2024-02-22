/**
 * Example command definition - used on command definitions to present examples for the user in the help.
 */
export interface ICommandExampleDefinition {
    /**
     * Options for the example command - should be copy/paste-able - besides variable data - i.e.  user name
     */
    options: string;
    /**
     * The example description - what does it do?
     */
    description: string;
    /**
     * Text to prepend to the command and options in the example.
     * Useful for commands that read stdin
     * e.g. "echo hello |"
     */
    prefix?: string;
}
