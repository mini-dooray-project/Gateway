package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.domain.TaskTagDto;
import com.nhnacademy.minidooray.gateway.domain.TaskTagModifyRequest;
import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.TaskTagResponse;
import java.util.List;

public interface TaskTagAdaptor {
    List<TaskTagResponse> getTaskTagByTaskId(Long taskId);

    TaskTagDto createTaskTag(TaskTagDto taskTagDto);

    TaskTagDto updateTaskTagByTag(Long taskId, Long tagId, TaskTagModifyRequest modifyRequest);

    DeleteResponse deleteTaskTag(Long taskId, Long tagId);

}
