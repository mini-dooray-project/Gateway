package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.TaskRequest;
import com.nhnacademy.minidooray.gateway.model.TaskResponse;
import com.nhnacademy.minidooray.gateway.model.TaskResponseByProjectId;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskAdaptorImpl implements TaskAdaptor {
    private TaskAdaptorProperties taskAdaptorProperties;

    private RestTemplate restTemplate;

    public TaskAdaptorImpl(TaskAdaptorProperties taskAdaptorProperties, RestTemplate restTemplate) {
        this.taskAdaptorProperties = taskAdaptorProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<TaskResponse> getTasks() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<TaskResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks",
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
    public List<TaskResponseByProjectId> getTestsByProjectId(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<TaskResponseByProjectId>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/projects/{projectId}",
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
    public TaskResponse getTask(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<TaskResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/{taskId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, taskId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public TaskResponse createTask(TaskRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<TaskResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks",
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
    public TaskResponse updateTask(Long taskId, TaskRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<TaskResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/{taskId}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, taskId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public DeleteResponse deleteTask(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<DeleteResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/{taskId}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, taskId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }
}
