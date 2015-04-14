package com.leansoft.nano;

import java.io.OutputStream;
import java.io.Writer;

import com.leansoft.nano.exception.MappingException;
import com.leansoft.nano.exception.WriterException;

/**
 * IWriter write or serialize POJO into XML or JSON format guided by schema.
 * 
 * @author bulldog
 *
 */
public interface IWriter {
	
	
	/**
	 * Write POJO into character stream.
	 * 
	 * @param source an POJO
	 * @param out a character stream
	 * @throws WriterException if writes fail
	 */
	public void write(Object source, Writer out) throws WriterException, MappingException;
	
	/**
	 * Write POJO into output stream of bytes.
	 * 
	 * @param source an POJO
	 * @param os an output stream of bytes.
	 * @throws WriterException if writes fail
	 */
	public void write(Object source, OutputStream os) throws WriterException, MappingException;
	
	/**
	 * Write POJO into string.
	 * 
	 * @param source an POJO
	 * @return a string representation
	 * @throws WriterException if writes fail
	 */
	public String write(Object source) throws WriterException, MappingException;

}
