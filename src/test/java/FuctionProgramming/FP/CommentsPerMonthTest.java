package FuctionProgramming.FP;

import FuctionProgramming.Model.Comment;
import FuctionProgramming.Model.Content;
import FuctionProgramming.Model.Question;
import FuctionProgramming.Model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentsPerMonthTest {
    List<User> u = new ArrayList<User>(){{
        add(new User("Eduardo","","","",
                LocalDateTime.now(),null));
        add(new User("User 2","","","",
                LocalDateTime.now(),null));
    }};
    List<Content> c = new ArrayList<Content>(){{
        add(new Question(
                "Binary Search in Java",
                "body for binary search",
                "binary java",
                LocalDateTime.of(2019,01,10,0,0),u.get(0)));

        add(new Question(
                "how to inicialize localdatetime",
                "body for localdatetime",
                "localdatetime",
                LocalDateTime.of(2019,02,12,0,0),u.get(0)));
    }};
    List<Comment> comm = new ArrayList<Comment>(){{
        add(new Comment("Comment1",LocalDateTime.of(2019,1,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,1,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,1,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,1,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,2,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,2,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,3,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,3,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,3,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,3,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,3,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,3,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,4,1,1,1),u.get(0)));
        add(new Comment("Comment1",LocalDateTime.of(2019,4,1,1,1),u.get(0)));

    }};
    @Before
    public void SetUp(){
        u.get(0).setContentList(c);
        u.get(1).setContentList(new ArrayList<Content>()); //check if works
        u.get(0).getContentList().get(0).setCommentList(comm);
    }
    @Test public void commentsPerMonthTest(){
        List<Pair<Integer,Long>> commentsPerMonth = Functions.CommentsPerMonth.apply(u,2019);
        List<Pair<Integer,Long>> expected = new ArrayList<Pair<Integer,Long>>(){{
            add(new Pair<Integer,Long>(1,(long) 4));
            add(new Pair<Integer,Long>(2,(long) 2));
            add(new Pair<Integer,Long>(3,(long) 6));
            add(new Pair<Integer,Long>(4,(long) 2));
        }};
        Assert.assertTrue(commentsPerMonth.size() == expected.size());
        Assert.assertTrue(commentsPerMonth.get(0).getValue() == expected.get(0).getValue());
        Assert.assertTrue(commentsPerMonth.get(0).getKey() == expected.get(0).getKey());
        Assert.assertTrue(commentsPerMonth.get(1).getValue() == expected.get(1).getValue());
        Assert.assertTrue(commentsPerMonth.get(1).getKey() == expected.get(1).getKey());
        Assert.assertTrue(commentsPerMonth.get(2).getValue() == expected.get(2).getValue());
        Assert.assertTrue(commentsPerMonth.get(2).getKey() == expected.get(2).getKey());
        Assert.assertTrue(commentsPerMonth.get(3).getValue() == expected.get(3).getValue());
        Assert.assertTrue(commentsPerMonth.get(3).getKey() == expected.get(3).getKey());

    }



}

