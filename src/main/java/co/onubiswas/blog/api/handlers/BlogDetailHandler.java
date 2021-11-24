package co.onubiswas.blog.api.handlers;

import co.onubiswas.blog.api.models.domain.UserAccount;
import co.onubiswas.blog.api.models.res.DetailResponse;
import co.onubiswas.blog.api.service.BlogDetailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Log4j2
@RestController
@RequestMapping(path="api/v1/blog-detail/{id}")
public class BlogDetailHandler {
    @Autowired
            public BlogDetailService svc;

    @GetMapping
    public DetailResponse BlogDeatail(@PathVariable(required = true) String id) {
        try{
            Integer idd = Integer.parseInt(id);
            return svc.getBlogDetails(idd);
        }catch(NumberFormatException e) {
            String error = id + " is not integer";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error, null);
        }
    }
}
