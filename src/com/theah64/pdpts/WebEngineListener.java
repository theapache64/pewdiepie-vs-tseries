package com.theah64.pdpts;

import com.theah64.webengine.utils.WebEngineConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by theapache64 on 1/11/17.
 */
@WebListener
public class WebEngineListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        WebEngineConfig.init(
                "jdbc/pewdiepie-vs-tseries",
                "jdbc/pewdiepie-vs-tseries",
                false,
                "http://localhost:8080/pewdiepie-vs-tseries",
                "http://theapache64.com/pewdiepie-vs-tseries");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
