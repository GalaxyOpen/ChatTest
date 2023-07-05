package com.icia.test.DTO;

import lombok.Data;

@Data
public class GameReviewDTO {
    private Long id;
    private String reviewWriter;
    private String reviewContents;
    private Long memberId;
    private Long gameId;
}
