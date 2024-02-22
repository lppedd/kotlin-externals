import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * Handler to report a user's wroking environment.
 *
 * We detect and report information from the user environment, including
 * installed 3rd party prerrequisites. We report those findings.
 *
 * We also maintain a set of known problem conditions (like broken NPM
 * versions which happen way too often). We use that data to report the
 * probelem to the customer and any known workaround.
 *
 * @export
 */
export default class ReportEnvHandler implements ICommandHandler {
    process(cmdParams: IHandlerParameters): Promise<void>;
    /**
     * Display a report of all items of interest and any problems detected.
     *
     * @param consoleApi Console response object to which we will write messages.
     */
    private displayEnvReport;
    /**
     * Display a specific item and any problems detected.
     *
     * @param consoleApi Console response object to which we will write messages.
     */
    private displayEnvItem;
}
