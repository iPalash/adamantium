package com.devfactory.cnu2016.security;
/**
 * Created by swapnil on 26/08/16.
 */

import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class XSSPolicies {
    static final Logger LOG = LoggerFactory.getLogger(XSSPolicies.class);

    private XSSPolicies() {
    }


    public static String cleanInput(String input, Type inputType) {
        String output = input;
        try {

            switch (inputType) {
                case HTML:
                    output = ESAPI.encoder().encodeForHTML(input);
                    break;
                case CSS:
                    output = ESAPI.encoder().encodeForCSS(input);
                    break;
                case URL:
                    output = ESAPI.encoder().encodeForURL(input);
                    break;
                case JS:
                    output = ESAPI.encoder().encodeForJavaScript(input);
                    break;
                case LDAP:
                    output = ESAPI.encoder().encodeForLDAP(input);
                    break;
                default:
                    LOG.debug(inputType + " Encoding not implemented");
                    break;
            }

        } catch (Exception e) {
            LOG.debug(e.getMessage());
            return output;
        }

        return output;

    }
}
