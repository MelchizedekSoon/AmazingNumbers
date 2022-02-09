class Article implements Comparable<Article> {
    private final String title;
    private final int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        if (this.getSize() == otherArticle.getSize()) {
            if (this.getTitle().compareTo(otherArticle.getTitle()) > 0) {
                return 1;
            } else if (this.getTitle().compareTo(otherArticle.getTitle()) < 0) {
                return -1;
            }
            return 0;
        }
        return this.getSize() > otherArticle.getSize() ? 1 :
                this.getSize() < otherArticle.getSize() ? -1 : 1;
    }
}