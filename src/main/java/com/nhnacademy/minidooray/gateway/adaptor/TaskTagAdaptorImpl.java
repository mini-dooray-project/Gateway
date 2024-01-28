package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.minidooray.gateway.domain.TaskTagDto;
import com.nhnacademy.minidooray.gateway.domain.TaskTagModifyRequest;
import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.TaskTagResponse;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskTagAdaptorImpl implements TaskTagAdaptor {

    private RestTemplate restTemplate;
    private TaskAdaptorProperties taskAdaptorProperties;

    public TaskTagAdaptorImpl(RestTemplate restTemplate, TaskAdaptorProperties taskAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.taskAdaptorProperties = taskAdaptorProperties;
    }

    @Override
    public List<TaskTagResponse> getTaskTagByTaskId(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<TaskTagResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/{taskId}/tags",
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
    public TaskTagDto createTaskTag(TaskTagDto taskTagDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskTagDto> requestEntity = new HttpEntity<>(taskTagDto, headers);

        ResponseEntity<TaskTagDto> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/tags",
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
    public TaskTagDto updateTaskTagByTag(Long taskId, Long tagId, TaskTagModifyRequest modifyRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskTagModifyRequest> requestEntity = new HttpEntity<>(modifyRequest, headers);

        ResponseEntity<TaskTagDto> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/{taskId}/tags/{tagId}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, taskId, tagId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public DeleteResponse deleteTaskTag(Long taskId, Long tagId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<DeleteResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tasks/{taskId}/tags/{tagId}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, taskId, tagId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }
}
