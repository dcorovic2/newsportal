package com.dinosatrovic.newsportal.authserver.resource.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AccessTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
}
