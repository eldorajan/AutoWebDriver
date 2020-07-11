package com.framework.qa.driver.grid;

import java.util.HashMap;
import java.util.Map;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.internal.utils.configuration.GridNodeConfiguration;
import org.openqa.grid.web.Hub;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.server.SeleniumServer;

import com.framework.qa.constants.FrameworkConstants;

public class GridLauncher {

    public synchronized Hub launchHub(int port) throws Exception {

        GridHubConfiguration config = new GridHubConfiguration();
        Hub hub = new Hub(config);
        hub.start();

        return hub;
    }

    public synchronized void shutdownHub(Hub hub) throws Exception {
        hub.stop();
    }

    public synchronized SelfRegisteringRemote launchNode(Hub hub) throws Exception {

        int port = PortProber.findFreePort();
        GridNodeConfiguration configuration = new GridNodeConfiguration();

        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", FrameworkConstants.GECKO_MAC_PATH);
        } else {
            System.setProperty("webdriver.gecko.driver", FrameworkConstants.GECKO_WIN_PATH);
        }

        configuration.host = hub.getConfiguration().host;
        configuration.role = "node";
        configuration.hub = "http://" + hub.getConfiguration().host + ":" + hub.getConfiguration().port;
        configuration.port = port;
        Map<String, String> customCapabilities = new HashMap<String, String>();
        if (System.getProperty("os.name").contains("Mac")) {
            customCapabilities.put("webdriver.chrome.driver", FrameworkConstants.CHROME_MAC_PATH);
            customCapabilities.put("webdriver.gecko.driver", FrameworkConstants.GECKO_MAC_PATH);
        } else {
            customCapabilities.put("webdriver.chrome.driver", FrameworkConstants.CHROME_WIN_PATH);
            customCapabilities.put("webdriver.gecko.driver", FrameworkConstants.GECKO_WIN_PATH);
        }
        configuration.custom = customCapabilities;

        RegistrationRequest req = RegistrationRequest.build(configuration);

        SelfRegisteringRemote remote = new SelfRegisteringRemote(req);
        remote.setRemoteServer(new SeleniumServer(remote.getConfiguration()));
        remote.startRemoteServer();
        remote.startRegistrationProcess();

        return remote;
    }

    public synchronized void shutdownNode(SelfRegisteringRemote remote) throws Exception {
        remote.stopRemoteServer();
    }

}