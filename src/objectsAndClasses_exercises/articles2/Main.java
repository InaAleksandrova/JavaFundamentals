package objectsAndClasses_exercises.articles2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] articleData = scanner.nextLine().split(", ");
            String title = articleData[0];
            String content = articleData[1];
            String author = articleData[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }


        String command = scanner.nextLine();
        switch (command) {
            case "title":
                articles.sort(Comparator.comparing(Article::rename));
                System.out.println(articles.toString().replaceAll("[\\[\\],]", ""));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::edit));
                System.out.println(articles.toString().replaceAll("[\\[\\],]", ""));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::changeAuthor));
                System.out.println(articles.toString().replaceAll("[\\[\\],]", ""));
                break;
        }
    }
}
