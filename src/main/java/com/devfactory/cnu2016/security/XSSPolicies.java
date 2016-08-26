package com.devfactory.cnu2016.security;
/**
 * Created by swapnil on 26/08/16.
 */
import org.owasp.esapi.ESAPI;
public class XSSPolicies {
    public static String cleanHTML(String input){
        return ESAPI.encoder().encodeForHTML(input);
    }
}
