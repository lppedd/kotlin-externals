/// <reference types="node" />
import { HTTP_VERB } from "../types/HTTPVerb";
import { OutgoingHttpHeaders } from "http";
export interface IHTTPSOptions {
    headers: OutgoingHttpHeaders;
    hostname: string;
    method: HTTP_VERB;
    path: string;
    port: string;
    rejectUnauthorized: boolean;
    cert?: string;
    key?: string;
    hash?: string;
}
