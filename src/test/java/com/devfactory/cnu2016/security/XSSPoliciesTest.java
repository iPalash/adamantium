package com.devfactory.cnu2016.security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by swapnil on 26/08/16.
 */
public class XSSPoliciesTest {
    Logger LOG= LoggerFactory.getLogger(XSSPoliciesTest.class);
    @Test
    public void testCleanHTML(){
        String badHTML="something with<script>do stuff</script>bad code";
        String goodHTML=XSSPolicies.cleanHTML(badHTML);
        LOG.info(badHTML+" : "+goodHTML);
        assert(goodHTML.contains("<script>")==false);
    }
}
