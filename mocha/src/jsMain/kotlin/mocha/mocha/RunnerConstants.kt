package mocha.mocha

external interface RunnerConstants {
  @JsString("hook")
  val EVENT_HOOK_BEGIN: String

  @JsString("hook end")
  val EVENT_HOOK_END: String

  @JsString("start")
  val EVENT_RUN_BEGIN: String

  @JsString("waiting")
  val EVENT_DELAY_BEGIN: String

  @JsString("ready")
  val EVENT_DELAY_END: String

  @JsString("end")
  val EVENT_RUN_END: String

  @JsString("suite")
  val EVENT_SUITE_BEGIN: String

  @JsString("suite end")
  val EVENT_SUITE_END: String

  @JsString("test")
  val EVENT_TEST_BEGIN: String

  @JsString("test end")
  val EVENT_TEST_END: String

  @JsString("fail")
  val EVENT_TEST_FAIL: String

  @JsString("pass")
  val EVENT_TEST_PASS: String

  @JsString("pending")
  val EVENT_TEST_PENDING: String

  @JsString("retry")
  val EVENT_TEST_RETRY: String

  @JsString("idle")
  val STATE_IDLE: String

  @JsString("running")
  val STATE_RUNNING: String

  @JsString("stopped")
  val STATE_STOPPED: String
}
