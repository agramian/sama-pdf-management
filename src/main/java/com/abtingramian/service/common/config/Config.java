package com.abtingramian.service.common.config;

import com.google.gson.annotations.Expose;

public class Config {

    @Expose
    public int portNumber;
    @Expose
    public boolean debug;
    @Expose
    public boolean test;
    @Expose
    public String accessLogPath;
    @Expose
    public String dbHost;
    @Expose
    public String dbUser;
    @Expose
    public String dbPassword;
    @Expose
    public String dbName;
    @Expose
    public String frontendBaseUrl;

}
