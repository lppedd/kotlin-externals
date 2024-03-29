/**
 * Option interface to construct response from daemon client
 * @export
 * @interface IDaemonResponse
 */
export interface IDaemonResponse {
    /**
     * List of CLI arguments received from the daemon client.
     */
    argv?: string[];
    /**
     * Current working directory received from the daemon client.
     */
    cwd?: string;
    /**
     * Environment variables with CLI prefix received from the daemon client.
     */
    env?: Record<string, string>;
    /**
     * Length of stdin data received from the daemon client.
     * The client sends binary stdin data as a multipart request, that contains
     * a JSON body with `stdinLength` defined, followed by the raw binary data.
     */
    stdinLength?: number;
    /**
     * Stdin text received from the daemon client.
     * This is used for plain text stdin data like replies to prompts.
     */
    stdin?: string;
    /**
     * The user that initiated the request from the daemon client.
     */
    user?: string;
}
