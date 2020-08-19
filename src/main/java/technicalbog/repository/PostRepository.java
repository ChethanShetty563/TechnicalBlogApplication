package technicalbog.repository;

import org.springframework.stereotype.Repository;
import technicalbog.model.Post;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(name = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);

        List<Post> resultList = query.getResultList();

        return resultList;
    }

    public Post getLatestPost() {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, 3);

    }

    public Post createost(Post newPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(newPost);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

        return newPost;


    }

    public Post getPost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class,postId);

    }
    public void updatePost(Post updatedPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            em.merge(updatedPost);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }


    }
    public void deletePost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            Post st = em.find(Post.class,postId);
            em.remove(st);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }

    }
}
