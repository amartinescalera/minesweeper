package info.antoniomartin.minesweeper.application.shared.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(final String s) {
        super(s);
    }

}
