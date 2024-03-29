import { IProgressBarParms } from "../../parms/IProgressBarParms";
/**
 * Progress bar APIs for the command handler. Use these methods to start and end progress bars. Only one bar can be
 * active at any given time. Progress bars are displayed at the users terminal/console (indicates/updates with
 * progress) and are NOT shown
 * @export
 * @interface IHandlerProgressApi
 */
export interface IHandlerProgressApi {
    /**
     * Start a progress bar - displays on the users terminal. Only one progress bar can be active at any given time.
     * @param {IProgressBarParms} params - See the interface for details.
     * @memberof IHandlerProgressApi
     */
    startBar(params: IProgressBarParms): void;
    /**
     * Ends an outstanding progress bar (does nothing if no progress bars have been started).
     * @memberof IHandlerProgressApi
     */
    endBar(): void;
}
