package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.minidooray.gateway.model.ProjectMemberRegisterRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectMemberResponse;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProjectMemberAdaptorImpl implements ProjectMemberAdaptor {
    private RestTemplate restTemplate;
    private TaskAdaptorProperties taskAdaptorProperties;

    public ProjectMemberAdaptorImpl(RestTemplate restTemplate, TaskAdaptorProperties taskAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.taskAdaptorProperties = taskAdaptorProperties;
    }

    @Override
    public List<ProjectMemberResponse> getMembers(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<List<ProjectMemberResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/members/{projectId}",
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
    public ProjectMemberResponse createMember(ProjectMemberRegisterRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectMemberRegisterRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<ProjectMemberResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/members",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                });
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }
}
