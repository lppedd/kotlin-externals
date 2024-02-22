package zowe.imperative.imperative.plugins.doc

import zowe.imperative.imperative.plugins.utilities.IssueSeverity

external interface IPluginIssue {
  /**
   * Each entry is the text of the issue and the severity of the issue.
   */
  var issueText: String
  var issueSev: IssueSeverity
}
