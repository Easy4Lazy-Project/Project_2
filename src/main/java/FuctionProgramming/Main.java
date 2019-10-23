package FuctionProgramming;

import FuctionProgramming.FP.Functions;
import FuctionProgramming.Model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        //populate lists

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
                "body body for binary search",
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

        List<User> usersList = new ArrayList<>();
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
            add(new Answer("Answer #2 ","",
                    LocalDateTime.of(2019,01,10,9,2),u4,votes1));
            add(new Answer("Answer #3 ","",
                    LocalDateTime.of(2019,02,10,9,2),u4,votes3));
            add(new Answer("Answer #4 ","",
                    LocalDateTime.of(2019,02,10,9,2),u5,votes1));
            add(new Answer("Answer #5 ","",
                    LocalDateTime.of(2019,02,10,9,2),u5,votes1));
            add(new Answer("Answer #6 ","",
                    LocalDateTime.of(2019,02,10,9,2),u5,votes1));
        }};

        u1.getContentList().get(0).setVoteList(votes1);
        //System.out.println(u1.getContentList().get(0).getVoteList());

        u1.getContentList().get(1).setVoteList(votes2);
        u1.getContentList().get(2).setVoteList(votes3);
        u1.getContentList().get(3).setVoteList(votes3);
        u1.getContentList().get(4).setVoteList(votes1);
        List<Comment> commentsList1 = new ArrayList<Comment>(){{
                add(new Comment("Comment 1",
                        LocalDateTime.of(2019, 01, 03, 1, 1),u1)
                );
                add(new Comment("Comment 2",
                        LocalDateTime.of(2019, 02, 03, 1, 1),u2)
                );
            }};

        u1.getContentList().get(0).setCommentList(commentsList1);
        u1.getContentList().get(1).setCommentList(commentsList1);
        u1.getContentList().get(2).setCommentList(commentsList1);
        u1.getContentList().get(3).setCommentList(commentsList1);
        u1.getContentList().get(4).setCommentList(commentsList1);

        List<User> userlist2 = new ArrayList<User>();
        userlist2.add(u1);

        contentListU1.get(0).setAnswerList(ans1);
        contentListU1.get(1).setAnswerList(ans2);


        List<Content> AllContent = new ArrayList<Content>();
        for(int i=0; i<contentListU1.size();i++){
            AllContent.add(contentListU1.get(i));
        }
        for(int i=0; i<contentListU2.size();i++){
            AllContent.add(contentListU2.get(i));
        }

        /*
        for(int i=0; i<contentListU3.size();i++){
            AllContent.add(contentListU3.get(i));
        }
        for(int i=0; i<contentListU4.size();i++){
            AllContent.add(contentListU4.get(i));
        }
        for(int i=0; i<contentListU4.size();i++){
            AllContent.add(contentListU4.get(i));
        }
        */
        //end population lists
        ///########################################################################################################
        System.out.print("Test");
       System.out.println( Functions.questionsPerDate.apply(usersList) );
       System.out.println("-------------------------------------");
       System.out.println(Functions.TopKQuestionsUser.apply(u1,1));
        System.out.println("-------------------------------------");
        System.out.println(Functions.CommentsPerMonth.apply(userlist2,2019));
        System.out.println("###########################################");
        System.out.println(Functions.AverageofAnswersPerUserPerMonth.apply(usersList,AllContent));
        System.out.println("###########################################");


        System.out.println(Functions.questionsPerDate.apply(usersList).size());

        System.out.println("----------------------------------------------");

        System.out.println(contentListU4.get(1));
      System.out.println(Functions.ModerateBadWordFromContent.apply(contentListU4.get(1), Set.of("search", "H")));

        System.out.println("----------------------------------------------");

        System.out.println(Functions.ModerateRepeatedWord.apply("@heloo  heloo  heloo @heloo @heloo" ));

         System.out.println(Functions.ModerateRepeatedWordFormContent.apply(contentListU4.get(1)));

        //System.out.println(Functions.ModerateRepeatedWordFormContent.apply(contentListU4.get(1)));


        //CLI
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a function");
        System.out.println("1.- Users per Month");
        System.out.println("2.- Questions Per Date");
        System.out.println("3.-top Ten Users Vote");
        System.out.println("4.-top Ten Users On Question");
        System.out.println("5.-Average Of Answers Per Questions");
        System.out.println("6.-Questions Without Answers");
        System.out.println("7.-Average Of Answers Per User Per Month");
        System.out.println("8.-Moderate on Bad Word");
        System.out.println("9.-Moderate (Repeated)");
        System.out.println("10.-top K Questions by vote");
        System.out.println("11.-Top K tags");
        System.out.println("12.-Answer Per Month");
        System.out.println("13.-Comment Per Month");
        System.out.println("14.-Search");
        System.out.println("15.-Top K Questions per user");
        System.out.println("Number : ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println(Functions.newUsersPerMonth.apply(usersList));
                break;
            case 2:
                System.out.println(Functions.questionsPerDate.apply(usersList));
                break;
            case 3:
                System.out.println(Functions.getVotesFromUserList.apply(usersList));
                break;
            case 4:
                break;
            case 5:
                System.out.println(Functions.totalNumberOfAnswers.apply(AllContent));

                break;
            case 6:
                break;
            case 7:
                System.out.println(Functions.AverageofAnswersPerUserPerMonth.apply(usersList,AllContent));
                break;
            case 8:
                Set setA = new HashSet();
                setA.add("binary");
                System.out.println("Using 'binary' as example of a bad question");
                System.out.println(AllContent.get(0).getBody());
                System.out.println(Functions.ModerateBadWordFromContent.apply(AllContent.get(0),setA).getBody());

                break;
            case 9:
                System.out.println(AllContent.get(0).getBody());
                System.out.println(Functions.ModerateRepeatedWordFormContent.apply(AllContent.get(0)).getBody());

                break;
            case 10:
                break;
            case 11:
                System.out.println(Functions.getKTags.apply(usersList,5));
                break;
            case 12:
                System.out.println(Functions.answersPerMonth.apply(AllContent));

                break;
            case 13:
                //List<User>,Integer year
                for(int i =0; i<usersList.size();i++){
                    for(int j=0;j<usersList.get(i).getContentList().size();j++){
                        for(int h=0;h<usersList.get(i).getContentList().get(j).getCommentList().size();h++){
                            System.out.println(usersList.get(i).getContentList().get(j).getCommentList().get(h).getCreationDate());
                        }
                    }
                }
                System.out.println(Functions.CommentsPerMonth.apply(usersList,2019));
                break;
            case 14:
                System.out.println("looking for word 'binary'");
                System.out.println(Functions.search.apply(usersList,"binary"));
                break;
            case 15:
                System.out.println(Functions.TopKQuestionsUser.apply(u1,10));
                System.out.println("size of the list: " + Functions.TopKQuestionsUser.apply(u1,10).size());
                break;
        }
        System.out.println("Try another function? 1/0");
        int reset;
        reset = scanner.nextInt();
        if(reset==1){
            main(new String[]{});
        }
    }
}
