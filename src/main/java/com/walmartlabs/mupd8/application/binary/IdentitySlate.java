package com.walmartlabs.mupd8.application.binary;

public class IdentitySlate implements Slate {
    public final byte[] bytes;

    public IdentitySlate(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public byte[] toBytes() {
        return this.bytes;
    }

    @Override
    public int getBytesSize() {
        return 1;
    }

}
