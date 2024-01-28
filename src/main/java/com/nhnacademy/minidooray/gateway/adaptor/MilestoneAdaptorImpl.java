package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.MilestoneRequest;
import com.nhnacademy.minidooray.gateway.model.MilestoneResponse;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MilestoneAdaptorImpl implements MilestoneAdaptor {
    private TaskAdaptorProperties taskAdaptorProperties;
    private RestTemplate restTemplate;

    public MilestoneAdaptorImpl(TaskAdaptorProperties taskAdaptorProperties, RestTemplate restTemplate) {
        this.taskAdaptorProperties = taskAdaptorProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<MilestoneResponse> getMilestones() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<List<MilestoneResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/milestones",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public MilestoneResponse getMilestone(Long milestoneId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<MilestoneResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/milestones/{milestoneId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, milestoneId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public List<MilestoneResponse> getMilestoneByProjectId(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<List<MilestoneResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/milestones/projects/{projectId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, projectId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public MilestoneResponse createMilestone(MilestoneRequest milestoneRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<MilestoneRequest> requestEntity = new HttpEntity<>(milestoneRequest, headers);

        //responseEntity
        ResponseEntity<MilestoneResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/milestones",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        if (exchange.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public MilestoneResponse updateMilestone(Long milestoneId, MilestoneRequest milestoneRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<MilestoneRequest> requestEntity = new HttpEntity<>(milestoneRequest, headers);

        //responseEntity
        ResponseEntity<MilestoneResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/milestones/{milestoneId}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, milestoneId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public DeleteResponse deleteMilestone(Long milestoneId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<DeleteResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/milestones/{milestoneId}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }
}
