/**
 * Interface of spool file.
 * @export
 * @interface ISpoolFile
 */
export interface ISpoolFile {
    /**
     * Identifier for this spool file.
     */
    id: number;
    /**
     * DD name of job spool file
     */
    ddName: string;
    /**
     * The name of the job step during which this spool file was produced
     */
    stepName: string;
    /**
     * If this spool file was produced during a job procedure step, the
     * name of the step will be here
     */
    procName: string;
    /**
     * Content of the spool file
     */
    data: string;
}
