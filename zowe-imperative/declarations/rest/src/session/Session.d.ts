/// <reference types="node" />
import { URL } from "url";
import { AbstractSession } from "./AbstractSession";
import { ISession } from "./doc/ISession";
/**
 * Non-abstract session class
 * @export
 * @class Session
 * @extends {AbstractSession}
 */
export declare class Session extends AbstractSession {
    /**
     * Creates an instance of Session.
     * @param {ISession} newSession - contains input for new session
     * @memberof Session
     */
    constructor(newSession: ISession);
    /**
     * Creates an instance of Session from a URL object.
     * @param {URL} url - URL object from the Node.js `url` library
     * @param {boolean} includePath - Specifies whether session base path should be populated. Default value is true.
     * @memberof Session
     */
    static createFromUrl(url: URL, includePath?: boolean): Session;
}
