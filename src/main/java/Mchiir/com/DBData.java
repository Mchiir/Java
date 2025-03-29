package Mchiir.com;

public enum DBData {
    URL("jdbc:mysql://localhost:3306/web_downloader_db"),
    USER("root"),
    PASSWORD(""),
    DRIVER("com.mysql.cj.jdbc.Driver");

    private final String value;

    DBData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}