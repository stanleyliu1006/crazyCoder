package com.altassian.interview.test;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class RouterService {

    private static final Logger logger = Logger.getLogger(RouterService.class.getName());
    private Map<String, Runnable> routeMap;

    public RouterService() {
        routeMap = new HashMap();
    }

    public void registerRoute(String path, Runnable process) {
        routeMap.put(path, process);
    }

    public void routeProcess(String path) {
        Runnable process = routeMap.get(path);
        if(process != null){
            process.run();
        } else {
            logger.info("No process found for the path: " + path);
        }
    }

    public static void main(String[] args) {
        testRouteProcessWithRegisteredRoute();
        testRouteProcessWithUnRegisteredRoute();
    }

    private static void testRouteProcessWithRegisteredRoute() {
        RouterService routerService = new RouterService();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        redirectLoggerOutput(outputStream);

        routerService.registerRoute("/test", () -> {
            logger.info("Redirect to test page.");
        });

        routerService.routeProcess("/test");
        // Flush the loggers to ensure all pending log messages are processed
        Logger.getLogger(RouterService.class.getName()).getHandlers()[0].flush();
        logger.info("Test result: " +outputStream.toString().contains("Redirect to test page."));
    }

    private static void testRouteProcessWithUnRegisteredRoute() {
        RouterService routerService = new RouterService();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        redirectLoggerOutput(outputStream);

        routerService.routeProcess("/unknown");
        // Flush the loggers to ensure all pending log messages are processed
        Logger.getLogger(RouterService.class.getName()).getHandlers()[1].flush();
        logger.info("Test result: " +outputStream.toString().contains("No process found for the path: /unknown"));
    }

    private static void redirectLoggerOutput(ByteArrayOutputStream outputStream) {
        Handler handler= new StreamHandler(outputStream, new SimpleFormatter());
        Logger.getLogger(RouterService.class.getName()).addHandler(handler);
    }
}

class RouterServiceNoUseMap {

    private static final Logger logger = Logger.getLogger(RouterServiceNoUseMap.class.getName());
    private static final String TEST_ROUTE = "/test";

    private static Supplier<String> testProcess;

    private static Supplier<String> defaultProcess;

    public static void initProcess() {
        testProcess = () -> {
            return "Redirect to test page.";
        };

        defaultProcess = () -> {
            return "No process found for the path.";
        };
    }

    public static String routeProcess(String path) {
        initProcess();
        switch (path) {
            case TEST_ROUTE:
                return testProcess.get();
            default:
                return defaultProcess.get();
        }
    }

    public static void main(String[] args) {
        logger.info(String.valueOf(routeProcess(TEST_ROUTE).equals("Redirect to test page.")));
        logger.info(String.valueOf(routeProcess("/unknown").equals("No process found for the path.")));
    }
}

