package vscode

import kotlin.ts.Union

/**
 * Represents theme specific rendering styles for [ThemableDecorationRenderOptions.before] and
 * [ThemableDecorationRenderOptions.after] the content of text decorations.
 */
external interface ThemableDecorationAttachmentRenderOptions {
  /**
   * Defines a text content that is shown in the attachment. Either an icon or a text can be shown, but not both.
   */
  var contentText: String?

  /**
   * An **absolute path** or an URI to an image to be rendered in the attachment. Either an icon
   * or a text can be shown, but not both.
   */
  var contentIconPath: Union<String, Uri>? // string | Uri

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var border: String?

  /**
   * CSS styling property that will be applied to text enclosed by a decoration.
   */
  var borderColor: Union<String, ThemeColor>? // string | ThemeColor

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var fontStyle: String?

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var fontWeight: String?

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var textDecoration: String?

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var color: Union<String, ThemeColor>? // string | ThemeColor

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var backgroundColor: Union<String, ThemeColor>? // string | ThemeColor

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var margin: String?

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var width: String?

  /**
   * CSS styling property that will be applied to the decoration attachment.
   */
  var height: String?
}
