package vscode.test.electron

import seskar.js.JsValue
import seskar.js.JsVirtual

/** Stages of progress while downloading VS Code */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ProgressReportStage {
  companion object {
    /** Initial fetch of the latest version if not explicitly given */
    @JsValue("fetchingVersion")
    val FetchingVersion: ProgressReportStage

    /** Always fired when the version is determined. */
    @JsValue("resolvedVersion")
    val ResolvedVersion: ProgressReportStage

    /** Fired before fetching info about the latest Insiders version, when requesting insiders builds */
    @JsValue("fetchingInsidersMetadata")
    val FetchingInsidersMetadata: ProgressReportStage

    /** Fired if the current Insiders is out of date */
    @JsValue("replacingOldInsiders")
    val ReplacingOldInsiders: ProgressReportStage

    /** Fired when an existing install is found which does not require a download */
    @JsValue("foundMatchingInstall")
    val FoundMatchingInstall: ProgressReportStage

    /** Fired before the URL to the download zip or tarball is looked up */
    @JsValue("resolvingCDNLocation")
    val ResolvingCDNLocation: ProgressReportStage

    /** Fired continuously while a download happens */
    @JsValue("downloading")
    val Downloading: ProgressReportStage

    /** Fired when the command is issued to do a synchronous extraction. May not fire depending on the platform and options. */
    @JsValue("extractingSynchonrously")
    val ExtractingSynchonrously: ProgressReportStage

    /** Fired when the download fails and a retry will be attempted */
    @JsValue("retrying")
    val Retrying: ProgressReportStage

    /** Fired after folder is downloaded and unzipped */
    @JsValue("newInstallComplete")
    val NewInstallComplete: ProgressReportStage
  }
}
