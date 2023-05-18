package com.school.util;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class Util {
	
	private ObjectMapper mapper;

	private static final String SUCCESS = "success";
	private static final String DATA = "data";
	private static final String MESSAGE = "message";
	private static final String ERROR = "Error while creating json response.";

	private static Logger logger = LoggerFactory.getLogger(Util.class);

	public Util(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	public String objectToString(Object object) {
		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, object);
			return strWriter.toString();
		} catch (Exception e) {
			logger.error(ERROR, e);
		}
		return null;
	}
	
	public String objectMapperListToJson(List<?> listObject, String message) {

		Map<String, Object> mapObject = new HashMap<>();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapObject.put(SUCCESS, true);
		mapObject.put(MESSAGE, message);
		mapObject.put(DATA, listObject);

		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, mapObject);
			return strWriter.toString();
		} catch (Exception e) {
			logger.error(ERROR, e);
		}
		return null;
	}
	public String objectMapperError(String msg) {
		Map<String, Object> mapObject = new HashMap<>();
		mapObject.put(SUCCESS, false);
		mapObject.put(MESSAGE, msg);
		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, mapObject);
			return strWriter.toString();
		} catch (Exception e) {
			logger.error(ERROR, e);
		}
		return null;
	}
	
	public String objectMapperError(Object object, String msg) {
		Map<String, Object> mapObject = new HashMap<>();
		mapObject.put(SUCCESS, false);
		mapObject.put(DATA, object);
		mapObject.put(MESSAGE, msg);
		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, mapObject);
			return strWriter.toString();
		} catch (Exception e) {
			logger.error(ERROR, e);
		}
		return null;
	}

	public String objectMapperSuccess(String msg) {
		Map<String, Object> mapObject = new HashMap<>();
		mapObject.put(SUCCESS, true);
		mapObject.put(MESSAGE, msg);
		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, mapObject);
			return strWriter.toString();
		} catch (Exception e) {
			logger.error(ERROR, e);
		}
		return null;
	}

	public String objectMapperSuccess(Object object, String msg) {
		Map<String, Object> mapObject = new HashMap<>();
		mapObject.put(SUCCESS, true);
		mapObject.put(DATA, object);
		mapObject.put(MESSAGE, msg);
		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, mapObject);
			return strWriter.toString();
		} catch (Exception e) {
			logger.error(ERROR, e);
		}
		return null;
	}

}
