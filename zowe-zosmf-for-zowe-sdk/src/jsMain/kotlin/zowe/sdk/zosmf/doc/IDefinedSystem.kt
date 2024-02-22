package zowe.sdk.zosmf.doc

/**
 * The Z/OSMF object returned for every defined system.
 */
external interface IDefinedSystem {
  /**
   * Unique name assigned to the system definition.
   */
  var systemNickName: String?

  /**
   * Comma-separated list of the groups to which the system is assigned.
   */
  var groupNames: String?

  /**
   * Serial number of the CPC.
   */
  var cpcSerial: String?

  /**
   * Version of z/OS
   */
  var zosVR: String?

  /**
   * Name specified for the system on the SYSNAME parameter in the IEASYSxx parmlib member.
   */
  var systemName: String?

  /**
   * Type for the primary job entry subsystem running on the system. The type is either JES2 or JES3.
   */
  var jesType: String?

  /**
   * Name of the sysplex where the z/OS system is a member.
   */
  var sysplexName: String?

  /**
   * JES2 multi-access spool (MAS) member name or JES3 complex member name
   */
  var jesMemberName: String?

  /**
   * Name of the HTTP proxy definition that specifies the settings required to access the system through an HTTP or SOCKS proxy server.
   */
  var httpProxyName: String?

  /**
   * Name of the server definition that specifies the settings required to access the FTP or SFTP server that is running on the system.
   */
  var ftpDestinationName: String?

  /**
   * URL used to access the z/OSMF instance that resides in the same sysplex as the system identified by the systemName attribute.
   */
  var url: String?

  /**
   * Name specified for the central processor complex (CPC) at the support element (SE) of that processor complex.
   */
  var cpcName: String?
}
