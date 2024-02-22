package mocha.mocha

external interface SuiteConstants {
  @JsString("post-require")
  val EVENT_FILE_POST_REQUIRE: String

  @JsString("pre-require")
  val EVENT_FILE_PRE_REQUIRE: String

  @JsString("require")
  val EVENT_FILE_REQUIRE: String

  @JsString("run")
  val EVENT_ROOT_SUITE_RUN: String

  @JsString("afterAll")
  val HOOK_TYPE_AFTER_ALL: String

  @JsString("afterEach")
  val HOOK_TYPE_AFTER_EACH: String

  @JsString("beforeAll")
  val HOOK_TYPE_BEFORE_ALL: String

  @JsString("beforeEach")
  val HOOK_TYPE_BEFORE_EACH: String

  @JsString("afterAll")
  val EVENT_SUITE_ADD_HOOK_AFTER_ALL: String

  @JsString("afterEach")
  val EVENT_SUITE_ADD_HOOK_AFTER_EACH: String

  @JsString("beforeAll")
  val EVENT_SUITE_ADD_HOOK_BEFORE_ALL: String

  @JsString("beforeEach")
  val EVENT_SUITE_ADD_HOOK_BEFORE_EACH: String

  @JsString("suite")
  val EVENT_SUITE_ADD_SUITE: String

  @JsString("test")
  val EVENT_SUITE_ADD_TEST: String
}
