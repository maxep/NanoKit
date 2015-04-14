package com.leansoft.nano.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A lightweight LRU(least recently used) cache implementation based on 
 * @see java.util.LinkedHashMap
 * 
 * @author bulldog
 *
 * @param K key
 * @param V value
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private final int cacheSize;
	
	public LRUCache(final int size) {
		super(size + 1, 1.0f, true);
		this.cacheSize = size;
	}
	
	@Override
	protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
		return super.size() > cacheSize;
	}
}
