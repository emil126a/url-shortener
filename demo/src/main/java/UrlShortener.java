import java.util.HashMap;
import java.util.Map;

public class UrlShortener implements Encode {
    private final String longUrl;
    private final Map<String, String> urlMaps = new HashMap<>();

    public UrlShortener(String longUrl) {
        this.longUrl = BASE_URL + longUrl;
    }

    @Override
    public String encodedBase62(int number) {
        StringBuilder sb = new StringBuilder();
        do {
            char findChar = CHARACTERS.charAt(number % CHARACTERS.length());
            sb.append(findChar);

            number = number / CHARACTERS.length();

        } while (number > 0);

        return BASE_URL + sb.toString();
    }

    @Override
    public String shortenUrl() {
        int hashCode = longUrl.hashCode();
        int positiveHash = Math.abs(hashCode);

        for (Map.Entry<String, String> urlMap : urlMaps.entrySet()) {
            if ((urlMap.getKey().equals(longUrl))) {
                return urlMap.getValue();
            }
        }

        urlMaps.put(longUrl, encodedBase62(positiveHash));
        return encodedBase62(positiveHash);
    }
}
