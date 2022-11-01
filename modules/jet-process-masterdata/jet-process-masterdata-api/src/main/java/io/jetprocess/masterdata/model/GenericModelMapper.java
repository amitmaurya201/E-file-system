package io.jetprocess.masterdata.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@code GenericModelMapper} is a class for converting {@link List<object[]>}
 * in {@link List<T>} list of specified Class <T>
 * 
 * @author Mayank.Kumar
 *
 */
public class GenericModelMapper {

	/**
	 * Returns list of records of type {@link List<T>}
	 * 
	 * @param 	type	a Class type
	 * @param 	record	list of records containing object array
	 * @return			list of specified Class
	 * @see 			Class
	 */
	public static <T> List<T> map(Class<T> type, List<Object[]> records) {
		List<T> result = new LinkedList<T>();
		for (Object[] record : records) {
			result.add(map(type, record));
		}
		return result;
	}

	/**
	 * Returns a record of a specified type {@link T}
	 * 
	 * @param 	type	a Class type
	 * @param 	record	a record of type object array
	 * @return			an instance of specified Class
	 * @see				Class
	 */
	private static <T> T map(Class<T> type, Object[] record) {
		List<Class<?>> recordTypes = new ArrayList<>();
		Object[] recordFinal = new Object[record.length];
		Field[] fields = type.getDeclaredFields();
		int count = 0;
		for (Object field : record) {
			// recordTypes.add(null == field ? fields[count].getType() : (field.getClass().equals(BigInteger.class) ? Long.class : field.getClass().equals(Timestamp.class) ? Date.class : field.getClass().equals(java.sql.Date.class) ? LocalDate.class : field.getClass()));
			recordFinal[count] = (null != field && field.getClass().equals(BigInteger.class)) ? ((BigInteger)field).longValue() : (null != field && field.getClass().equals(java.sql.Date.class)) ? ((java.sql.Date)field).toLocalDate() : field;
			count++;
		}
		try {
			Constructor[] constructors = type.getConstructors();
			for (Constructor<T> constructor : constructors) {
				if(constructor.getParameterCount() == record.length) {
					return constructor.newInstance(recordFinal);
				}
			}
			/*Constructor<T> constructor = type.getConstructor(recordTypes.toArray(new Class<?>[record.length]));
			return constructor.newInstance(recordFinal);*/
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	/*public static <T> Object map2(Class<T> type, Object[] record) {
		List<Class<?>> recordTypes = new ArrayList<>();
		Object[] recordFinal = new Object[record.length];
		Field[] fields = type.getDeclaredFields();
		int count = 0;
		Constructor<T> constructor;
		Object obj = null; 
		try {
			constructor = type.getConstructor();
			obj = constructor.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		for (Object field : record) {
			recordTypes.add(null == field ? fields[count].getType() : (field.getClass().equals(BigInteger.class) ? Long.class : field.getClass().equals(Timestamp.class) ? Date.class : field.getClass()));
			recordFinal[count] = (null != field && field.getClass().equals(BigInteger.class)) ? ((BigInteger)field).longValue() : field;
			count++;
		}
	
		return obj;
	}*/
}
