package domain;

public class History {
    private String account;
    private Integer movieid;
    private Integer time;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "History{" +
                "account='" + account + '\'' +
                ", movieid=" + movieid +
                ", time=" + time +
                '}';
    }
}
