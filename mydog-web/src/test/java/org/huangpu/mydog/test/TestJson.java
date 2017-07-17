package org.huangpu.mydog.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author xusihan on 2017.07.17
 *
 */
public class TestJson {

	@Test
	public void testMap() {
		Map<String, String> sMap = new HashMap<>();
		sMap.put("name", "raindrops");
		sMap.put("age","22");
		sMap.put("addr", "beijing");
		Object json = JSON.toJSON(sMap);
		System.out.println(json.toString());
	}
	
	@Test
	public void testObj(){
		Person person = new Person();
		person.setAddr("beijing");
		person.setAge(22);
		person.setName("raindorps");
		Object json = JSON.toJSON(person);
		System.out.println(json.toString());
	}
	
	private class Person{
		private String name;
		private int age;
		private String addr;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		
		
	}
	
}
