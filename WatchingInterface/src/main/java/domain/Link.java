package domain;

public class Link {
    private String linkid;
    private String movieid;
    private String link;
    private String episodename;

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getEpisodename() {
        return episodename;
    }

    public void setEpisodename(String episodename) {
        this.episodename = episodename;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkid='" + linkid + '\'' +
                ", movieid='" + movieid + '\'' +
                ", link='" + link + '\'' +
                ", episodename='" + episodename + '\'' +
                '}';
    }
}
