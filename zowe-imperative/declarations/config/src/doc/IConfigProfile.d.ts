export interface IConfigProfile {
    properties: {
        [key: string]: any;
    };
    type?: string;
    profiles?: {
        [key: string]: IConfigProfile;
    };
    secure?: string[];
}
