@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.rest

import zowe.imperative.error.doc.IImperativeError
import zowe.imperative.logger.Logger
import zowe.imperative.rest.client.RestClient

/**
 * Wrapper for invoke z/OSMF API through the RestClient to perform common error
 * handling and checking and resolve promises according to generic types
 */
external class ZosmfRestClient : RestClient {
  /**
   * Use the Brightside logger instead of the imperative logger
   */
  override val log: Logger

  /**
   * Append z/OSMF specific headers to the callers headers for cases
   * where a header is common to every request.
   *
   * @param headers current header array
   */
  override fun appendHeaders(headers: Array<Any?>?): Array<Any?>

  /**
   * Process an error encountered in the rest client
   *
   * @param error the original error automatically built by the abstract rest client
   * @return the processed error with details added
   */
  override fun processError(error: IImperativeError): IImperativeError
}
