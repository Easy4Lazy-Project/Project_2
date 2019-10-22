package FuctionProgramming.FP;


import FuctionProgramming.Model.*;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FunctionsTest {
    List<User> usersList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        User u1 = new User("Hedra","","hedra@mum.edu","12345",
                LocalDateTime.of(2019,3,10,1,1), null);
        User u2 = new User("Eduardo","","Eduardo@mum.edu","12345",
                LocalDateTime.of(2019,5,10,1,1), null);
        User u3 = new User("Adeleke","","Adeleke@mum.edu","12345",
                LocalDateTime.of(2019,1,10,1,1), null);
        User u4 = new User("Ali","","Ali@mum.edu","12345",
                LocalDateTime.of(2019,7,10,1,1),null);
        User u5 = new User("Dany","","Dany@mum.edu","12345",
                LocalDateTime.of(2019,2,10,1,1),null);

        List<Content> contentListU1 = new ArrayList<Content>();

        contentListU1.add(new Question(
                "Binary Search in Java",
                "body for binary search",
                "binary java",
                LocalDateTime.of(2019,01,10,0,0),u1));

        contentListU1.add(new Question(
                "how to inicialize localdatetime",
                "body for localdatetime",
                "localdatetime",
                LocalDateTime.of(2019,02,12,0,0),u1));

        contentListU1.add(new Question(
                "Question 3",
                "body 3",
                "localdatetime",
                LocalDateTime.of(2019,03,12,0,0),u1));
        contentListU1.add(new Question(
                "Question 4",
                "body for 4",
                "localdatetime",
                LocalDateTime.of(2019,04,12,0,0),u1));
        contentListU1.add(new Question(
                "Question 5",
                "body for 5",
                "localdatetime",
                LocalDateTime.of(2019,05,12,0,0),u1));

        List<Content> contentListU2 = new ArrayList<Content>();

        contentListU2.add(new Question(
                "Question 1 user Eduardo",
                "body for binary search",
                "angular",
                LocalDateTime.of(2019,6,10,0,0),u2));
        contentListU2.add(new Question(
                "Question 2 user Eduardo",
                "body for binary search",
                "angular",
                LocalDateTime.of(2019,7,10,0,0),u2));
        contentListU2.add(new Question(
                "Question 3 user Eduardo",
                "body for binary search",
                "angular",
                LocalDateTime.of(2019,8,10,0,0),u2));

        List<Content> contentListU3 = new ArrayList<Content>();

        contentListU3.add(new Question(
                "Question 1 user Adeleke",
                "body for binary search",
                "spring",
                LocalDateTime.of(2019,8,10,0,0),u3));
        contentListU3.add(new Question(
                "Question 2 user Adeleke",
                "body for binary search",
                "spring",
                LocalDateTime.of(2019,8,10,0,0),u3));

        contentListU3.add(new Question(
                "Question 3 user Adeleke",
                "body for binary search",
                "spring",
                LocalDateTime.of(2019,9,10,0,0),u3));

        List<Content> contentListU4 = new ArrayList<Content>();

        contentListU4.add(new Question(
                "Question 1 user Ali",
                "body for binary search",
                "hibernate",
                LocalDateTime.of(2019,9,10,0,0),u4));

        contentListU4.add(new Question(
                "Question 2 user Ali",
                "body for binary search",
                "hibernate",
                LocalDateTime.of(2019,11,10,0,0),u4));

        List<Content> contentListU5 = new ArrayList<Content>();

        contentListU5.add(new Question(
                "Question 1 user Dany",
                "body for binary search",
                "docker",
                LocalDateTime.of(2019,9,10,0,0),u5));

        contentListU5.add(new Question(
                "Question 2 user Dany",
                "body for binary search",
                "docker",
                LocalDateTime.of(2019,9,10,0,0),u5));


        u1.setContentList(contentListU1);
        u2.setContentList(contentListU2);
        u3.setContentList(contentListU3);
        u4.setContentList(contentListU4);
        u5.setContentList(contentListU5);
        //List<User> usersList = new ArrayList<>();
        usersList.add(u1);
        usersList.add(u2);
        usersList.add(u3);
        usersList.add(u4);
        usersList.add(u5);

        //answers part
        List<Vote> votes1 = new ArrayList<Vote>(){{
            add(new Vote(1,u2));
            add(new Vote(1,u3));
            add(new Vote(1,u4));
            add(new Vote(1,u5));
        }};
        List<Vote> votes2 = new ArrayList<Vote>(){{
            add(new Vote(-1,u2));
            add(new Vote(1,u3));
            add(new Vote(-1,u4));
            add(new Vote(1,u5));
        }};
        List<Vote> votes3 = new ArrayList<Vote>(){{
            add(new Vote(1,u3));
            add(new Vote(1,u4));
            add(new Vote(1,u5));
        }};

        List<Answer> ans1 = new ArrayList<Answer>(){{
            add(new Answer("Answer #1 ","",
                    LocalDateTime.of(2019,01,10,9,2),u2,votes1));
            add(new Answer("Answer #2 ","",
                    LocalDateTime.of(2019,01,10,9,2),u3,votes2));
            add(new Answer("Answer #3 ","",
                    LocalDateTime.of(2019,02,10,9,2),u4,votes3));
        }};

        List<Answer> ans2 = new ArrayList<Answer>(){{
            add(new Answer("Answer #1 ","",
                    LocalDateTime.of(2019,01,10,9,2),u2,votes2));
            add(new Answer("Answer #2 ","",
                    LocalDateTime.of(2019,01,10,9,2),u3,votes1));
            add(new Answer("Answer #3 ","",
                    LocalDateTime.of(2019,02,10,9,2),u4,votes3));
            add(new Answer("Answer #4 ","",
                    LocalDateTime.of(2019,02,10,9,2),u5,votes1));
            add(new Answer("Answer #5 ","",
                    LocalDateTime.of(2019,02,10,9,2),u5,votes1));
            add(new Answer("Answer #6 ","",
                    LocalDateTime.of(2019,02,10,9,2),u5,votes1));
        }};

        contentListU1.get(0).setAnswerList(ans1);
        contentListU1.get(1).setAnswerList(ans2);

        //end population lists
    }

    @Test
    public void questionsPerMonthTest(){

        String expected ="[Pair{key=2019-11-10T00:00, value=1}, Pair{key=2019-09-10T00:00, value=4}, Pair{key=2019-08-10T00:00, value=3}, Pair{key=2019-07-10T00:00, value=1}, Pair{key=2019-06-10T00:00, value=1}, Pair{key=2019-05-12T00:00, value=1}, Pair{key=2019-04-12T00:00, value=1}, Pair{key=2019-03-12T00:00, value=1}, Pair{key=2019-02-12T00:00, value=1}, Pair{key=2019-01-10T00:00, value=1}]";
        assertEquals("Test get Question Answers ",Functions.questionsPerMonth.apply(usersList),expected);
    }

    @Test
    public void getTopTenUsersByVoteTest(){

        String expected ="[Pair{key=Adeleke, value=9}, Pair{key=Dany, value=9}, Pair{key=Ali, value=9}, Pair{key=Eduardo, value=7}]";
        assertEquals("Test get Question Answers ",Functions.getTopTenUsersByVote.apply(usersList),expected);
    }

    @Test
    public void getTopKTagsTest(){

        String expected ="[localdatetime, spring, angular, hibernate, docker, binary java]";
        assertEquals("Test get Question Answers ",Functions.getKTags.apply(usersList,7),expected);
    }

    @Test
    public void searchTest(){

        String expected ="[]";
        assertEquals("Test search() ",Functions.search.apply(usersList,"[]"),expected);
    }
}
