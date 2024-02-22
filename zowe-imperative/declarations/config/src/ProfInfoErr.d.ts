import { IProfInfoErrParms } from "./doc/IProfInfoErrParms";
import { ImperativeError, IImperativeError } from "../../error";
/**
 * This class is the error exception mechanism for the ProfileInfo API.
 * It is derived from ImperativeError. We use a separate class so that
 * our consumer can check the type of error, and then rely on errorCode
 * values that are unique to ProfInfoErr. ProfInfoErr will always
 * populate the errorCode property. Our consumer can use the errorCode to
 * determine if it should process partial results.
 */
export declare class ProfInfoErr extends ImperativeError {
    /**
     * Unable to retrieve the schema from a URL reference.
     * Currently, the ProfiInfo API does not attempt to retrieve a schema
     * through a URL. A URL does work to provide intellisense in VSCode
     * when editing a config file.
     */
    static readonly CANT_GET_SCHEMA_URL: string;
    /**
     * The specified type of profile location is invalid for the requested operation.
     */
    static readonly INVALID_PROF_LOC_TYPE: string;
    /**
     * Failed to initialize ProfileCredentials and load the credential manager.
     */
    static readonly LOAD_CRED_MGR_FAILED: string;
    /**
     * Failed to load the schema for a specified type of profile.
     */
    static readonly LOAD_SCHEMA_FAILED: string;
    /**
     * A required profile property was not assigned a value.
     */
    static readonly MISSING_REQ_PROP: string;
    /**
     * The ProfileInfo.readProfilesFromDisk function was not called before
     * a function which requires that prerequisite.
     */
    static readonly MUST_READ_FROM_DISK: string;
    /**
     * A specified property that is expected to exist in a specified profile
     * does not exist in that profile.
     */
    static readonly PROP_NOT_IN_PROFILE: string;
    /**
     * A specified property that is expected to exist in a specified profile
     * does not have OS and JSON locations defined.
     */
    static readonly UNKNOWN_PROP_LOCATION: string;
    /**
     * A specified profile was not found (V1)
     */
    static readonly PROF_NOT_FOUND: string;
    /**
     * Construct the ProfInfoErr error object. It adds properties in
     * IProfInfoErrParms to the existing properties of ImperativeError.
     *
     * @param impErrDetails
     *        ImperativeError details and text (stack, messages, etc.)
     *
     * @param profErrParms
     *        ProfInfoErr parms and ImperativeError control parameters.
     */
    constructor(impErrDetails: IImperativeError, profErrParms?: IProfInfoErrParms);
    /**
     * Additional error properties, specific to ProfInfoErr.
     */
    private mItemsInError;
    get itemsInError(): string[];
}
