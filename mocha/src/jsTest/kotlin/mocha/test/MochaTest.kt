package mocha.test

import mocha.suite
import mocha.test
import kotlin.test.Ignore
import kotlin.test.Test

class MochaTest {
  @Test
  @Ignore
  fun registerSuite() {
    val x = suite
    val s = x("Test Suite 1") {
      test("test 1") {
        print("ok!")
      }
    }

    s.run()
  }
}
