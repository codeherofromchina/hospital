package com.hospital.tools;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 缓存数据，用于减少接口查询次数
 * 1.包括所有医生列表信息
 * 2.包括所有科室信息列表信息
 * @author wxd
 *
 */
public class DataCacheUtil {
	// 缓存的数据
	private static Map<CacheKey, Object> cacheData = new HashMap<CacheKey, Object>();
	
	public final static String ALL_DOCTORS_KEY = "all_doctor";
	
	
	/**
	 * 获取缓存数据
	 * @param key
	 * @return
	 */
	public synchronized static Object getData(CacheKey key){
		return cacheData.get(key);
	}
	
	public synchronized static <T> T getData(CacheKey key,Class<T> c){
		return (T)cacheData.get(key);
	}
	
	
	/**
	 * 放置要缓存的数据，如果存在则替换更新
	 * @param key
	 * @param value
	 */
	public synchronized static void putData(CacheKey key,Object value){
		cacheData.put(key, value);
	}
	
	/**
	 * 缓存中存放的数据的键
	 * ALL_DOCTORS_KEY -- 所有医生缓存的键
	 * ALL_DEPARTMENT_KEY -- 所有科室数据缓存的键
	 * @author wxd
	 *
	 */
	public static enum CacheKey{
		ALL_DOCTORS_KEY("all_doctor"),ALL_DEPARTMENT_KEY("all_department");
		
		private String key ;
		public String getKey() {
			return key;
		}
		private CacheKey(String key){
			this.key = key;
		}
	}
	
	
	/**
	 * 测试数据
	 * @param args
	 */
	public static void main(String[] args) {
		DataCacheUtil.putData(DataCacheUtil.CacheKey.ALL_DOCTORS_KEY, "myData");
		
		String data = DataCacheUtil.getData(DataCacheUtil.CacheKey.ALL_DOCTORS_KEY, String.class);
		
		System.out.println(data);
		
	}
}
