package FuctionProgramming.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question extends Content {

    private String title;
    List<Answer> answerList;
    List<Comment> commentList;
    List<Vote> voteList;


    public Question(String title,  String body, String tags, LocalDateTime creationDate, User user) {
        this.title = title;
        super.body=body;
        super.tags=tags;
        super.creationDate= creationDate;
        super.user=user;
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();

    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public String getTitle() {
        return title;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public LocalDateTime getCreationDate() {
        return super.creationDate;
    }
    public int getCreationMonth(){
        return this.getCreationDate().getMonthValue();
    }

    @Override
    public void setBody(String body) {
        super.body=body;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", answerList=" + answerList +
                ", commentList=" + commentList +
                ", voteList=" + voteList +
                ", body='" + body + '\'' +
                ", tags='" + tags + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
