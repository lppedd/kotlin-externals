package mocha.mocha

import seskar.js.JsValue

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface Interface {
  companion object {
    @JsValue("bdd")
    var bdd: Interface

    @JsValue("tdd")
    var tdd: Interface

    @JsValue("qunit")
    var qunit: Interface

    @JsValue("exports")
    var exports: Interface
  }
}
