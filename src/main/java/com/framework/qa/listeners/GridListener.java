package com.framework.qa.listeners;

import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.grid.web.Hub;
import org.openqa.selenium.net.PortProber;
import org.testng.IExecutionListener;

import com.framework.qa.constants.FrameworkConstants;
import com.framework.qa.driver.grid.GridLauncher;
import com.framework.qa.logger.Logger;

/**
 * @author eldo_rajan
 */
public class GridListener implements IExecutionListener {
    Hub hub = null;
    SelfRegisteringRemote node1 = null;
    SelfRegisteringRemote node2 = null;
    SelfRegisteringRemote node3 = null;
    SelfRegisteringRemote node4 = null;
    GridLauncher grid = null;

    @Override
    public synchronized void onExecutionStart() {
        grid = new GridLauncher();
        int hubPort = PortProber.findFreePort();
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.CHROME_MAC_PATH);
        } else {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.CHROME_WIN_PATH);
        }

        Logger.info("**********************Selenium Grid launching in progress**********************");
        Logger.info("**********************Selenium Grid Hub launching in progress**********************");
        try {
            hub = grid.launchHub(hubPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger.info("**********************Selenium Grid Hub launching completed**********************");

        Logger.info("**********************Selenium Grid Nodes launching in progress**********************");
        try {
            node1 = grid.launchNode(hub);
            node2 = grid.launchNode(hub);
            node3 = grid.launchNode(hub);
            node4 = grid.launchNode(hub);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger.info("**********************Selenium Grid Nodes launching completed**********************");

        Logger.info("**********************Selenium Grid launching completed**********************");
    }

    @Override
    public synchronized void onExecutionFinish() {
        Logger.info("**********************Selenium Grid shutdown in progress**********************");

        Logger.info("**********************Selenium Grid Nodes shutdown in progress**********************");
        try {
            grid.shutdownNode(node1);
            grid.shutdownNode(node2);
            grid.shutdownNode(node3);
            grid.shutdownNode(node4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger.info("**********************Selenium Grid Nodes shutdown completed**********************");

        Logger.info("**********************Selenium Grid Hub shutdown in progress**********************");
        try {
            grid.shutdownHub(hub);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger.info("**********************Selenium Grid Hub shutdown completed**********************");

        Logger.info("**********************Selenium Grid shutdown completed**********************");
    }
}