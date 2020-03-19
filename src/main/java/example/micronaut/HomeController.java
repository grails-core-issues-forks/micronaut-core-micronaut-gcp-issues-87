package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.time.LocalDate;
import java.util.Collections;

@Controller
public class HomeController {

    private final ExchangeRatesClient exchangeRatesClient;

    public HomeController(ExchangeRatesClient exchangeRatesClient) {
        this.exchangeRatesClient = exchangeRatesClient;
    }

    @Get
    public ExchangeRates index() {
        return exchangeRatesClient.atDate(LocalDate.of(2020, 2, 19),
                Currency.USD,
                Collections.singletonList(Currency.EUR)).blockingGet();
    }
}
