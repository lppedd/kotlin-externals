package zowe.cli.zosfiles.strings

external interface CompareActions {
  var DATA_SET: CompareActionsDs
  var LOCAL_FILE_DATA_SET: CompareActionsLocalFileDs
  var USS_FILE: CompareActionsUss
  var LOCAL_FILE_USS_FILE: CompareActionsLocalFileUss
  var SPOOL_DD: CompareActionsSpool
  var LOCAL_FILE_SPOOL_DD: CompareActionsLocalFileSpool
}
