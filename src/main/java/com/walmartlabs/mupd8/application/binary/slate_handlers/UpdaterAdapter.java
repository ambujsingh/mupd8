package com.walmartlabs.mupd8.application.binary.slate_handlers;

import java.nio.charset.Charset;

import org.json.simple.JSONObject;

import com.walmartlabs.mupd8.application.binary.Updater;

public class UpdaterAdapter implements SlateUpdater {
    private final Charset UTF8 = Charset.forName("UTF-8");

    private final Updater updater;

    public UpdaterAdapter(Updater updater) {
        this.updater = updater;
    }

    @Override
    public String getName() {
        return updater.getName();
    }

    @Override
    public Slate toSlate(byte[] bytes) {
        return new IdentitySlate(bytes);
    }

    @Override
    public void update(SlatePerformerUtilities submitter, String stream,
            byte[] key, byte[] event, Slate slate) {
        updater.update(new PerformerUtilitiesAdapter(submitter), stream, key,
                event, slate.toBytes());
    }

    @Override
    public Slate getDefaultSlate() {
        JSONObject jsonObject = new JSONObject();
        return new IdentitySlate(jsonObject.toJSONString().getBytes(UTF8));
    }

}
