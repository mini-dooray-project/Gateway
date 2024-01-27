package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.MilestoneRequest;
import com.nhnacademy.minidooray.gateway.model.MilestoneResponse;
import java.util.List;

public interface MilestoneAdaptor {
    List<MilestoneResponse> getMilestones();

    MilestoneResponse getMilestone(Long milestoneId);

    MilestoneResponse createMilestone(MilestoneRequest milestoneRequest);

    MilestoneResponse updateMilestone(Long milestoneId, MilestoneRequest milestoneRequest);

    DeleteResponse deleteMilestone(Long milestoneId);
}
