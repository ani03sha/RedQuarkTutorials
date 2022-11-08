package org.redquark.tutorials.design.caching;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class implements the least frequently used cache
 */
public class LFUCache<K, V> {

    // Capacity of the cache
    private final int capacity;
    // This map stores the key and value pairs
    private final Map<K, V> keyValueMappings;
    // This map stores the keys and the number of times they were accessed.
    private final Map<K, Integer> keyFrequencyMappings;
    // This map stores the counts and the set of keys which have the same
    // counts and in the order in which they were inserted in the cache.
    private final Map<Integer, Set<K>> frequencyKeyMappings;
    // Variable which will point to the minimum frequency
    private int minimum;


    public LFUCache(int capacity) {
        this.minimum = -1;
        this.capacity = capacity;
        this.keyValueMappings = new HashMap<>();
        this.keyFrequencyMappings = new HashMap<>();
        this.frequencyKeyMappings = new HashMap<>();
    }

    public boolean has(K key) {
        return this.keyValueMappings.containsKey(key);
    }

    public V get(K key) {
        // Check if the key is not present in the cache
        if (!has(key)) {
            return null;
        }
        // Get the frequency of this key
        int frequency = this.keyFrequencyMappings.get(key);
        // We will first remove this key from the set against the
        // frequency we got above as the value. We do this because
        // later we will update the set with incremented count
        this.frequencyKeyMappings.get(frequency).remove(key);
        // If there is nothing in the current minimum bucket
        if (this.minimum == frequency && frequencyKeyMappings.get(frequency).isEmpty()) {
            this.minimum++;
        }
        // Put updated frequency in the relevant maps
        addCount(key, frequency + 1);
        return this.keyValueMappings.get(key);
    }

    public void set(K key, V value) {
        // If the cache contains the key
        if (has(key)) {
            // Update the value corresponding to the key
            this.keyValueMappings.put(key, value);
            // Update key's count
            int frequency = this.keyFrequencyMappings.get(key);
            // We will first remove this key from the set against the
            // frequency we got above as the value. We do this because
            // later we will update the set with incremented count
            this.frequencyKeyMappings.get(frequency).remove(key);
            // If there is nothing in the current minimum bucket
            if (this.minimum == frequency && frequencyKeyMappings.get(frequency).isEmpty()) {
                this.minimum++;
            }
            // Put updated frequency in the relevant maps
            addCount(key, frequency + 1);
            return;
        }
        // If the cache is full
        if (this.keyValueMappings.size() >= this.capacity) {
            // Evict the key with minimum frequency and if there
            // are more than one key with same minimum frequency,
            // we will evict the oldest one. The below line of code
            // will return us the first key corresponding to the
            // minimum frequency
            K keyToBeEvicted = this.frequencyKeyMappings.get(this.minimum).iterator().next();
            evict(keyToBeEvicted);
        }
        // Update the minimum frequency value
        this.minimum = 1;
        // Add new key and count
        addCount(key, this.minimum);
        this.keyValueMappings.put(key, value);
    }

    public boolean invalidate() {
        this.keyValueMappings.clear();
        this.keyFrequencyMappings.clear();
        this.frequencyKeyMappings.clear();
        return this.keyValueMappings.isEmpty();
    }

    private void evict(K key) {
        this.frequencyKeyMappings.get(this.minimum).remove(key);
        this.keyValueMappings.remove(key);
    }

    private void addCount(K key, int frequency) {
        this.keyFrequencyMappings.put(key, frequency);
        this.frequencyKeyMappings.computeIfAbsent(frequency, keys -> new LinkedHashSet<>());
        this.frequencyKeyMappings.get(frequency).add(key);
    }
}
