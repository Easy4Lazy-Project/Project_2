package FuctionProgramming.Model;

public class Vote {
    private int vote;
    User user;

    public Vote(int vote, User user) {
        this.vote = vote;
        this.user = user;
    }

    public int getVote() {
        return vote;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "vote=" + vote +
                ", user=" + user +
                '}';
    }
}
