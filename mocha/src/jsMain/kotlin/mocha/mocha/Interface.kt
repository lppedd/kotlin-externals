package mocha.mocha

import seskar.js.JsValue
import seskar.js.JsVirtual

@JsVirtual
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
