package FuctionProgramming.Model;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private String firstName ;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    private String lastName ;
    private String email ;
    private String password ;
    private LocalDateTime creationDate;
    List<Content> contentList;

    public User(String firstName, String lastName, String email, String password, LocalDateTime creationDate, List<Content> contentList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contentList = contentList;
        this.creationDate = creationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    @Override
    public String toString() {
        return firstName;
    }
}
