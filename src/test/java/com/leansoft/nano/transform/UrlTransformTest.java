package com.leansoft.nano.transform;

import java.net.URL;

import com.leansoft.nano.transform.UrlTransform;

import junit.framework.TestCase;

public class UrlTransformTest extends TestCase {
	public void testURL() throws Exception {
		URL file = new URL("http://www.google.com/");
        UrlTransform format = new UrlTransform();
        String value = format.write(file);
        URL copy = format.read(value);
      
        assertEquals(file, copy);      
	}
}
