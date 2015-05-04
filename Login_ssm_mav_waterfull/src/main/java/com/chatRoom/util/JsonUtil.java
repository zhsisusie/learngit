package com.chatRoom.util;

import java.lang.reflect.Field;
import java.util.LinkedList;

import com.chatRoom.model.Photo;

import net.sf.json.JSONArray;





public class JsonUtil {
    public static String toJson(Object obj) throws IllegalArgumentException, IllegalAccessException{
    	Class cla=obj.getClass();
    	Field[] fields =cla.getDeclaredFields();
    	String[]names=fieldToNames(fields);
    	Object[] values;
    	String json;
		values = fieldToValues(fields,obj);
		json=produceToJson(names,values);
		return json;
    }

	private static String produceToJson(String[] names, Object[] values) {
		if(names.length!=values.length){
			new RuntimeException("转化json数据出错");
		}
		StringBuilder json=new StringBuilder();
		json.append("{");
		for(int i=0;i<names.length;i++){
			json.append("'");
			json.append(names[i]);
			json.append("':");
			processFieldValue(values[i],json);
			if(i<names.length-1){
				json.append(",");
			}
		}
		json.append("}");
		return json.toString();
	}

	private static void processFieldValue(Object object, StringBuilder json) {
		if(object instanceof Number){
			json.append(object);
		}else{
			json.append("'");
			json.append(object);
			json.append("'");
		}
		
	}

	private static Object[] fieldToValues(Field[] fields, Object obj) throws IllegalArgumentException, IllegalAccessException {
		Object[]values=new Object[fields.length];
		for(int i=0;i<values.length;i++){
			values[i]=fields[i].get(obj);//return the value of the field represented by this field on the specific objcet
		}
		return values;
	}

	private static String[] fieldToNames(Field[] fields) {
		String []names=new String[fields.length];
		for(int i=0;i<fields.length;i++){
			fields[i].setAccessible(true);//将此对象的accessible标志设置为可以读取
			names[i]=fields[i].getName();
		}
		return names;
	}
	
	public static JSONArray listToJson(LinkedList<Photo>list){
		JSONArray jsonArray=JSONArray.fromObject(list);
		return jsonArray;
	}
}
