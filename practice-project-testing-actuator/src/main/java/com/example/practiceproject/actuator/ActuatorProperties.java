package com.example.practiceproject.actuator;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActuatorProperties {
    @Value("${management.server.port}")
    private String port;
}
