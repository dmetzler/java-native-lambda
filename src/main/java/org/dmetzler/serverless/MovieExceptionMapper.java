package org.dmetzler.serverless;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MovieExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        String response = String.format("{\"type\":\"%s\",\"message\":\"%s\"}", exception.getClass().getSimpleName(),
                exception.getMessage());

        return Response.status(getStatusFromException(exception)).entity(response).build();
    }

    public Status getStatusFromException(Exception e) {
        if (e instanceof MovieNotFoundException) {
            return Status.NOT_FOUND;
        } else {
            return Status.INTERNAL_SERVER_ERROR;
        }
    }

}
