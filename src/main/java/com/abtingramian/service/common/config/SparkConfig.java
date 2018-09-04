package com.abtingramian.service.common.config;

import com.google.common.io.Files;
import org.eclipse.jetty.server.AbstractNCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import spark.embeddedserver.EmbeddedServers;
import spark.embeddedserver.jetty.EmbeddedJettyFactory;
import spark.embeddedserver.jetty.JettyServerFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static spark.Spark.port;

public class SparkConfig {

    private final Config config;
    private final Logger logger;

    public SparkConfig(final Config config, final Logger logger) {
        this.config = config;
        this.logger = logger;
    }

    public void configure() {
        // set port to run application on
        port(config.portNumber);
        // logging
        setUpRequestLogging();
    }

    private void setUpRequestLogging() {
        try {
            // create parent directories for log file if necessary
            Files.createParentDirs(new File(config.accessLogPath));
            // add a FileHandler to the Logger so that logged records are written to a file
            logger.addHandler(new FileHandler(config.accessLogPath, true));
        } catch (final IOException e) {
            e.printStackTrace();
        }
        // add a request logging server to the embedded servers list
        EmbeddedServers.add(EmbeddedServers.Identifiers.JETTY, new EmbeddedJettyFactory(new JettyServerFactory() {
            @Override
            public Server create(final int maxThreads, final int minThreads, final int threadTimeoutMillis) {
                // create and set up a server instance
                final Server server;
                if (maxThreads > 0) {
                    final int max = maxThreads > 0 ? maxThreads : 200;
                    final int min = minThreads > 0 ? minThreads : 8;
                    final int idleTimeout = threadTimeoutMillis > 0 ? threadTimeoutMillis : '\uea60';
                    server = new Server(new QueuedThreadPool(max, min, idleTimeout));
                } else {
                    server = new Server();
                }
                // define the request logging behavior
                server.setRequestLog(new AbstractNCSARequestLog() {
                    @Override
                    protected boolean isEnabled() {
                        return true;
                    }

                    @Override
                    public void write(final String s) throws IOException {
                        logger.info(s);
                    }
                });
                return server;
            }

            @Override
            public Server create(final ThreadPool threadPool) {
                return null;
            }
        }));
    }

}
