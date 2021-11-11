package co.onubiswas.blog.api.repository;

import co.onubiswas.blog.api.models.domain.Blog;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

//@Repository
public interface BlogRepo extends CrudRepository<Blog, Integer> {

    @Query("SELECT * from blogs WHERE email = :email")
    List<Blog> findUserBlogs(@Param("email") String email);

}
