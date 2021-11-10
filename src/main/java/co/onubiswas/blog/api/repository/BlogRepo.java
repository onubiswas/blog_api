package co.onubiswas.blog.api.repository;

import co.onubiswas.blog.api.models.domain.Blog;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface BlogRepo extends CrudRepository<Blog, Integer> {

}
