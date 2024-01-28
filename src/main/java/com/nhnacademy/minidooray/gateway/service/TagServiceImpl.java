package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.TagAdaptor;
import com.nhnacademy.minidooray.gateway.model.TagRequest;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    private TagAdaptor tagAdaptor;

    public TagServiceImpl(TagAdaptor tagAdaptor) {
        this.tagAdaptor = tagAdaptor;
    }

    @Override
    public List<TagResponse> getTages() {
        return tagAdaptor.getTags();
    }

    @Override
    public List<TagResponse> getTagsByProjectId(Long projectId) {

        return tagAdaptor.getTagByProjectId(projectId);
    }

    @Override
    public void createTag(TagRequest tagRequest) {
        if (Objects.isNull(tagRequest)) {
            throw new NullPointerException();
        }
        tagAdaptor.createTag(tagRequest);
    }

    @Override
    public void updateTag(Long tagId, TagRequest tagRequest) {
        if (Objects.isNull(tagRequest)) {
            throw new NullPointerException();
        }
        tagAdaptor.updateTag(tagId, tagRequest);
    }

    @Override
    public void deleteTag(Long tagId) {
        tagAdaptor.deleteTag(tagId);
    }
}
