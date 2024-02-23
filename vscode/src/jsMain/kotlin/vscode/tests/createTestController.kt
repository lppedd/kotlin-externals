@file:JsModule("vscode")
@file:JsQualifier("tests")

package vscode.tests

import vscode.TestController

/**
 * Creates a new test controller.
 *
 * @param id Identifier for the controller, must be globally unique.
 * @param label A human-readable label for the controller.
 * @return An instance of the [TestController].
 */
external fun createTestController(
  id: String,
  label: String,
): TestController
