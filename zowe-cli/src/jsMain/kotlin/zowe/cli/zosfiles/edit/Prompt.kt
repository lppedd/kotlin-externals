@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.edit

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * enum of prompts to be used as input to [EditUtilities.promptUser] during the file editing process
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface Prompt {
  companion object {
    @JsIntValue(0)
    val useStash: Prompt

    @JsIntValue(1)
    val viewDiff: Prompt

    @JsIntValue(2)
    val overwriteRemote: Prompt

    @JsIntValue(3)
    val viewUpdatedRemote: Prompt

    @JsIntValue(4)
    val continueToUpload: Prompt
  }
}
