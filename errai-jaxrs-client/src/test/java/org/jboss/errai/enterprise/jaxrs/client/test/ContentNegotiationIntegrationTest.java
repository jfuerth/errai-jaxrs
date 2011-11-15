package org.jboss.errai.enterprise.jaxrs.client.test;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.enterprise.client.jaxrs.test.AbstractErraiJaxrsTest;
import org.jboss.errai.enterprise.jaxrs.client.shared.ContentNegotiationTestService;
import org.junit.Test;

/**
 * @author Christian Sadilek <csadilek@redhat.com>
 */
public class ContentNegotiationIntegrationTest extends AbstractErraiJaxrsTest {

  @Override
  public String getModuleName() {
    return "org.jboss.errai.enterprise.jaxrs.TestModule";
  }

  @Test
  public void testGetAsText() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@GET producing text/plain failed", "text")).getText();
  }

  @Test
  public void testGetAsXml() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@GET producing application/xml failed", "xml")).getXml();
  }
  
  @Test
  public void testPostAsText() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@POST consuming text/* failed", "post:text")).postText("text");
  }

  @Test
  public void testPostAsXml() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@POST consuming application/xml failed", "post:xml")).postXml("xml");
  }
  
  @Test
  public void testPutAsText() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@PUT consuming text/plain failed", "put:text")).putText("text");
  }

  @Test
  public void testPutAsXml() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@PUT consuming application/* failed", "put:xml")).putXml("xml");
  }
  
  @Test
  public void testDeleteAsText() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@DELETE consuming text/plain failed", "delete:text")).deleteText("text");
  }

  @Test
  public void testDeleteAsXml() {
    RestClient.create(ContentNegotiationTestService.class,
        new AssertionCallback<String>("@DELETE consuming application/xml failed", "delete:xml")).deleteXml("xml");
  }
}