/// <reference types="node" />
/// <reference types="node" />
import { Duplex } from "stream";
export declare class BufferBuilder extends Duplex {
    private chunks;
    constructor();
    _write(chunk: any, _encoding: BufferEncoding, callback: (error?: Error) => void): void;
    _read(_size: number): void;
}
