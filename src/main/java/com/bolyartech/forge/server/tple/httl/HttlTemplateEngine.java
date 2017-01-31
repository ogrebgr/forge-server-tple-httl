package com.bolyartech.forge.server.tple.httl;

import com.bolyartech.forge.server.misc.TemplateEngine;
import httl.Engine;
import httl.Template;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


public class HttlTemplateEngine implements TemplateEngine {
    private final String mTemplatePathPrefix;
    private final Engine mEngine;
    private final Map<String, Object> mAttributes = new HashMap<>();


    public HttlTemplateEngine(String templatePathPrefix, Engine engine) {
        mTemplatePathPrefix = templatePathPrefix;
        mEngine = engine;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        Template template = null;
        try {
            template = mEngine.getTemplate(mTemplatePathPrefix + templateName);
            template.render(mAttributes, os);

            return new String(os.toByteArray(),"UTF-8");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
