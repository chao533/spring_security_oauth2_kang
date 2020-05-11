package com.kang.common.constant;

public class Oauth2Constant {

	public static final String CLIENT = PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.CLIENT);
	
	public static final String SECRET = PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.SECRET);
	
	public static final Integer ACCESS_TOKEN = Integer.parseInt(PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.ACCESS_TOKEN));
	
	public static final Integer REFRESH_TOKEN = Integer.parseInt(PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.REFRESH_TOKEN));
	
	public static final String[] SCOPES = PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.SCOPES).split(",");
	
	public static final String[] GRANT_TYPES = PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.GRANT_TYPES).split(",");
	
	public static final String SIGNING_KEY = PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.SIGNING_KEY);
	
	public static final String TOKEN_PREFIX = PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.TOKEN_PREFIX);
	
	public static final String TOKEN_HEADER = PropConstants.getProp_2(PropConstants.OAUTH2_PROP, PropConstants.oauth2Key.TOKEN_HEADER);
	
}
