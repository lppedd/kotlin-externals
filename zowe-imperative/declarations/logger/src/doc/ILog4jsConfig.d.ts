import { ILog4jsAppender } from "./ILog4jsAppender";
export interface ILog4jsConfig {
    "appenders": {
        [key: string]: ILog4jsAppender;
    };
    "categories": {
        [key: string]: {
            appenders: string[];
            level: string;
        };
    };
}
