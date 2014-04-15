package com.notepad.common;

/**
 * Created by deezzel on 4/14/14.
 */
public class Util {
    public static final StringBuilder sb = new StringBuilder();

    public static String concat(Object... objects){
        sb.setLength(0);
        for (Object obj:objects){
            sb.append(obj);
        }
        return sb.toString();
    }
}
