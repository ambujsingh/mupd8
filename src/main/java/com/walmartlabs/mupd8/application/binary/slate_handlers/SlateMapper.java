package com.walmartlabs.mupd8.application.binary.slate_handlers;

import com.walmartlabs.mupd8.application.binary.Performer;
import com.walmartlabs.mupd8.application.binary.slate_handlers.SlatePerformerUtilities;

public interface SlateMapper extends Performer {
    public void map(SlatePerformerUtilities submitter, String stream,
            byte[] key, byte[] event);
}
