package rumyantseva.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void myTestApi() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("178.176.76.15");
    int str = ipLocation.indexOf("<Country>") ;
    int end = ipLocation.indexOf("</Country>") ;
    String country = ipLocation.substring(str+9, end);
    assertEquals(country,"RU");
  }

  @Test (enabled = false)
  public void invalidTestApi() {
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("178.176.76.xx");
    int str = ipLocation.indexOf("<Country>") ;
    int end = ipLocation.indexOf("</Country>") ;
    String country = ipLocation.substring(str+9, end);
    assertEquals(country,"RU");
  }
}
