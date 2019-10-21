package FuctionProgramming.Model;

import java.util.List;

public class User {
    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;
    List<Content> contentList;

    public User(String firstName, String lastName, String email, String password, List<Content> contentList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contentList = contentList;
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

}
