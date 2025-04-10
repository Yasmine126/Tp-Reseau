import java.time.format.DateTimeFormatter;

public class Message {
    String username;
    String date;
    int length;
    String content;

    public Message(String username, String content) {
        this.username = username;
        this.content = content;
        this.length = content.length();
        this.date = LocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

    public int getLength() {
        return length;
    }

    public String getContent() {
        return content;
    }
}
