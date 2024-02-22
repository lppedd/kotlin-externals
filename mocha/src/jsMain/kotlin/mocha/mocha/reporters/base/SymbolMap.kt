package mocha.mocha.reporters.base

import js.objects.Record

/**
 * Default symbol map
 *
 * See https://mochajs.org/api/module-base#.symbols
 */
external interface SymbolMap : Record<String, String> {
  var ok: String
  var err: String
  var dot: String
  var comma: String
  var bang: String
}
