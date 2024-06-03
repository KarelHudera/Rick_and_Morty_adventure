package karel.hudera.rnma.Strings;


public class StringResources {
    private static final String ERROR_PREFIX = "\uD83D\uDD34 "; // Red circle emoji for errors

    public static class GameOut {
        public static final String OUTPUT_CHARACTER = "> ";
    }

    public static class Commands {
        public static final String GOTO = "goto";
        public static final String HELP = "help";
        public static final String END_GAME = "endgame";
        public static final String SHOW_INVENTORY = "showinventory";
        public static final String PICK = "pick";
        public static final String DROP = "drop";

    }

    public static class Errors {
        public static final String SPECIFY_PARAM = ERROR_PREFIX + "Please specify your parameters.";
        public static final String PARAM_DOESNT_EXIST = ERROR_PREFIX + "That doesn't exist.";
        public static final String CANT_GO_THERE = ERROR_PREFIX + "Can't go there.";
        public static final String INVALID_COMMAND = ERROR_PREFIX + "Invalid command";
        public static final String EMPTY_INVENTORY = ERROR_PREFIX + "nothing";
        public static final String CANT_BE_PICKED = ERROR_PREFIX + "This can not be picked";
        public static final String FULL_INVENTORY = ERROR_PREFIX + "Your inventory is full";
    }

    public static class Info {
        public static final String WELCOME = "Welcome to the game!";
        public static final String GOOD_LUCK = "Good luck!";
        public static final String INVENTORY = "Inventory: ";
        public static final String ADDED_TO_INVENTORY = " was added to inventory";
        public static final String REMOVED_FROM_INVENTORY = " was dropped to: ";
    }

    public static class Intro {
        public static final String INTRO_MESSAGE = "Welcome to Rick and Morty adventure";
    }

    public static class Outro {
        public static final String OUTRO_MESSAGE = "Thank you for playing!";
        public static final String GAME_OVER = "Game Over!";
    }
}


//⠀⠀⠀⠐⣦⣴⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⠀⣻⣿⣿⣿⡄⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⠈⠹⣯⣿⣿⡃⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⢀⣹⣟⣡⡤⠴⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⣠⡶⠋⢹⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣿⣿⡄⠀⠀⠀
//⠀⣼⠃⠀⠀⢀⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⡀⠀⠀
//⢸⠇⠀⠀⠀⣼⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣾⡟⣷⣂⣀⡤⠖
//⠿⠊⠲⣶⠿⠛⠫⣶⣧⣀⣀⡀⠀⠀⠀⠀⣠⠞⠁⣴⣿⡿⠁⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⠀⠀⢀⡿⠀⠉⠉⣩⡿⠀⠀⠀⠉⠀⣼⣿⡿⠁⠀⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⠀⠀⣼⠃⠀⠀⣰⠟⠀⢀⠀⠀⠀⢠⣿⣿⣁⠀⠀⠀⠀⠀⠀⠀
//⠀⠀⠀⠀⢀⡼⠃⠀⠀⢴⣅⠀⠀⠉⠘⠲⠴⠟⠁⠈⠙⢷⡀⠀⠀⠀⠀⠀
//⠀⠀⠀⣰⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⠀⠀⠀⠀⠀
//⠀⠀⠰⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀