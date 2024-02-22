import { IHeaderContent } from "./doc/IHeaderContent";
export declare class Headers {
    static readonly CONTENT_TYPE: string;
    static readonly CONTENT_LENGTH: string;
    static readonly CONTENT_ENCODING: string;
    static readonly CONTENT_ENCODING_TYPES: readonly ["br", "deflate", "gzip"];
    static readonly APPLICATION_JSON: IHeaderContent;
    static readonly TEXT_PLAIN: IHeaderContent;
    static readonly TEXT_PLAIN_UTF8: object;
    static readonly OCTET_STREAM: IHeaderContent;
    static readonly BASIC_AUTHORIZATION: object;
    static readonly COOKIE_AUTHORIZATION: object;
}
export declare type ContentEncoding = typeof Headers.CONTENT_ENCODING_TYPES[number];
