package com.udacity.dogrestapi.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException (String message, Long id) {
        super( message );
        extensions.put( "Invalid dog", id );
    }

    @Override
    public Map<String, Object> getExtensions () {
        return extensions;
    }

    @Override
    public List<SourceLocation> getLocations () {
        return null;
    }

    @Override
    public ErrorClassification getErrorType () {
        return ErrorType.DataFetchingException;
    }
}
