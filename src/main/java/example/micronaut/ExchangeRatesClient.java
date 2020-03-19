package example.micronaut;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.core.convert.format.Format;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import edu.umd.cs.findbugs.annotations.NonNull;
import io.reactivex.Single;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

@Client("https://api.exchangeratesapi.io")
public interface ExchangeRatesClient {
    String DATE_FORMAT = "yyyy-MM-dd";

    @NonNull
    @NotNull
    @Get("/{date}{?base,symbols}")
    Single<ExchangeRates> atDate(@NonNull @NotNull @PastOrPresent @PathVariable @Format(DATE_FORMAT) LocalDate date,
                                 @Nullable @QueryValue Currency base,
                                 @Nullable @QueryValue List<Currency> symbols);
}
