@file:JsModule("vscode")

package vscode.l10n

import js.objects.Record
import vscode.Uri

/**
 * The bundle of localized strings that have been loaded for the extension.
 * It's undefined if no bundle has been loaded. The bundle is typically not loaded if
 * there was no bundle found or when we are running with the default language.
 */
external val bundle: Record<String, String>?

/**
 * The URI of the localization bundle that has been loaded for the extension.
 * It's undefined if no bundle has been loaded. The bundle is typically not loaded if
 * there was no bundle found or when we are running with the default language.
 */
external val uri: Uri?
