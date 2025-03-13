public interface Encode {
    public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final String BASE_URL = "https://short.url/";

    public String encodedBase62(int number);
    public  String shortenUrl();
}
