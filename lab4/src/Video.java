import java.util.*;
public class Video {
    String title;
    String url;
    int views;
    int likes;
    int dislikes;
    Set<Comment> comments;

    public Video(String title, String url, int views, int likes, int dislikes) {
        this.title = title;
        this.url = url;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = new HashSet<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
