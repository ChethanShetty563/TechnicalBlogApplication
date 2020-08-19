package technicalbog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="category")
    private String category;

//    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
//    private List<Post> post = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
