import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Створення відеоблога та відео
        VideoBlog videoBlog = new VideoBlog("AwesomeBlogger");

        Video video1 = new Video("First Video", "https://www.example.com/first", 1000, 50, 5);
        video1.addComment(new Comment("Great video!", 20, 0));
        video1.addComment(new Comment("I didn't like it", 5, 10));

        Video video2 = new Video("Second Video", "https://www.example.com/second", 1500, 60, 8);
        video2.addComment(new Comment("Amazing content!", 30, 2));

        // Зберігання відео у відсортованому порядку за кількістю переглядів
        videoBlog.addVideo(video1);
        videoBlog.addVideo(video2);

        // Функціональність: Виведення відео у відсортованому порядку за кількістю переглядів
        System.out.println("Відео у відсортованому порядку за кількістю переглядів:");
        for (Video video : videoBlog.sortedVideos.values()) {
            System.out.println(video.title + " - " + video.views + " views");
        }

        // Завдання 1: Знайти загальну сумарну кількість переглядів усіх відео разом.
        int totalViews = videoBlog.getTotalViews();
        System.out.println("Загальна кількість переглядів усіх відео: " + totalViews);

        // Завдання 2: Визначити, чи є коментар, що набрав лайків більше, ніж відео,
        // до якого він дописаний.
        boolean hasCommentWithMoreLikes = videoBlog.hasCommentWithMoreLikes();
        System.out.println("Чи є коментар, що набрав лайків більше за відео: " + hasCommentWithMoreLikes);

        // Завдання 3: Визначити відео, що набрало найбільшу кількість дізлайків.
        Set<Video> videosWithMostDislikes = videoBlog.getVideosWithMostDislikes();
        System.out.println("Відео з найбільшою кількістю дізлайків:");
        for (Video video : videosWithMostDislikes) {
            System.out.println(video.title + " - " + video.dislikes + " dislikes");
        }
    }
}
