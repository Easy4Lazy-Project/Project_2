package FuctionProgramming.Model;

import java.time.LocalDateTime;
import java.util.List;

public  abstract class  Content {

        int id ;
      String body;
      String tags;
      LocalDateTime creationDate;
      User user;

    public abstract void setAnswerList(List<Answer> answerList);

    public abstract void setCommentList(List<Comment> commentList);

    public abstract void setVoteList(List<Vote> voteList);

    public abstract String getTitle();

    public abstract List<Answer> getAnswerList();

    public abstract List<Comment> getCommentList();

    public abstract List<Vote> getVoteList();

    public String getBody() {
        return body;
    }

    public String getTags() {
        return tags;
    }

    public User getUser() {
        return user;
    }

    public abstract LocalDateTime getCreationDate();

    public abstract int getCreationMonth();

    public abstract void setBody(String body);

}
