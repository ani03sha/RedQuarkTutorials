package org.redquark.tutorials.design.caching;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the LRU cache implementation
 */
public class LRUCache<K, V> {

    // The capacity of the cache
    private final int capacity;
    // Head of the doubly linked list storing the cache elements.
    // It is a dummy node.
    private final Entry<K, V> head;
    // Tail of the doubly linked list storing the cache elements.
    // It is a dummy node.
    private final Entry<K, V> tail;
    // Map to store the key and the linked list node pair
    private final Map<K, Entry<K, V>> mappings;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Entry<>();
        this.tail = new Entry<>();
        this.mappings = new HashMap<>();
        // Link head and tail nodes
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    public boolean has(K key) {
        return this.mappings.containsKey(key);
    }

    public V get(K key) {
        // Check if this key exists in the cache
        if (!has(key)) {
            // Key is not found in the cache
            return null;
        }
        // If the key exists in the cache then we will return its corresponding
        // value and move it to the front of the doubly linked list (first node
        // after the dummy head node).
        Entry<K, V> valueEntry = this.mappings.get(key);
        // Move this node to the front
        moveToFront(valueEntry);
        return valueEntry.value;
    }

    public void set(K key, V value) {
        // Check if the key is already present in the cache.
        // In that case, we will just update the value and move
        // the node containing the cache to the front
        if (has(key)) {
            Entry<K, V> valueEntry = this.mappings.get(key);
            valueEntry.value = value;
            moveToFront(valueEntry);
        }
        // If the element is not present, then we will create a
        // new entry and store it in the cache
        else {
            // Create a new node with the given key and value
            Entry<K, V> entry = new Entry<>();
            entry.key = key;
            entry.value = value;
            // Add this new node to the mappings and in the list
            this.mappings.put(key, entry);
            addNode(entry);
            // Check if we have enough space to put a new element in the cache
            if (this.mappings.size() > this.capacity) {
                // Remove the node from the tail
                Entry<K, V> tail = removeFromRear();
                // Remove the tail from the mappings
                this.mappings.remove(tail.key);
            }
        }
    }

    public boolean invalidate() {
        // Point head to tail
        this.head.next = this.tail;
        this.tail.previous = this.head;
        // Clear all the entries from the map
        this.mappings.clear();
        return this.head.next == this.tail && this.tail.previous == this.head;
    }

    private void addNode(Entry<K, V> entry) {
        entry.previous = this.head;
        entry.next = this.head.next;
        this.head.next.previous = entry;
        this.head.next = entry;
    }

    private Entry<K, V> removeFromRear() {
        // Get the last node (i.e. node before tail)
        Entry<K, V> rear = this.tail.previous;
        // Remove the rear node
        removeNode(rear);
        return rear;
    }

    private void removeNode(Entry<K, V> rear) {
        Entry<K, V> previous = rear.previous;
        Entry<K, V> next = rear.next;
        next.previous = previous;
        previous.next = next;
    }

    private void moveToFront(Entry<K, V> entry) {
        // Current top node
        Entry<K, V> currentTop = this.head.next;
        // Point previous of the current top to the newly accessed node
        currentTop.previous = entry;
        // Point next of the head to the newly accessed node
        this.head.next = entry;
        // Fix previous and next pointers of the newly accessed node
        entry.next = currentTop;
        entry.previous = this.head;
    }

    /**
     * This class represents one element in the cache
     */
    static class Entry<K, V> {
        // Identifier by which we are going to search in the cache
        private K key;
        // Actual computed data
        private V value;
        // Pointer to the previous node
        private Entry<K, V> previous;
        // Pointer to the next node
        private Entry<K, V> next;
    }
}