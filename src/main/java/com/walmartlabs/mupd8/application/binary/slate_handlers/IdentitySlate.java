package com.walmartlabs.mupd8.application.binary.slate_handlers;

public class IdentitySlate implements Slate {

    public final byte[] bytes;

    public IdentitySlate(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public byte[] toBytes() {
        return bytes;
    }

    @Override
    public int getBytesSize() {
        return bytes.length;
    }

}
