package edu.java.dto.response;

import java.net.URI;

public record LinkResponse(
        Long id,
        URI url
) {
}
