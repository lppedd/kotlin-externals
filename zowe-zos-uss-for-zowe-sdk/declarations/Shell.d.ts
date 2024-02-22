import { SshSession } from "./SshSession";
export declare class Shell {
    static readonly startCmdFlag = "@@START OF COMMAND@@";
    static readonly connRefusedFlag = "ECONNREFUSED";
    static readonly expiredPasswordFlag = "FOTS1668";
    static executeSsh(session: SshSession, command: string, stdoutHandler: (data: string) => void): Promise<any>;
    static executeSshCwd(session: SshSession, command: string, cwd: string, stdoutHandler: (data: string) => void): Promise<any>;
    private static authenticationHandler;
}
/**
 * @deprecated Use `Shell.startCmdFlag` instead.
 */
export declare const startCmdFlag = "@@START OF COMMAND@@";
