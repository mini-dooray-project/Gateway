package com.nhnacademy.minidooray.gateway.service;

import com.nhnacademy.minidooray.gateway.adaptor.MilestoneAdaptor;
import com.nhnacademy.minidooray.gateway.domain.MilestoneRegister;
import com.nhnacademy.minidooray.gateway.model.MilestoneRequest;
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
    public void createMilestone(MilestoneRegister milestoneRegister, Long projectId) {
        MilestoneRequest milestoneRequest = new MilestoneRequest(projectId, milestoneRegister.getMilestoneName(),
                milestoneRegister.getStartDate(), milestoneRegister.getMilestoneExpireDate());
        milestoneAdaptor.createMilestone(milestoneRequest);
    }

    @Override
    public void updateMilestone(MilestoneRegister milestoneRegister, Long projectId) {
    }

    @Override
    public void deleteMilestone() {

    }
}
