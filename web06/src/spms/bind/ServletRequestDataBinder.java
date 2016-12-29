package spms.bind;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletRequest;

public class ServletRequestDataBinder {
  public static Object bind(
      ServletRequest request, Class<?> dataType, String dataName) 
      throws Exception {
//	1. dataType의 bean 객체를 만든다.
    if (isPrimitiveType(dataType)) {	// 기본타입이거나, date or String 이면 조건 만족 -> true
      return createValueObject(dataType, request.getParameter(dataName));
    }
    
    Set<String> paramNames = request.getParameterMap().keySet();
    Object dataObject = dataType.newInstance();
    Method m = null;
    
    for (String paramName : paramNames) {
      m = findSetter(dataType, paramName);
      if (m != null) {
        m.invoke(dataObject, createValueObject(m.getParameterTypes()[0], 
            request.getParameter(paramName)));
      }
    }
    return dataObject;
  }
  
  private static boolean isPrimitiveType(Class<?> type) {
//    기본타입이라면...
	  if (type.getName().equals("int") || type == Integer.class ||
        type.getName().equals("long") || type == Long.class ||
        type.getName().equals("float") || type == Float.class ||
        type.getName().equals("double") || type == Double.class ||
        type.getName().equals("boolean") || type == Boolean.class ||
        type == Date.class || type == String.class) {
      return true;
    }
//    기본타입이 아니면
    return false;
  }
  
  private static Object createValueObject(Class<?> type, String value) {
    if (type.getName().equals("int") || type == Integer.class) {
      return new Integer(value);
    } else if (type.getName().equals("float") || type == Float.class) {
      return new Float(value);
    } else if (type.getName().equals("double") || type == Double.class) {
      return new Double(value);
    } else if (type.getName().equals("long") || type == Long.class) {
      return new Long(value);
    } else if (type.getName().equals("boolean") || type == Boolean.class) {
      return new Boolean(value);
    } else if (type == Date.class) {
      return java.sql.Date.valueOf(value);
    } else {
      return value;
    }
  }
  
  private static Method findSetter(Class<?> type, String name) {
    Method[] methods = type.getMethods();
    
    String propName = null;
    for (Method m : methods) {
      if (!m.getName().startsWith("set")) continue;
      
      propName = m.getName().substring(3);
      if (propName.toLowerCase().equals(name.toLowerCase())) {
        return m;
      }
    }
    return null;
  }
}
