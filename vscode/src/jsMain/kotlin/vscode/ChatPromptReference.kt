package vscode

import js.array.JsTuple2
import kotlin.ts.Union4

/**
 * A reference to a value that the user added to their chat request.
 */
external interface ChatPromptReference {
  /**
   * A unique identifier for this kind of reference.
   */
  val id: String

  /**
   * The start and end index of the reference in the [ChatRequest.prompt].
   * When undefined, the reference was not part of the prompt text.
   *
   * *Note* that the indices take the leading `#`-character into account which means they can
   * be used to modify the prompt as-is.
   */
  val range: JsTuple2<Int, Int>?

  /**
   * A description of this value that could be used in an LLM prompt.
   */
  val modelDescription: String?

  /**
   * The value of this reference.
   * The `string | Uri | Location` types are used today, but this could expand in the future.
   */
  val value: Union4<String, Uri, Location, Any? /* unknown */>
}
