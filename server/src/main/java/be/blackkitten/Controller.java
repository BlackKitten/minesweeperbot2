package be.blackkitten;

import be.blackkitten.minesweeper.server.Board;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class Controller {

    private final GameApplicationService gameApplicationService;

    @Inject
    public Controller(GameApplicationService gameApplicationService) {
        this.gameApplicationService = gameApplicationService;
    }

    @RequestMapping(value = "/board")
    public Board getFields(){
        throw new RuntimeException("implement me");
    }

    @RequestMapping(value= "/newGame")
    public void newGame() {

    }

}
