package zowe.sdk.console.doc

/**
 * Interface for Collect command parameters
 */
external interface ICollectParms : IConsoleParms {
  /**
   * The command response key for follow up messages API call.
   */
  var commandResponseKey: String

  /**
   * Indicates that you would like to wait 'n' number of seconds before issues a follow-up request for
   * additional messages (assuming a command response key is present). Will wait the specified amount of
   * time before each follow-up request is issued.
   */
  var waitToCollect: Int?

  /**
   * The default is 1, however you may specify the number of follow-up attempts. This can be useful when multiple
   * multi-line WTO command responses are issued in direct response to a command. zOS consoles do NOT have any
   * awareness of how many multi-line WTO messages will be issued in response to a command. Use this parameter
   * in conjunction with waitToCollect to "fine-tune" your requests. The follow-up counter is decremented when
   * no command response (response text) is present in the request. Meaning, if a command is issued, follow-up
   * attempts is 1, and the first 2 requests provided command response data, it will issue 1 final
   * follow up request before returning (resulting in 3 total API calls).
   */
  var followUpAttempts: Int?
}
