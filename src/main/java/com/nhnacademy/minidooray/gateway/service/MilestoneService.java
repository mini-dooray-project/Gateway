package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.model.MilestoneResponse;
import java.util.List;

public interface MilestoneService {

    List<MilestoneResponse> getMilestones(Long projectId);

    void createMilestone();

    void updateMilestone();

    void deleteMilestone();

}
