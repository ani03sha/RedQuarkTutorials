package org.redquark.tutorials.design.caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LFUCacheTest {

    private LFUCache<Integer, String> lfuCache;

    @BeforeEach
    public void setUp() {
        this.lfuCache = new LFUCache<>(5);
        this.lfuCache.set(1, "One");
        this.lfuCache.set(2, "Two");
        this.lfuCache.set(3, "Three");
    }

    @Test
    public void testHas() {
        assertTrue(lfuCache.has(3));
        assertTrue(lfuCache.has(1));
        assertFalse(lfuCache.has(4));
        assertTrue(lfuCache.has(2));
        assertFalse(lfuCache.has(5));
    }

    @Test
    public void testGet() {
        assertEquals("One", lfuCache.get(1));
        assertEquals("Two", lfuCache.get(2));
        assertEquals("Three", lfuCache.get(3));
        assertNull(lfuCache.get(4));
        assertNull(lfuCache.get(5));
    }

    @Test
    public void testSet() {
        lfuCache.set(4, "Four");
        lfuCache.set(5, "Five");
        assertEquals("One", lfuCache.get(1));
        lfuCache.set(6, "Six");
        assertNotNull(lfuCache.get(1));
        assertNull(lfuCache.get(2));
        assertEquals("Five", lfuCache.get(5));
    }

    @Test
    public void testInvalidate() {
        assertEquals("One", lfuCache.get(1));
        assertEquals("Two", lfuCache.get(2));
        assertEquals("Three", lfuCache.get(3));
        assertTrue(lfuCache.invalidate());
        assertFalse(lfuCache.has(1));
        assertFalse(lfuCache.has(2));
        assertFalse(lfuCache.has(3));
    }
}