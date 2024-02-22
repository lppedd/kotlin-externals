/**
 * The possible job status strings (as specified by the z/OSMF documentation). Used in the Jobs APIs for monitoring
 * jobstatus, etc.
 * @type {JOB_STATUS} (string)
 */
export declare type JOB_STATUS = "ACTIVE" | "OUTPUT" | "INPUT";
export declare const JOB_STATUS: {
    ACTIVE: JOB_STATUS;
    OUTPUT: JOB_STATUS;
    INPUT: JOB_STATUS;
};
export declare const JOB_STATUS_ORDER: JOB_STATUS[];
