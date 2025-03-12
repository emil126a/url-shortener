import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String BASE_URL = "https://short.url/";

    public static void main(String[] args) {

        String longUrl = shortenUrl(BASE_URL + "slkdksdl/lksklk/sdlkdslkld");
        System.out.println(BASE_URL + "" + longUrl);
    }


    public static String shortenUrl(String longUrl) {
        int hashCode = longUrl.hashCode();
        int positiveHash = Math.abs(hashCode);

        return encodedBase62(positiveHash);
    }

    public static String encodedBase62(int number) {
        StringBuilder sb = new StringBuilder();

        do {

            char findChar = CHARACTERS.charAt(number % CHARACTERS.length());
            sb.append(findChar);

            number = number / CHARACTERS.length();

        } while (number > 0);

        return sb.toString();
    }
}