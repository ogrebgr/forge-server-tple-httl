package com.bolyartech.forge.server.tple.httl;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import httl.Engine;

import java.util.Properties;


public class HttlTemplateEngineFactory implements TemplateEngineFactory {
    private final Engine mEngine;
    private final String mTemplatePathPrefix;


    public HttlTemplateEngineFactory(String templatePathPrefix) {
        mTemplatePathPrefix = templatePathPrefix;
        Properties prop = new Properties();
        prop.put("template.directory", templatePathPrefix);
        mEngine = Engine.getEngine(prop);
    }


    @Override
    public TemplateEngine createNew() {
        return new HttlTemplateEngine(mTemplatePathPrefix, mEngine);
    }
}
