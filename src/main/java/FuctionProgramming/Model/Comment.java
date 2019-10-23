package FuctionProgramming.Model;

import java.time.LocalDateTime;

public class Comment {

    private String body;
    private LocalDateTime creationDate;
    private User user;

    public Comment(String body, LocalDateTime creationDate, User user) {
        this.body = body;
        this.creationDate = creationDate;
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public User getUser() {
        return user;
    }
    public int getCreationMonth(){
        return this.getCreationDate().getMonthValue();
    }
}
