/**
 * The Z/OSMF object returned for every defined system.
 * @export
 * @interface IDefinedSystem
 */
export interface IDefinedSystem {
    /**
     * Unique name assigned to the system definition.
     */
    systemNickName?: string;
    /**
     * Comma-separated list of the groups to which the system is assigned.
     */
    groupNames?: string;
    /**
     * Serial number of the CPC.
     */
    cpcSerial?: string;
    /**
     * Version of z/OS
     */
    zosVR?: string;
    /**
     * Name specified for the system on the SYSNAME parameter in the IEASYSxx parmlib member.
     */
    systemName?: string;
    /**
     * Type for the primary job entry subsystem running on the system. The type is either JES2 or JES3.
     */
    jesType?: string;
    /**
     * Name of the sysplex where the z/OS system is a member.
     */
    sysplexName?: string;
    /**
     * JES2 multi-access spool (MAS) member name or JES3 complex member name
     */
    jesMemberName?: string;
    /**
     * Name of the HTTP proxy definition that specifies the settings required to access the system through an HTTP or SOCKS proxy server.
     */
    httpProxyName?: string;
    /**
     * Name of the server definition that specifies the settings required to access the FTP or SFTP server that is running on the system.
     */
    ftpDestinationName?: string;
    /**
     * URL used to access the z/OSMF instance that resides in the same sysplex as the system identified by the systemName attribute.
     */
    url?: string;
    /**
     * Name specified for the central processor complex (CPC) at the support element (SE) of that processor complex.
     */
    cpcName?: string;
}
