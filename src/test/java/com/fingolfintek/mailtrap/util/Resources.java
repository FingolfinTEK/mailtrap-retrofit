package com.fingolfintek.mailtrap.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

public class Resources {

    public static String resourceAsString(String path) throws IOException {
        return IOUtils.toString(Resources.class.getResourceAsStream(path), Charset.defaultCharset());
    }
}
