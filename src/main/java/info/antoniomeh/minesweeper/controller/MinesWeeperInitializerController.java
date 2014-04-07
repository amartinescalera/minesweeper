package info.antoniomeh.minesweeper.controller;

import info.antoniomeh.minesweeper.model.Board;
import info.antoniomeh.minesweeper.service.MinesWeeperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * OdigeO
 * User: amartin
 * Date: 11/09/13
 *
 */
@Controller
public class MinesWeeperInitializerController {

    @RequestMapping(value = "/initialize", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        Board minesweeper = new Board();
        model.addAttribute("minesweeper", minesweeper);
        MinesWeeperService.Initialize(minesweeper);
        return "minesweeper";

    }

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public String printWelcome(@ModelAttribute("minesweeper") Board minesweeper, ModelMap model) {

        minesweeper = new Board(minesweeper.getRowNumber(), minesweeper.getColNumber(),minesweeper.getNumberOfMines());
        MinesWeeperService.Initialize(minesweeper);
        model.addAttribute("minesweeper", minesweeper);
        return "minesweeper";

    }
}
