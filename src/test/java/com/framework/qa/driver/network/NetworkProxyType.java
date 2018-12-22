package com.framework.qa.driver.network;

/**
 * 
 * @author eldo_rajan
 *
 */
public enum NetworkProxyType {
	Pac("pac"), Reach("reach"), NoProxy("noproxy");

	/**
	 * get network type
	 * 
	 * @param networkProxyType
	 * @return
	 */
	public static NetworkProxyType getNetworkProxyType(final String networkProxyType) {
		NetworkProxyType proxyType = null;
		try {
			if (networkProxyType.equalsIgnoreCase("pac")) {
				proxyType = NetworkProxyType.Pac;
			} else if (networkProxyType.equalsIgnoreCase("reach")) {
				proxyType = NetworkProxyType.Reach;
			} else if (networkProxyType.equalsIgnoreCase("noproxy")) {
				proxyType = NetworkProxyType.NoProxy;
			} else {
				proxyType = NetworkProxyType.NoProxy;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return proxyType;
	}

	private String networkProxyType;

	NetworkProxyType(final String networkProxyType) {
		this.networkProxyType = networkProxyType;
	}

	/**
	 * get network type
	 * 
	 * @return
	 */

	public String getNetworkProxyType() {
		return this.networkProxyType;
	}

}
