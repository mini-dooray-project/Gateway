package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.Milestone;
import java.util.List;

public interface MilestoneService {
    List<Milestone> getMilestones(Long taskId);

    void createMilestone();

    void updateMilestone();

    void deleteMilestone();

}
