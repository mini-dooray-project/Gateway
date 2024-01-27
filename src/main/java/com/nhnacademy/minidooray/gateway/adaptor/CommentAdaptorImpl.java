package com.nhnacademy.minidooray.gateway.adaptor;

import com.nhnacademy.minidooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.minidooray.gateway.model.CommentRequest;
import com.nhnacademy.minidooray.gateway.model.CommentResponse;
import com.nhnacademy.minidooray.gateway.model.DeleteResponse;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommentAdaptorImpl implements CommentAdaptor {
    private RestTemplate restTemplate;
    private TaskAdaptorProperties taskAdaptorProperties;

    @Override
    public List<CommentResponse> getCommentByTask(Long taskId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        //responseEntity
        ResponseEntity<List<CommentResponse>> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/comments/{taskId}",
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
    public CommentResponse createComment(CommentRequest commentRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<CommentRequest> requestEntity = new HttpEntity<>(commentRequest, headers);

        ResponseEntity<CommentResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/comments",
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
    public CommentResponse updateComment(Long taskId, CommentRequest commentRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<CommentRequest> requestEntity = new HttpEntity<>(commentRequest, headers);

        ResponseEntity<CommentResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/comments/{taskId}",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, taskId);
        if (exchange.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException();
        }
        return exchange.getBody();
    }

    @Override
    public DeleteResponse deleteComment(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<DeleteResponse> exchange = restTemplate.exchange(taskAdaptorProperties.getAddress() + "/api/comments/{taskId}",
                HttpMethod.DELETE,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }, taskId);
        return exchange.getBody();
    }
}
