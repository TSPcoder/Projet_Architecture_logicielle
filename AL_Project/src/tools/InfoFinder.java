package tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * La methode principale est info(Class c)
 *		elle est statique
 * 		elle prend en argument une Class
 * 		et retourne une HashMap qui contient :
 * 			"type_name": interface or class
 *          "name": name of the class
 * 			"package": name of the package
 * 			"implements": list with implements
 * 			"extends": list with extends
 * 			"variables": list with all the instances variables (name and type)
 * 			"constructors": list with all the constructors
 * 			"methods": list with all the methods
 * 
 * @author David
 *
 */
public class InfoFinder {
	
	/**
	 * Build a HashMap with informations from a Class
	 * 
	 * @param c Class
	 * @return HashMap with class informations
	 */
	public static HashMap<String, Object> info(Class<?> c) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean isInterface = c.isInterface();
		map.put("type", (isInterface) ? "interface" : "class");
		map.put("name", c.getSimpleName());
		map.put("package", c.getPackage().getName());
		map.put("implements", (!isInterface) ? imp(c) : new ArrayList<String>());
		map.put("extends", (isInterface) ? imp(c) : ext(c));		
		map.put("variables", variables(c));
		map.put("constructors", constructors(c));
		map.put("methods", methods(c));
		map.put("description", "");
		
		return map;
	}
	
	/**
	 * Build an ArrayList with all instances variables from a Class
	 * 
	 * @param c Class
	 * @return an ArrayList of Strings
	 * 		   (each element is like "name_of_variable:type_of_variable")
	 */
	public static ArrayList<String> variables(Class<?> c) {
		ArrayList<String> result = new ArrayList<String>();
		for (Field f : c.getDeclaredFields()) {
			result.add(f.getName()+":"+f.getType().getSimpleName());
		}
		return result;
	}
	
	/**
	 * Build an ArrayList with all constructors
	 * 
	 * @param c Class
	 * @return an ArrayList of Strings
	 * 		   (each element is like "class_name(type1, type2, etc.)")
	 */
	public static ArrayList<String> constructors(Class<?> c) {
		ArrayList<String> result = new ArrayList<String>(); 
		for (Constructor<?> constructor : c.getConstructors()) {
			String s = constructor.getDeclaringClass().getSimpleName() + "(";
			for (Class<?> sc : constructor.getParameterTypes()) {
				s = s + sc.getSimpleName() + ",";
			}
			s = s.substring(0, s.length()-1) +  ")";
			result.add(s);
		}
		return result;
	}
	
	/**
	 * Build an ArrayList with all methods
	 * 
	 * @param c Class
	 * @return an ArrayList of Strings
	 * 		   (each element is like "method_name(type1):returned_type")
	 */
	public static ArrayList<String> methods(Class<?> c) {
		ArrayList<String> result = new ArrayList<String>();

		for (Method m : c.getDeclaredMethods()) {
			String field = m.getName() + "(";
			for (Class<?> sc : m.getParameterTypes()) {
				field += sc.getSimpleName() + ",";
			}
			if (field.charAt(field.length() - 1) != '(') {
				field = field.substring(0, field.length()-1);
			}
			field += "):";
			field += m.getReturnType().getSimpleName();
			result.add(field);
		} 
		return result;
	}
	
	/**
	 * Build an ArrayList with implements
	 * 
	 * @param c Class
	 * @return an ArrayList of Strings (name_of_interface)
	 */
	public static ArrayList<String> imp(Class<?> c) {
		ArrayList<String> result = new ArrayList<String>();
		for (Class<?> sc : c.getInterfaces()) {
			result.add(sc.getSimpleName());
		}
		return result;
	}
	
	/**
	 * Return name of the superclass 
	 * 
	 * @param c Class
	 * @return String with name of SuperClass
	 */
	public static ArrayList<String> ext(Class<?> c) {
		ArrayList<String> result = new ArrayList<String>();
		if (c.getSuperclass().getSimpleName() == "Object") {
			result.add(c.getSuperclass().getSimpleName());
		}
		return result;
	}
	
}