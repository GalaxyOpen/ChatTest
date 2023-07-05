package com.icia.test.Controller;

import com.icia.test.Service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
}
