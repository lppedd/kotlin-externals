/// <reference types="node" />
import * as fs from 'fs-extra';
export declare class Unpack {
    static unpack(input: fs.PathLike, target: fs.PathLike): Promise<void>;
}
