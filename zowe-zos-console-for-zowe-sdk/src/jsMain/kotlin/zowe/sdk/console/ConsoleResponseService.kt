@file:JsModule("@zowe/zos-console-for-zowe-sdk")

package zowe.sdk.console

import zowe.imperative.error.ImperativeError
import zowe.sdk.console.doc.IConsoleResponse
import zowe.sdk.console.doc.zosmf.IZosmfIssueResponse

/**
 * Class contains helper methods for console response commands response processing
 */
external class ConsoleResponseService {
  companion object {
    /**
     * Populate the console response with the details returned from the z/OSMF console API.
     *
     * Method takes two parameters: response from z/OSMF command and response to be populated.
     *
     * Method adds response to a collection of z/OSMF responses, mark response as "succeeded" (response.success = true)
     * and populate other fields of response with values from z/OSMF sresponse.
     *
     * @param zosmfResponse zosmf console response, see [IZosmfIssueResponse]
     * @param response console response to be populated, see [IConsoleResponse]
     * @param processResponses is set to true, append command response string to the console API response
     * @return populated console response, see [IConsoleResponse]
     */
    fun populate(
      zosmfResponse: IZosmfIssueResponse,
      response: IConsoleResponse,
      processResponses: Boolean = definedExternally,
    ): IConsoleResponse

    /**
     * Populate the console response with the Imperative error message.
     * Method takes two parameters: Imperative error and response to be populated.
     * Method save error message info failureResponse field and mark console response as "failed" (response.success = false)
     *
     * @param error Imperative error, see [ImperativeError]
     * @param response console response to be populated, see [IConsoleResponse]
     * @return populated console response, see [IConsoleResponse]
     */
    fun populateError(
      error: ImperativeError,
      response: IConsoleResponse,
    ): IConsoleResponse

    /**
     * Provides empty console response
     */
    fun getEmptyConsoleResponse(): IConsoleResponse

    /**
     * Determines whether last z/OSMF response has empty content or not
     *
     * @param response command response
     * @return true if last z/OSMF response has empty "cmd-response", false otherwise
     */
    fun isLastZosmfResponseEmpty(response: IConsoleResponse): Boolean
  }
}
