import java.util.*;
import java.util.stream.Collectors;

public class VideoBlog {
    String blogger;
    Set<Video> videos;

    public VideoBlog(String blogger) {
        this.blogger = blogger;
        this.videos = new HashSet<>();
    }

    // Функціональність: Зберігати відео у відсортованому порядку за кількістю переглядів
    Map<Integer, Video> sortedVideos = new TreeMap<>(Collections.reverseOrder());

    public void addVideo(Video video) {
        videos.add(video);
        sortedVideos.put(video.views, video);
    }

    // Завдання 1: Знайти загальну сумарну кількість переглядів усіх відео разом.
    public int getTotalViews() {
        return videos.stream()
                .mapToInt(video -> video.views)
                .sum();
    }

    // Завдання 2: Визначити, чи є коментар, що набрав лайків більше, ніж відео,
    // до якого він дописаний.
    public boolean hasCommentWithMoreLikes() {
        return videos.stream()
                .flatMap(video -> video.comments.stream()
                        .filter(comment -> comment.likes > video.likes))
                .findAny()
                .isPresent();
    }

    // Завдання 3: Визначити відео, що набрало найбільшу кількість дізлайків.
    public Set<Video> getVideosWithMostDislikes() {
        int maxDislikes = videos.stream()
                .mapToInt(video -> video.dislikes)
                .max()
                .orElse(Integer.MIN_VALUE);

        return videos.stream()
                .filter(video -> video.dislikes == maxDislikes)
                .collect(Collectors.toSet());
    }
}