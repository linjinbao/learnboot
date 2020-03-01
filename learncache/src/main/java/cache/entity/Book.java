package cache.entity;

/**
 * @author linjinbao66@gmail.com
 * date 2020-03-01
 * @apiVersion 0.0.1
 * @apiGroup entity
 * @apiDescription Book实体类
 * @apiParam
 * @apiParamExample
 * @apiSuccess (200)
 * @apiSuccessExample
 */
public class Book {
    private String isbn;
    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
