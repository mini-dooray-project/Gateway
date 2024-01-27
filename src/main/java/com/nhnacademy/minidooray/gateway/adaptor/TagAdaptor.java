package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.TagRequest;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import java.util.List;

public interface TagAdaptor {
    List<TagResponse> getTags();

    TagResponse getTag(Long tagId);

    TagResponse createTag(TagRequest request);

    TagResponse updateTag(Long tagId, TagRequest request);

    DeleteResponse deleteTag(Long tagId);
}
