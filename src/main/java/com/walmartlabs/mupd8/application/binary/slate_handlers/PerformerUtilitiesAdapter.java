package com.walmartlabs.mupd8.application.binary.slate_handlers;

import com.walmartlabs.mupd8.application.SlateSizeException;
import com.walmartlabs.mupd8.application.binary.PerformerUtilities;

public class PerformerUtilitiesAdapter implements PerformerUtilities {

    private final SlatePerformerUtilities slatePerformerUtilities;

    public PerformerUtilitiesAdapter(
            SlatePerformerUtilities slatePerformerUtilities) {
        this.slatePerformerUtilities = slatePerformerUtilities;
    }

    @Override
    public void publish(String stream, byte[] key, byte[] event)
            throws Exception {
        slatePerformerUtilities.publish(stream, key, event);
    }

    @Override
    public void replaceSlate(byte[] slate) throws SlateSizeException {
        slatePerformerUtilities.replaceSlate(new IdentitySlate(slate));
    }

}
