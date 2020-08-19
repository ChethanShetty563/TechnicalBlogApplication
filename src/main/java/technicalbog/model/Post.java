package technicalbog.model;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "date")
    private Date date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public List<Category> getCategoryList() {
//        return categoryList;
//    }
//
//    public void setCategoryList(List<Category> categoryList) {
//        this.categoryList = categoryList;
//    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Category> categoryList = new ArrayList<>();

//    @Transient
//    private String JavaBlog;
//
//    public String getJavaBlog() {
//        return JavaBlog;
//    }
//
//    public void setJavaBlog(String javaBlog) {
//        this.JavaBlog = javaBlog;
//    }
//
//    public String getSpringBlog() {
//        return SpringBlog;
//    }
//
//    public void setSringBlog(String sringBlog) {
//        this.SpringBlog = sringBlog;
//    }
//
//    @Transient
//    private String SpringBlog;


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
