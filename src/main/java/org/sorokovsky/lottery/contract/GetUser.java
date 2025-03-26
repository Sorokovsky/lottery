package org.sorokovsky.lottery.contract;

import java.time.LocalDateTime;

public record GetUser(Long id,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt,
                      String email) {
}
