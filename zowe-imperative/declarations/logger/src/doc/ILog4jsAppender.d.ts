import { ILog4jsLayout } from "./ILog4jsLayout";
export interface ILog4jsAppender {
    "type": string;
    "layout": ILog4jsLayout;
    [key: string]: any;
}
