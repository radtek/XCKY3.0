package com.hisign.xcky.api.model.sceneQuery;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class FulltextRetrievalResult {
	
	private static Log log = LogFactory.getLog(FulltextRetrievalResult.class);

	private String searched = "0";
	// 查询结果列表
	private List results = new ArrayList();
	// Facet
	private List<MyGroupFacetField> myGroupFacetField;
	// 查询结果总记录数
	private Long totalCount;

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}

	public String getSearched() {
		return searched;
	}

	public void setSearched(String searched) {
		this.searched = searched;
	}

	/**
	 * SolrDocument与实体类转换
	 * @author linhong
	 * @param document SolrDocument对象
	 * @param clzz 泛型类
	 * @return <T>
	 */
	public static <T> T solrDocument2Entity(SolrDocument document, Map hlMap, Class<T> clzz) {
		Object obj = null;
		try {
			obj = clzz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		Method m = null;
		
		Class<?> fieldType = null;
		Field[] filedArrays = clzz.getDeclaredFields(); // 获取类中所有属性
		
		// 需要说明的是返回的结果集中的FieldNames()比类属性多
		for (String fieldName : document.getFieldNames()) {
			for (Field f : filedArrays) {
				try {
					// 如果实体属性名和查询返回集中的字段名一致,填充对应的set方法
					if (f.getName().equals(fieldName)) {
						
						// 获取到的属性名
						f = clzz.getDeclaredField(fieldName);
						// 属性类型
						fieldType = f.getType();
						
						// 构造set方法名 setId
						String dynamicSetMethod = dynamicMethodName(f.getName(), "set");
						if("text".equals(fieldName)){
							dynamicSetMethod="setText";
						}
						// 获取方法
						m = clzz.getMethod(dynamicSetMethod, fieldType);
						
						// 如果是 int, float等基本类型，则需要转型
						if (fieldType.equals(Integer.TYPE)) {
							fieldType = Integer.class;
						} else if (fieldType.equals(Float.TYPE)) {
							fieldType = Float.class;
						} else if (fieldType.equals(Double.TYPE)) {
							fieldType = Double.class;
						} else if (fieldType.equals(Boolean.TYPE)) {
							fieldType = Boolean.class;
						} else if (fieldType.equals(Short.TYPE)) {
							fieldType = Short.class;
						} else if (fieldType.equals(Long.TYPE)) {
							fieldType = Long.class;
						} else if (fieldType.equals(String.class)) {
							fieldType = String.class;
						} else if (fieldType.equals(Collection.class)) {
							fieldType = Collection.class;
						}
						
						Object fieldValue = null;
						if (null != hlMap) {
							Map map = (Map)hlMap.get(document.getFieldValue("ID"));
							if ("text".equals(fieldName)) {
								String str= document.getFieldValue("text").toString();
								List list = (List) map.get(fieldName);
								//fieldValue = list.get(0);
								fieldValue = str;
							} else if (null != map && null != map.get(fieldName)) {
								List list = (List) map.get(fieldName);
								fieldValue = list.get(0);
							} else {
								fieldValue = document.getFieldValue(fieldName);
							}
						} else {
							fieldValue = document.getFieldValue(fieldName);
						}
						m.invoke(obj, fieldType.cast(fieldValue));
					}
				} catch (ClassCastException e) {
					System.out.println(fieldName);
					log.error("请检查schema.xml中的各个field的数据类型与PO类的是否一致.", e);
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					log.error("请检查schema中的field是否不存在于PO类中.", e);
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					log.error("请检查PO类中的field对应的各个setter和getter是否存在.", e);
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			return clzz.cast(obj);
		} catch (ClassCastException e) {
			log.error("请检查schema.xml中的各个field的数据类型与PO类的是否一致.", e);
			e.printStackTrace();
		}
		log.warn("solrDocument is null.");
		return null;
	}
	
	private static String dynamicMethodName(String fieldName, String prefix) {
		return null == prefix ? fieldName : prefix + fieldName;
	}
	
	/**
	   * 批量转换, 将solrDocumentList转换为实体类 List
	   * @author linhong
	   * @param documents	solrDocumentList对象
	   * @param clzz 泛型类
	   * @return List<T>
	   */
	  public static <T> List<T> solrDocument2Entity(SolrDocumentList documents, Map hlMap, Class<T> clzz) {
		  if (null != documents && documents.size() > 0) {
			  List<T> lists = new ArrayList<T>();
			  Iterator<SolrDocument> iter = documents.iterator();
			  while (iter.hasNext()) {
				  Object obj = solrDocument2Entity(iter.next(), hlMap, clzz);
				  if (null != obj) {
					  lists.add(clzz.cast(obj));
				  }
			  }
			  return lists;
		  }
		  log.warn("即将要转换的solrDocumentList为null或者size为0.");
		  return null;
	}

	public List<MyGroupFacetField> getMyGroupFacetField() {
		return myGroupFacetField;
	}

	public void setMyGroupFacetField(List<MyGroupFacetField> myGroupFacetField) {
		this.myGroupFacetField = myGroupFacetField;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
