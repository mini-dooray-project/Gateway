package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.minidooray.gateway.model.ProjectRequest;
import com.nhnacademy.minidooray.gateway.model.ProjectResponse;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskApiProjectAdaptorImpl implements TaskApiProjectAdaptor {
    private final RestTemplate restTemplate;
    private final TaskAdaptorProperties taskAdaptorProperties;

    public TaskApiProjectAdaptorImpl(RestTemplate restTemplate, TaskAdaptorProperties taskAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.taskAdaptorProperties = taskAdaptorProperties;
    }

    @Override
    public List<ProjectResponse> getProjects() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<List<ProjectResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/projects",
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
    public List<ProjectResponse> getProject(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<ProjectResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/projects/{id}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, id);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        return null;
    }
}
