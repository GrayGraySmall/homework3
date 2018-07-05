package homework3.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	private final static String BEANS_XML = "beans.xml";
	private static BeanFactory factory = null;

	// 禁止创建对象
	private SpringUtils() {
	}

	// 静态语句块创建Bean工厂
	static {
		if (factory == null)
			factory = new ClassPathXmlApplicationContext(BEANS_XML);
	}

	// 获得Bean工厂
	public static BeanFactory getBeanFactory() {
		return factory;
	}
}
