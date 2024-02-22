package mocha.mocha

import seskar.js.JsValue
import seskar.js.JsVirtual

@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface Reporter {
  companion object {
    @JsValue("Base")
    val Base: Reporter

    @JsValue("base")
    val base: Reporter

    @JsValue("Dot")
    val Dot: Reporter

    @JsValue("dot")
    val dot: Reporter

    @JsValue("TAP")
    val TAP: Reporter

    @JsValue("tap")
    val tap: Reporter

    @JsValue("JSON")
    val JSON: Reporter

    @JsValue("json")
    val json: Reporter

    @JsValue("HTML")
    val HTML: Reporter

    @JsValue("html")
    val html: Reporter

    @JsValue("List")
    val List: Reporter

    @JsValue("list")
    val list: Reporter

    @JsValue("Min")
    val Min: Reporter

    @JsValue("min")
    val min: Reporter

    @JsValue("Spec")
    val Spec: Reporter

    @JsValue("spec")
    val spec: Reporter

    @JsValue("Nyan")
    val Nyan: Reporter

    @JsValue("nyan")
    val nyan: Reporter

    @JsValue("XUnit")
    val XUnit: Reporter

    @JsValue("xunit")
    val xunit: Reporter

    @JsValue("Markdown")
    val Markdown: Reporter

    @JsValue("markdown")
    val markdown: Reporter

    @JsValue("Progress")
    val Progress: Reporter

    @JsValue("progress")
    val progress: Reporter

    @JsValue("Landing")
    val Landing: Reporter

    @JsValue("landing")
    val landing: Reporter

    @JsValue("JSONStream")
    val JSONStream: Reporter
  }
}
