package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.domain.MilestoneRegister;
import com.nhnacademy.minidooray.gateway.model.MilestoneResponse;
import java.util.List;

public interface MilestoneService {

    List<MilestoneResponse> getMilestones(Long projectId);

    void createMilestone(MilestoneRegister milestoneRegister, Long projectId);

    void updateMilestone(MilestoneRegister milestoneRegister, Long projectId);

    void deleteMilestone(Long milestoneId);

}
