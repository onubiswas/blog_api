package co.onubiswas.blog.api.models.res;

import java.util.ArrayList;
import java.util.List;

public class BlogListsResponse {

    private List<MinimalBlogDetail> items = new ArrayList<>();

    public void addBlogTitle(MinimalBlogDetail s) {
        items.add(s);
    }

    public void setItems(List<MinimalBlogDetail> items) {
        this.items = items;
    }

    public List<MinimalBlogDetail> getItems() {
        return items;
    }


    public static class MinimalBlogDetail {
        private Integer id;
        private String title;

        public MinimalBlogDetail(Integer id, String title) {
            this.id = id;
            this.title = title;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
