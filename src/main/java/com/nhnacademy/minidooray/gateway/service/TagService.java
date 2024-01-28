package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.model.TagRequest;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import java.util.List;

public interface TagService {
    List<TagResponse> getTages();

    List<TagResponse> getTagsByProjectId(Long projectId);

    void createTag(TagRequest tagRequest);

    void updateTag(Long tagId, TagRequest tagRequest);

    void deleteTag(Long tagId);
}
