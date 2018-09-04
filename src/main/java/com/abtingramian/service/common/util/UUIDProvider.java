package com.abtingramian.service.common.util;

import java.util.UUID;

/**
 * This is a helper class for generating {@link UUID's} which can be injected wherever necessary helping testability.
 */
public class UUIDProvider {

    public UUID randomUUID() {
        return UUID.randomUUID();
    }

}
