package com.galvanize.lynx.music.share.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProvidePlaylistNameException.class)
    public ResponseEntity<Object> handleProvidePlaylistNameException(
            ProvidePlaylistNameException ex, WebRequest request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode missingPlayListName = mapper.createObjectNode();
        missingPlayListName.put("message", "Playlist name needed");
        String messageObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(missingPlayListName);

        return new ResponseEntity<>(messageObject, HttpStatus.BAD_REQUEST);
    }
}
