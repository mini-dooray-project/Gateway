package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import com.nhnacademy.minidooray.gateway.model.TagRequest;
import com.nhnacademy.minidooray.gateway.model.TagResponse;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TagAdaptorImpl implements TagAdaptor {
    private RestTemplate restTemplate;
    private TaskAdaptorProperties taskAdaptorProperties;

    public TagAdaptorImpl(RestTemplate restTemplate, TaskAdaptorProperties taskAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.taskAdaptorProperties = taskAdaptorProperties;
    }

    @Override
    public List<TagResponse> getTags() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<TagResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tags",
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
    public TagResponse getTag(Long tagId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<TagResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tags/{tagId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, tagId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public List<TagResponse> getTagByProjectId(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<TagResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tags/project/{projectId}",
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
    public TagResponse createTag(TagRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TagRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<TagResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tags",
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
    public TagResponse updateTag(Long tagId, TagRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TagRequest> requestEntity = new HttpEntity<>(request, headers);


        ResponseEntity<TagResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tags/{tagId}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, tagId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public DeleteResponse deleteTag(Long tagId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<DeleteResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/tags/{tagId}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, tagId);
        if (exchange.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }
}
