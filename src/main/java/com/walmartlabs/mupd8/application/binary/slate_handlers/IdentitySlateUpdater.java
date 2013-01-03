package com.walmartlabs.mupd8.application.binary.slate_handlers;

import java.nio.charset.Charset;

import org.json.simple.JSONObject;

public class IdentitySlateUpdater implements SlateUpdater {
    private final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Slate toSlate(byte[] bytes) {
        return new IdentitySlate(bytes);
    }

    @Override
    public void update(SlatePerformerUtilities submitter, String stream, byte[] key,
            byte[] event, Slate slate) {
        // TODO Auto-generated method stub

    }

    @Override
    public Slate getDefaultSlate() {
        JSONObject jsonObject = new JSONObject();
        return new IdentitySlate(jsonObject.toJSONString().getBytes(UTF8));
    }

}
