/**
 * Common z/OS Consoles API Parameters.
 * @export
 * @interface IConsoleParms
 */
export interface IConsoleParms {
    /**
     * The z/OS emcs console to direct the commands.
     * @type {string}
     * @memberof IConsoleParms
     */
    consoleName?: string;
    /**
     * The z/OSMF Console API returns '\r' or '\r\n' where line-breaks. Can attempt to replace these
     * sequences with '\n', but there may be cases where that is not preferable. Specify false to prevent processing.
     * @type {string}
     * @memberof IConsoleParms
     */
    processResponses?: boolean;
}
