package com.baizhi.action;

import com.baizhi.entity.Tag;
import com.baizhi.service.TagService;
import com.opensymphony.xwork2.Action;

import java.util.List;

public class TagAction {
    private TagService ts ;
    private Tag tag;
    private List<Tag> tags;
    private String id ;

    public TagService getTs() {
        return ts;
    }

    public void setTs(TagService ts) {
        this.ts = ts;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String saveTag(){
        System.out.println(tag);
        ts.addTag(tag);
        return Action.SUCCESS;
    }
    public String removeTag(){
        ts.delete(id);
        return Action.SUCCESS;
    }
    public String findAll(){
        tags=ts.findAll();
        return Action.SUCCESS;
    }
    public String updateCount(){
        ts.updateCount(id);
        return Action.SUCCESS;
    }

}
