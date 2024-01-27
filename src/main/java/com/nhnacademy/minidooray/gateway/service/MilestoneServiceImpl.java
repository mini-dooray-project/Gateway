package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.MilestoneAdaptor;
import com.nhnacademy.minidooray.gateway.model.MilestoneResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MilestoneServiceImpl implements MilestoneService {
    private MilestoneAdaptor milestoneAdaptor;

    public MilestoneServiceImpl(MilestoneAdaptor milestoneAdaptor) {
        this.milestoneAdaptor = milestoneAdaptor;
    }

    @Override
    public List<MilestoneResponse> getMilestones(Long projectId) {
        return milestoneAdaptor.getMilestoneByProjectId(projectId);

    }

    @Override
    public void createMilestone() {
        
    }

    @Override
    public void updateMilestone() {

    }

    @Override
    public void deleteMilestone() {

    }
}
