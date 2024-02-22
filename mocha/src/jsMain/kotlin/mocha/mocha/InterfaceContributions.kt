package mocha.mocha

/**
 * Third-party declarations that want to add new entries to the `Interface` union can
 * contribute names here.
 */
external interface InterfaceContributions {
  var bdd: Nothing
  var tdd: Nothing
  var qunit: Nothing
  var exports: Nothing
}
