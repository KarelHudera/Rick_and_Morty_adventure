package karel.hudera.rnma.Strings;


public class StringResources {
    public static final String ERROR_PREFIX = "\uD83D\uDD34 "; // Red circle emoji for errors

    public static class GameOut {
        public static final String OUTPUT_CHARACTER = "> ";
    }

    public static class Commands {
        public static final String GOTO = "goto";
        public static final String HELP = "help";
        public static final String END_GAME = "endgame";
        public static final String SHOW_INVENTORY = "inventory";
        public static final String PICK = "pick";
        public static final String DROP = "drop";
        public static final String SEARCH = "search";
        public static final String TALK_TO = "talkto";
        public static final String KILL = "kill";
        public static final String OPEN = "open";
    }

    public static class Errors {
        public static final String SPECIFY_PARAM = ERROR_PREFIX + "Please specify your parameters.";
        public static final String PARAM_DOESNT_EXIST = ERROR_PREFIX + "That doesn't exist.";
        public static final String CANT_GO_THERE = ERROR_PREFIX + "Can't go there.";
        public static final String INVALID_COMMAND = ERROR_PREFIX + "Invalid command";
        public static final String EMPTY_INVENTORY = ERROR_PREFIX + "nothing";
        public static final String CANT_BE_PICKED = ERROR_PREFIX + "This can not be picked";
        public static final String FULL_INVENTORY = ERROR_PREFIX + "Your inventory is full";
        public static final String NONE = ERROR_PREFIX + "None";
        public static final String CHARACTER_NOT_HERE = " is not here.";
        public static final String SPECIFY_MORE_PARAM = ERROR_PREFIX + "You must specify more parameters";
        public static final String SPECIFY_LESS_PARAM = ERROR_PREFIX + "Please specify only one parameter";
        public static final String CHARACTER_IS_DEAD = " is dead";
        public static final String OPEN_SHIELDS = "You can only open shields";
    }

    public static class Info {
        public static final String WELCOME = "Welcome to the game!";
        public static final String GOOD_LUCK = "Good luck!";
        public static final String YOU_ARE_IN = "You are in: ";
        public static final String INVENTORY = "Inventory: ";
        public static final String ITEMS = "Items: ";
        public static final String CHARACTERS = "Characters: ";
        public static final String ENTRANCES = "Entrances: ";
        public static final String  DEAD_CHARACTERS = "Corpses: ";
        public static final String ADDED_TO_INVENTORY = " was added to inventory";
        public static final String REMOVED_FROM_INVENTORY = " was dropped to: ";
        public static final String KILLED = " was killed";
    }

    public static class SpeakStrings {
        public static final String RICK_SPEAK = "ẍ̵̨̦́̉̐͗̈̈́ḑ̴̮̗̟̼͇̲̮̘͌͋͑͛́͆̐͠s̴̤̜̿͑͒̐́ď̷͚͌ś̸̢͉̮̺͈̉̂̽̄̈́̈́͜";
        public static final String RICK_SPEAK_WEAPON = "Hello Rick";
        public static final String SUMMER_SPEAK = "Hello Summer";
        public static final String BETH_SPEAK = "Hello Beth";
        public static final String JERRY_SPEAK = "Hello Jerry";
        public static final String NICKY_SPEAK = "Hello Nicky";
        public static final String FRANKENSTEIN_SPEAK = "Hello Frankenstein";
        public static final String BUTLER_SPEAK = "Hello Butler";
        public static final String POOPYBUTTHOLE_SPEAK = "Hello Poopybutthole";
        public static final String FRIDGE_SPEAK = "Hello Fridge";
        public static final String PENCILVESTER_SPEAK = "Hello Pencilvester";
        public static final String RAPTOR_SPEAK = "Hello Raptor";
        public static final String STEVE_SPEAK = "Hello Steve";
    }

    public static class Intro {
        public static final String INTRO_MESSAGE = "Welcome to Rick and Morty adventure";
    }

    public static class Outro {
        public static final String OUTRO_MESSAGE = "Thank you for playing!";
        public static final String GAME_OVER = "Game Over!";
        public static final String GAME_OVER_WIN = "You won";
        public static final String GAME_OVER_LOS = "You lose";
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