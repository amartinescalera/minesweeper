package info.antoniomeh.minesweeper.controller;

import info.antoniomeh.minesweeper.model.Board;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * User: amartin
 * Date: 12/09/13
 */
@Controller
public class MinesWeeperAjaxController {

    @RequestMapping(value="/minesweeper.htm",method= RequestMethod.POST)
    public @ResponseBody
    String addUser(@ModelAttribute(value="minesWeeper") Board board, BindingResult result ){
        String returnText;
        if(!result.hasErrors()){
            returnText = "User has been added to the list. Total number of users are.";
        }else{
            returnText = "Sorry, an error has occur. User has not been added to list.";
        }
        return returnText;
    }


}
