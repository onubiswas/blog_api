package co.onubiswas.blog.api.handlers;


import co.onubiswas.blog.api.models.domain.Blog;
import co.onubiswas.blog.api.models.res.PublishResponse;
import co.onubiswas.blog.api.service.PublishService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@Log4j2
@RestController
@RequestMapping


public class PublishHandler {
    @Autowired
    public PublishService svc;

    @GetMapping(path="api/v1/publish/{id}")
    public PublishResponse PublishBlog(@PathVariable(required = true) String id){
        try{
            Integer idd = Integer.parseInt(id);
            return svc.publish(idd);
        } catch (NumberFormatException e) {
            String error = id + " is not integer";
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error, null);
        }

    }




}
