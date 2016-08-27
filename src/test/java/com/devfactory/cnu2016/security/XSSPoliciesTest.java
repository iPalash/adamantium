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
        String goodHTML=XSSPolicies.cleanInput(badHTML,Type.HTML);
        LOG.info(badHTML+" :<>: "+goodHTML);
        assert(goodHTML.contains("<script>")==false);
    }
    @Test
    public void testCleanCSS(){
        String bad="something with<script>do stuff</script>bad code";
        String good=XSSPolicies.cleanInput(bad,Type.CSS);
        LOG.info(bad+" :<>: "+good);
        assert(good.contains("<script>")==false);
    }
    @Test
    public void testCleanURL(){
        String bad="http://www.search.com/?q=something with<script>do stuff</script>bad code";
        String good=XSSPolicies.cleanInput(bad,Type.URL);
        LOG.info(bad+" :<>: "+good);
        assert(good.contains("<script>")==false);
    }
    @Test
    public void testCleanJS(){
        String bad="something with<script>do stuff</script>bad code";
        String good=XSSPolicies.cleanInput(bad,Type.JS);
        LOG.info(bad+" :<>: "+good);
        assert(good.contains("<script>")==false);
    }
    @Test
    public void testCleanLDAP(){
        String bad="something with(script)do stuff</script>bad code";
        String good=XSSPolicies.cleanInput(bad,Type.LDAP);
        LOG.info(bad+" :<>: "+good);
        assert(good.contains("(script)")==false);
    }
}
