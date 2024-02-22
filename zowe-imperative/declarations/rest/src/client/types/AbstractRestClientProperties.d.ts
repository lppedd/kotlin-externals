/**
 * String type definition for properties of abstractRestClient that has a getter set.
 * This can be safely used in a getter call as a variable for the abstractRestClient object.
 * @export
 * @typedef CLIENT_PROPERTY
 */
export declare type CLIENT_PROPERTY = "requestSuccess" | "requestFailure" | "data" | "dataString" | "response" | "session" | "log";
export declare const CLIENT_PROPERTY: {
    requestSuccess: CLIENT_PROPERTY;
    requestFailure: CLIENT_PROPERTY;
    data: CLIENT_PROPERTY;
    dataString: CLIENT_PROPERTY;
    response: CLIENT_PROPERTY;
    session: CLIENT_PROPERTY;
    log: CLIENT_PROPERTY;
};
