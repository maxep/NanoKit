package com.leansoft.nano;

import java.io.StringWriter;
import java.util.List;

import com.leansoft.nano.IReader;
import com.leansoft.nano.IWriter;
import com.leansoft.nano.NanoFactory;
import com.leansoft.nano.annotation.Attribute;
import com.leansoft.nano.annotation.Element;
import com.leansoft.nano.annotation.RootElement;
import com.leansoft.nano.annotation.Value;

import junit.framework.TestCase;

public class CaseTest extends TestCase {
	
    private static final String SOURCE = 
		   "<?xml version=\"1.0\"?>\n"+
		   "<Example Version='1.0' Name='example' URL='http://domain.com/'>\n"+ 
		   "   <ListEntry id='1'>\n"+
		   "       <Text>one</Text>  \n\r"+
		   "   </ListEntry>\n\r"+
		   "   <ListEntry id='2'>\n"+
		   "       <Text>two</Text>  \n\r"+
		   "   </ListEntry>\n"+
		   "   <ListEntry id='3'>\n"+
		   "       <Text>three</Text>  \n\r"+
		   "   </ListEntry>\n"+
		   "   <TextEntry id='4'>\n" +
		   "      <Text>example 4</Text>\n" +
		   "   </TextEntry>\n" +
		   "   <URLEntry>http://a.com/</URLEntry>\n"+
		   "   <URLEntry>http://b.com/</URLEntry>\n"+
		   "   <URLEntry>http://c.com/</URLEntry>\n"+
		   "   <TextEntry id='5'>\n" +
		   "      <Text>example 5</Text>\n" +
		   "   </TextEntry>\n" +
		   "   <TextEntry id='6'>\n" +
		   "      <Text>example 6</Text>\n" +
		   "   </TextEntry>\n" +
		   "</Example>";
    
    @RootElement(name="Example")
    private static class CaseExample {
    
    	@Element(name="ListEntry")
    	private List<TextEntry> list;
    	
    	@Element(name="URLEntry")
    	private List<URLEntry> domainList;
    	
    	@Element(name="TextEntry")
    	private List<TextEntry> textList;
    	
    	@Attribute(name="Version")
    	private float version;
    	
    	@Attribute(name="Name")
    	private String name;
    	
    	@Attribute(name="URL")
    	private String URL;
    }
    
    private static class TextEntry {
    	
    	@Attribute(name="id")
    	private int id;
    	
    	@Element(name="Text")
    	private String text;
    }
    
    private static class URLEntry {
    	
    	@Value
    	private String location;
    }
    
    private CaseExample readObjectFromXMLSource() throws Exception {
    	IReader xmlReader = NanoFactory.getXMLReader();
    	
    	// deserialize
    	CaseExample example = xmlReader.read(CaseExample.class, SOURCE);
    	
    	return example;
    }

    public void testCaseXML() throws Exception {
    	CaseExample example = this.readObjectFromXMLSource();
    	
	    assertEquals(1.0f, example.version);
	    assertEquals("example", example.name);
	    assertEquals("http://domain.com/", example.URL);
	    
    	IWriter xmlWriter = NanoFactory.getXMLWriter();
    	IReader xmlReader = NanoFactory.getXMLReader();
	    
	    validate(xmlWriter, xmlReader, example);
    }
    
    public void testCaseJSON() throws Exception {
    	CaseExample example = this.readObjectFromXMLSource();
	    
	    // serialize
    	IWriter jsonWriter = NanoFactory.getJSONWriter();
	    IReader jsonReader = NanoFactory.getJSONReader();
	    
	    
    	validate(jsonWriter, jsonReader, example);
    }

    private void validate(IWriter writer, IReader reader, CaseExample example) throws Exception {
	    // serialize
    	StringWriter stringWriter = new StringWriter();
    	writer.write(example, stringWriter);
		String text = stringWriter.toString();
	    
		// deserialize again
		example = reader.read(CaseExample.class, text);
		
		// validate
	    assertEquals(1.0f, example.version);
	    assertEquals("example", example.name);
	    assertEquals("http://domain.com/", example.URL);
	    TextEntry te = example.textList.get(1);
	    assertEquals(5, te.id);
	    assertEquals("example 5", te.text);
	    te = example.list.get(2);
	    assertEquals(3, te.id);
	    assertEquals("three", te.text);   
	    URLEntry ue = example.domainList.get(2);
	    assertEquals("http://c.com/", ue.location);
    }
    
}
