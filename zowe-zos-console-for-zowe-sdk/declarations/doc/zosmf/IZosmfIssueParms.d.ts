/**
 * The z/OSMF console API parameters. See the z/OSMF REST API documentation for full details.
 * @export
 * @interface IZosmfIssueParms
 */
export interface IZosmfIssueParms {
    /**
     * The z/OS console command to issue.
     * @type {string]
     * @memberof IZosmfIssueParms
     */
    cmd: string;
    /**
     * The solicited keyword to look for
     * @type {string}
     * @memberof IZosmfIssueParms
     */
    "sol-key"?: string;
    /**
     * The system in the sysplex to route the command.
     * @type {string}
     * @memberof IZosmfIssueParms
     */
    system?: string;
    /**
     * The method of issuing the command.
     * @type {string}
     * @memberof IZosmfIssueParms
     */
    async?: string;
}
