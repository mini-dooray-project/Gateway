package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.TagAdaptor;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import java.util.List;
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
}
