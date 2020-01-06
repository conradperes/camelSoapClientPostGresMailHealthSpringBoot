package com.learncamel.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.spring.ws.SpringWebserviceConstants;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.xml.transform.dom.DOMSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by z001qgd on 1/4/18.
 */
@ActiveProfiles("dev")
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SoapCamelRouteTest extends CamelTestSupport {

    @Autowired
    private CamelContext context;

    @Autowired
    protected CamelContext createCamelContext() {
        return context;
    }

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private  ConsumerTemplate consumerTemplate;

    /* @Override
     protected RouteBuilder createRouteBuilder(){
         return new SoapCamelRoute();
     }
 */
    @Autowired
    Environment environment;

    @Before
    public void setUp(){

        //System.setProperty("fromRoute", "direct:input");

    }

    private String getCountrybyCountryCodeRequest = "<FullCountryInfo xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
            "      <sCountryISOCode>GB</sCountryISOCode>\n" +
            "    </FullCountryInfo>";

    private String countryWebServiceUri = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";



    @Test
    public void countryNameByCountryCode() throws Exception {
        producerTemplate.sendBodyAndHeader(environment.getProperty("toRoute"), getCountrybyCountryCodeRequest,
                SpringWebserviceConstants.SPRING_WS_ENDPOINT_URI, countryWebServiceUri);


        // assertTrue(result.contains("Great Britain"));
    }


}
