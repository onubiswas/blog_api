package co.onubiswas.blog.api.service;

import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.res.DetailResponse;
import co.onubiswas.blog.api.repository.BlogRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Log4j2
@Component
public class BlogDetailService {

    @Autowired
    public BlogRepo repo;
    DetailResponse dr= new DetailResponse();
    public DetailResponse getBlogDetails(Integer id){
        log.info("Retrieving blog detail from the database");
        Blog blog= repo.detailBlog(id.toString());
        String email = blog.getEmail();
        String author = repo.findAuthorName(email);
        dr.setAuthor(author);
        dr.setDescription(blog.getDescription());
        dr.setImage(blog.getImage());
        dr.setTitle(blog.getTitle());
        return dr;
    }

}
