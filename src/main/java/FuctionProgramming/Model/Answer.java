package FuctionProgramming.Model;

import java.time.LocalDateTime;
import java.util.List;

public class Answer  {
    private String body;
    private  String tags;
    private LocalDateTime creationDate;
    User user;
    List<Vote> voteList;

    public Answer(String body,String tags, LocalDateTime creationDate, User user,  List<Vote> voteList) {
        this.body = body;
        this.creationDate = creationDate;
        this.tags=tags;
        this.user = user;
        this.voteList=voteList;
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

    public String getTags() {
        return tags;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    @Override
    public int hashCode() {
        return 31*12+5;
    }

    @Override
    public String toString() {
        return "";
    }
}
