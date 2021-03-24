package integration;

import connection.ISimpleHttpClient;
import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressResolverIT {
    // In here we testing the API itself; We'll need a real implementation - That's why we do the '@BeforeEach'

    private ISimpleHttpClient basicHttpClient;
    private AddressResolver addressResolver;
    
    @BeforeEach
    public void init(){
        basicHttpClient = new TqsBasicHttpClient();
        addressResolver = new AddressResolver(basicHttpClient);
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {

        Address result = addressResolver.findAddressForLocation(40.640661, -8.656688);
        assertEquals( result, new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null) );

    }

    @Test
    public void whenBadCoordidates_trhowBadArrayindex() throws IOException, URISyntaxException, ParseException {

        assertThrows(IndexOutOfBoundsException.class, () -> addressResolver.findAddressForLocation(55555, -66666));

    }

}
