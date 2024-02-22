@file:JsModule("@zowe/imperative")

package zowe.imperative.config

import zowe.imperative.config.doc.IProfInfoErrParms
import zowe.imperative.error.ImperativeError
import zowe.imperative.error.doc.IImperativeError

/**
 * This class is the error exception mechanism for the ProfileInfo API. It is derived from
 * ImperativeError. We use a separate class so that our consumer can check the type of error, and
 * then rely on errorCode values that are unique to ProfInfoErr. ProfInfoErr will always populate
 * the errorCode property. Our consumer can use the errorCode to determine if it should process
 * partial results.
 */
external class ProfInfoErr : ImperativeError {
  /**
   * Construct the ProfInfoErr error object. It adds properties in IProfInfoErrParms to the existing
   * properties of ImperativeError.
   *
   * @param impErrDetails ImperativeError details and text (stack, messages, etc.)
   * @param profErrParms ProfInfoErr parms and ImperativeError control parameters.
   */
  constructor(impErrDetails: IImperativeError, profErrParms: IProfInfoErrParms = definedExternally)

  val itemsInError: Array<String>

  companion object {
    /**
     * Unable to retrieve the schema from a URL reference. Currently, the ProfiInfo API does not
     * attempt to retrieve a schema through a URL. A URL does work to provide intellisense in VSCode
     * when editing a config file.
     */
    val CANT_GET_SCHEMA_URL: String

    /**
     * The specified type of profile location is invalid for the requested operation.
     */
    val INVALID_PROF_LOC_TYPE: String

    /**
     * Failed to initialize ProfileCredentials and load the credential manager.
     */
    val LOAD_CRED_MGR_FAILED: String

    /**
     * Failed to load the schema for a specified type of profile.
     */
    val LOAD_SCHEMA_FAILED: String

    /**
     * A required profile property was not assigned a value.
     */
    val MISSING_REQ_PROP: String

    /**
     * The ProfileInfo.readProfilesFromDisk function was not called before a function which requires
     * that prerequisite.
     */
    val MUST_READ_FROM_DISK: String

    /**
     * A specified property that is expected to exist in a specified profile does not exist in that
     * profile.
     */
    val PROP_NOT_IN_PROFILE: String

    /**
     * A specified property that is expected to exist in a specified profile does not have OS and
     * JSON locations defined.
     */
    val UNKNOWN_PROP_LOCATION: String

    /**
     * A specified profile was not found (V1)
     */
    val PROF_NOT_FOUND: String
  }
}
