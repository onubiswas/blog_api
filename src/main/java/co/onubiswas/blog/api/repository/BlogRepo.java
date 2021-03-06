package co.onubiswas.blog.api.repository;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.res.DetailResponse;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//@Repository
public interface BlogRepo extends CrudRepository<Blog, Integer> {

    @Query("SELECT * from blogs WHERE email = :email")
    List<Blog> findUserBlogs(@Param("email") String email);

    @Query("SELECT * from blogs WHERE draft = 0")
    List<Blog> findAllBlogs();

    @Modifying
    @Transactional
    @Query("UPDATE blogs SET draft = 0 WHERE id = :id ")
    void publishBlog(@Param("id") String id);

    @Query("SELECT * from blogs WHERE id = :id")
    Blog detailBlog(@Param("id") String id);

    @Query("SELECT name from user_accounts WHERE email = :email")
    String findAuthorName(@Param("email") String email);
}
