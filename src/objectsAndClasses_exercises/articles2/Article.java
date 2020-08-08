package objectsAndClasses_exercises.articles2;

public class Article {
        private String title;
        private String content;
        private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String edit() {
        return this.content;
    }

    public String changeAuthor() {
        return this.author;
    }

    public String rename() {
        return this.title;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s%n",
                this.title, this.content, this.author);
    }
}
