package stocks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    IStockMarketService market;

    @InjectMocks
    StocksPortfolio portfolio;

    @DisplayName("No Specific instantiation (use @Mock and @InjectMocks)")
    @Test
    void getTotalValueAnnot() {

        // 3. Load the mock with the proper expectations (when...thenReturn)
        when(market.getPrice("EBAY")).thenReturn(1.5);
        when(market.getPrice("APPLE")).thenReturn(4.0);

        // 4. Execute the test (use the service in the SuT)
        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("APPLE", 4));
        double result = portfolio.getTotalValue();

        // 5. Verify the result (assert) and the use of the mock (verify)
        assertEquals(19.0, result);
        verify(market, times(2)).getPrice( anyString());

    }


    @DisplayName("Specific instantiation")
    @Test
    void getTotalValue() {

        // 1. Prepare a mock to substitute the remote service (@Mock annotation)
        IStockMarketService market = mock(IStockMarketService.class);

        // 2. Create an instance of the subject under test (SuT) and use the mock to set the
        // (remote) service instance
        StocksPortfolio portfolio = new StocksPortfolio(market);

        // 3. Load the mock with the proper expectations (when...thenReturn)
        when( market.getPrice("EBAY")).thenReturn(1.5);
        when( market.getPrice("APPLE")).thenReturn(4.0);

        // 4. Execute the test (use the service in the SuT)
        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("APPLE", 4));
        double result = portfolio.getTotalValue();

        // 5. Verify the result (assert) and the use of the mock (verify)
        assertEquals(19.0, result);
        assertThat( result, is(19.0)); // using hamcrest

        verify(market, times(2)).getPrice( anyString());

    }

}