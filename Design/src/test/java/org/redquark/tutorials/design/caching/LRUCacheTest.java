package org.redquark.tutorials.design.caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LRUCacheTest {

    private LRUCache<Integer, String> lruCache;

    @BeforeEach
    public void setUp() {
        this.lruCache = new LRUCache<>(5);
        this.lruCache.set(1, "One");
        this.lruCache.set(2, "Two");
        this.lruCache.set(3, "Three");
    }

    @Test
    public void testHas() {
        assertTrue(lruCache.has(3));
        assertTrue(lruCache.has(1));
        assertFalse(lruCache.has(4));
        assertTrue(lruCache.has(2));
        assertFalse(lruCache.has(5));
    }

    @Test
    public void testGet() {
        assertEquals("One", lruCache.get(1));
        assertEquals("Two", lruCache.get(2));
        assertEquals("Three", lruCache.get(3));
        assertNull(lruCache.get(4));
        assertNull(lruCache.get(5));
    }

    @Test
    public void testSet() {
        lruCache.set(4, "Four");
        lruCache.set(5, "Five");
        lruCache.set(6, "Six");
        assertNull(lruCache.get(1));
        assertEquals("Five", lruCache.get(5));
    }

    @Test
    public void testInvalidate() {
        assertEquals("One", lruCache.get(1));
        assertEquals("Two", lruCache.get(2));
        assertEquals("Three", lruCache.get(3));
        assertTrue(lruCache.invalidate());
        assertFalse(lruCache.has(1));
        assertFalse(lruCache.has(2));
        assertFalse(lruCache.has(3));
    }
}