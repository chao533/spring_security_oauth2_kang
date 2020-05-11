package com.kang.common.constant;

import cn.hutool.setting.Setting;
import cn.hutool.setting.dialect.Props;

/**
　 * <p>Title: PropConstants</p> 
　 * <p>Description: 读取配置文件Constants</p> 
　 * @author CK 
　 * @date 2020年4月26日
 */
public class PropConstants {

	/**
	 * jwt配置信息
	 */
	public static final String OAUTH2_PROP = "config/oauth2.properties";

	public interface oauth2Key {
		
		String CLIENT = "oauth2.client";

		String SECRET = "oauth2.secret";

		String ACCESS_TOKEN = "oauth2.access.token.validity.seconds";

		String REFRESH_TOKEN = "oauth2.refresh.token.validity.seconds";

		String SCOPES = "oauth2.scopes";
		
		String GRANT_TYPES = "oauth2.authorized.grant.types";
		
		String SIGNING_KEY = "oauth2.signing.key";
		
		String TOKEN_PREFIX = "oauth2.token.prefix";
		
		String TOKEN_HEADER = "oauth2.token.header";
	}
	
	/**
	 * 私钥
	 */
	public static final String PRIVATE_KEY = "config/privateKey.cert";
	
	/**
	 * 公钥
	 */
	public static final String PUBLIC_KEY = "config/publicKey.cert";
	
	
	
	public static String getProp_2(String file, String key) {
		Setting setting = new Setting(file);
		return setting.get(key);
	}
	
	public static String getProp_3(String file, String key) {
		Props props = new Props(file);
		return props.getProperty(key);
	}
}
