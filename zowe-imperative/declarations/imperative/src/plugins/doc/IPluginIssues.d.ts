import { IssueSeverity } from "../utilities/PluginIssues";
/**
 * Structure for the list of plugin issues.
 */
export interface IPluginIssues {
    /**
     * The plugin name is the key into a hash of validation issues.
     */
    [pluginName: string]: {
        issueList: IPluginIssue[];
    };
}
export interface IPluginIssue {
    /**
     * Each entry is the text of the issue and the severity of the issue.
     */
    issueText: string;
    issueSev: IssueSeverity;
}
