import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    private UrlShortener urlShortener;
    private final static String LONG_URL = "slkdksdl/lksklk/sdlkdslkld";
    private final static String BASE_URL = "https://short.url";

    @BeforeEach
    void setUp() {
        urlShortener = new UrlShortener(LONG_URL);
    }

    @Test
    void testShortenUrl() {
        String shortUrl = urlShortener.shortenUrl();
        Assertions.assertThat(shortUrl).isNotBlank().startsWith(BASE_URL);
    }

    @Test
    void testEncode62() {
        String shortUrl = urlShortener.encodedBase62(6767978);
        Assertions.assertThat(shortUrl).isNotBlank().startsWith(BASE_URL);
    }
}
