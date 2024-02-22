@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

import js.errors.JsError
import js.promise.Promise
import node.buffer.Buffer
import node.stream.Readable
import node.stream.Writable
import zowe.imperative.operations.doc.ITaskWithStatus
import zowe.imperative.rest.client.doc.IOptionsFullResponse
import zowe.imperative.rest.client.doc.IRestClientResponse
import zowe.imperative.rest.session.AbstractSession

/**
 * Class to handle http(s) requests, build headers, collect data, report status codes, and header
 * responses and passes control to session object for maintaining connection information (tokens,
 * checking for timeout, etc...)
 */
open external class RestClient : AbstractRestClient {
  companion object {
    /**
     * Wrap get for common error handling and supporting generic JSON types
     *
     * @param session representing connection to this api
     * @param resource the API URI that we are targeting
     * @param reqHeaders headers for the http(s) request
     * @return object on promise
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun <T : Any> getExpectJSON(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
    ): Promise<T>

    /**
     * Wrap put for common error handling and supporting generic JSON types
     *
     * @param session representing connection to this api
     * @param resource the API URI that we are targeting
     * @param reqHeaders headers for the http(s) request
     * @param payload data to write on the http(s) request
     * @return object on promise
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun <T : Any> putExpectJSON(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      payload: Any?,
    ): Promise<T>

    /**
     * Wrap post for common error handling and supporting generic JSON types
     *
     * @param session representing connection to this api
     * @param resource the API URI that we are targeting
     * @param reqHeaders headers for the http(s) request
     * @param payload data to write on the http(s) request
     * @return object on promise
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun <T : Any> postExpectJSON(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
      payload: Any? = definedExternally,
    ): Promise<T>

    /**
     * Wrap post for common error handling and supporting generic JSON types
     *
     * @param session representing connection to this api
     * @param resource the API URI that we are targeting
     * @param reqHeaders headers for the http(s) request
     * @return object on promise
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun <T : Any> deleteExpectJSON(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
    ): Promise<T>

    /**
     * REST HTTP GET operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun getExpectBuffer(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
    ): Promise<Buffer>

    /**
     * REST HTTP PUT operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param data payload data
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun putExpectBuffer(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      data: Any?,
    ): Promise<Buffer>

    /**
     * REST HTTP POST operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param data payload data
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun postExpectBuffer(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
      data: Any? = definedExternally,
    ): Promise<Buffer>

    /**
     * REST HTTP DELETE operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun deleteExpectBuffer(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
    ): Promise<Buffer>

    /**
     * REST HTTP GET operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun getExpectString(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP PUT operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param data payload data
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun putExpectString(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      data: Any?,
    ): Promise<String>

    /**
     * REST HTTP POST operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param data payload data
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun postExpectString(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
      data: Any? = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP DELETE operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @return response body content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun deleteExpectString(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?> = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP GET operation - streaming the response to a writable stream
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param responseStream the stream to which the response data will be written
     * @param normalizeResponseNewLines streaming only - true if you want newlines to be \r\n on
     *   windows when receiving data from the server to responseStream. Don't set this for binary
     *   responses
     * @param task task used to update the user on the progress of their request
     * @return empty string - data is not buffered for this request
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun getStreamed(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      responseStream: Writable,
      normalizeResponseNewLines: Boolean = definedExternally,
      task: ITaskWithStatus = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP PUT operation with streamed response and request
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param responseStream stream to which the response data will be written
     * @param requestStream stream from which payload data will be read
     * @param normalizeResponseNewLines streaming only - true if you want newlines to be \r\n on
     *   windows when receiving data from the server to responseStream. Don't set this for binary
     *   responses
     * @param normalizeRequestNewLines streaming only - true if you want \r\n to be replaced with
     *   \n when sending data to the server from requestStream. Don't set this for binary requests
     * @param task task used to update the user on the progress of their request
     * @return empty string - data is not buffered for streamed requests
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun putStreamed(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      responseStream: Writable,
      requestStream: Readable,
      normalizeResponseNewLines: Boolean = definedExternally,
      normalizeRequestNewLines: Boolean = definedExternally,
      task: ITaskWithStatus = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP PUT operation with only streamed request, buffers response data and returns it
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param requestStream stream from which payload data will be read
     * @param normalizeRequestNewLines streaming only - true if you want \r\n to be replaced with
     *   \n when sending data to the server from requestStream. Don't set this for binary requests
     * @param task task used to update the user on the progress of their request
     * @return string of the response
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun putStreamedRequestOnly(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      requestStream: Readable,
      normalizeRequestNewLines: Boolean = definedExternally,
      task: ITaskWithStatus = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP POST operation streaming both the request and the response
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param responseStream stream to which the response data will be written
     * @param requestStream stream from which payload data will be read
     * @param normalizeResponseNewLines streaming only - true if you want newlines to be \r\n on
     *   windows when receiving data from the server to responseStream. Don't set this for binary
     *   responses
     * @param normalizeRequestNewLines streaming only - true if you want \r\n to be replaced with
     *   \n when sending data to the server from requestStream. Don't set this for binary requests
     * @param task task used to update the user on the progress of their request
     * @return empty string - data is not buffered for this request
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun postStreamed(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      responseStream: Writable,
      requestStream: Readable,
      normalizeResponseNewLines: Boolean = definedExternally,
      normalizeRequestNewLines: Boolean = definedExternally,
      task: ITaskWithStatus = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP POST operation, streaming only the request and not the response
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param requestStream stream from which payload data will be read
     * @param normalizeRequestNewLines streaming only - true if you want \r\n to be replaced with
     *   \n when sending data to the server from requestStream. Don't set this for binary requests
     * @param task task used to update the user on the progress of their request
     * @return string of the response
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun postStreamedRequestOnly(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      requestStream: Readable,
      normalizeRequestNewLines: Boolean = definedExternally,
      task: ITaskWithStatus = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP DELETE operation
     *
     * @param session representing connection to this api
     * @param resource URI for which this request should go against
     * @param reqHeaders headers to include in the REST request
     * @param responseStream stream to which the response data will be written
     * @param task task used to update the user on the progress of their request
     * @param normalizeResponseNewLines streaming only - true if you want newlines to be \r\n on
     *   windows when receiving data from the server to responseStream. Don't set this for binary
     *   responses
     * @return empty string - data is not buffered for streamed requests
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun deleteStreamed(
      session: AbstractSession,
      resource: String,
      reqHeaders: Array<Any?>,
      responseStream: Writable,
      normalizeResponseNewLines: Boolean = definedExternally,
      task: ITaskWithStatus = definedExternally,
    ): Promise<String>

    /**
     * REST HTTP GET operation returning full HTTP(S) Response
     *
     * @param session representing connection to this api
     * @param options URI for which this request should go against
     * @return full response or filtered based on provided params
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun getExpectFullResponse(
      session: AbstractSession,
      options: IOptionsFullResponse,
    ): Promise<IRestClientResponse>

    /**
     * REST HTTP PUT operation returning full HTTP(S) Response
     *
     * @param session representing connection to this api
     * @param options list of parameters
     * @return response content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun putExpectFullResponse(
      session: AbstractSession,
      options: IOptionsFullResponse,
    ): Promise<IRestClientResponse>

    /**
     * REST HTTP delete operation returning full HTTP(S) Response
     *
     * @param session representing connection to this api
     * @param options list of parameters
     * @return response content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun deleteExpectFullResponse(
      session: AbstractSession,
      options: IOptionsFullResponse,
    ): Promise<IRestClientResponse>

    /**
     * REST HTTP post operation returning full HTTP(S) Response
     *
     * @param session representing connection to this api
     * @param options list of parameters
     * @return response content from http(s) call
     * @throws JsError the request gets a status code outside the 200 range or other connection
     *   problems occur (e.g. connection refused)
     */
    fun postExpectFullResponse(
      session: AbstractSession,
      options: IOptionsFullResponse,
    ): Promise<IRestClientResponse>

    /**
     * Helper method to return an indicator for whether a URI contains a query string.
     *
     * @param query URI
     * @return true if query is contained within URI
     */
    fun hasQueryString(query: String): Boolean
  }
}
