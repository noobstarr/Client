package com.jagex.rs2;

/**
 * Global Client Constants.
 * @author Shawn
 *
 */
public final class Constants {

	/**
	 * The server's name.
	 */
	protected final static String SERVER_NAME = "RuneScape";

	/**
	 * The client's gui name.
	 */
	protected final static String CLIENT_FRAME = "Jagex";

	/**
	 * The client's web site.
	 */
	protected final static String SERVER_WEB = "http://www.runescape.com";

	/**
	 * The address the client is connecting too.
	 */
	protected final static String SERVER_IP = "199.195.116.2";
	
	/**
	 * The port the client is connecting too.
	 */
	protected final static int SERVER_PORT = 43594;
	
	/**
	 * If the update server is active.
	 */
	protected final static boolean UPDATE_SERVER_ACTIVE = false;
	
	/**
	 * The name of the cache.
	 */
	private final static String CACHE_NAME = ".RuneScape_317";
	
	/**
	 * The cache location.
	 */
	public static final String CACHE_LOCATION = System.getProperty("user.home") + "/"+CACHE_NAME+"/";

    /**
     * The client's npc bits.
     */
	protected static final int NPC_BITS = 12;


}
