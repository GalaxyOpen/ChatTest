package com.icia.test.DTO;

import com.icia.test.Entity.GameEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BucketDTO {

    private Long id; // 장바구니 번호
    private Long MemberId; // 회원 번호
    private GameEntity GameId; // 게임 번호

}
