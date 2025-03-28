package org.sorokovsky.lottery.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUser {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String email;
}
