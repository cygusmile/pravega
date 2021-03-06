/**
 * Copyright (c) Dell Inc., or its subsidiaries. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package io.pravega.segmentstore.storage.noop;

import io.pravega.common.util.ConfigBuilder;
import io.pravega.common.util.Property;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StorageExtraConfigTest {

    @Test
    public void testDefault() {
        StorageExtraConfig defaultConfig = StorageExtraConfig.builder().build();
        assertEquals(20, defaultConfig.getStorageWriteNoOpLatencyMillis());
        assertEquals(false, defaultConfig.isStorageNoOpMode());
    }

    @Test
    public void testLatency() {
        ConfigBuilder<StorageExtraConfig> builder = StorageExtraConfig.builder();
        builder.with(Property.named("storageWriteNoOpLatencyMillis"), 50);
        assertEquals(50, builder.build().getStorageWriteNoOpLatencyMillis());
    }

    @Test
    public void testNoOpSwitch() {
        ConfigBuilder<StorageExtraConfig> builder = StorageExtraConfig.builder();
        builder.with(Property.named("storageNoOpMode"), true);
        assertEquals(true, builder.build().isStorageNoOpMode());
    }
}
