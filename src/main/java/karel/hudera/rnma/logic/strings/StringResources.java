package karel.hudera.rnma.logic.strings;

/**
 * Provides a centralized location for string resources used throughout the game.
 * This class contains various static constants representing error messages, game instructions,
 * character dialogues, and other game-related text.
 *
 * @author KarelHudera
 */
public class StringResources {

    /** Prefix for error messages. */
    public static final String ERROR_PREFIX = "\uD83D\uDD34 "; // Red circle emoji for errors

    /**
     * Contains strings related to game output and commands.
     */
    public static class GameOut {
        /** Prompt character for user input. */
        public static final String OUTPUT_CHARACTER = "> ";
    }

    /**
     * Contains command keywords used in the game.
     */
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

    /**
     * Contains error messages displayed to the user.
     */
    public static class Errors {
        public static final String SPECIFY_PARAM = ERROR_PREFIX + "Please specify your parameters.";
        public static final String PARAM_DOESNT_EXIST = ERROR_PREFIX + "That doesn't exist.";
        public static final String CANT_GO_THERE = ERROR_PREFIX + "Can't go there.";
        public static final String INVALID_COMMAND = ERROR_PREFIX + "Invalid command, try 'help'";
        public static final String EMPTY_INVENTORY = ERROR_PREFIX + "nothing";
        public static final String CANT_BE_PICKED = ERROR_PREFIX + "This can not be picked";
        public static final String FULL_INVENTORY = ERROR_PREFIX + "Your inventory is full";
        public static final String NONE = ERROR_PREFIX + "None";
        public static final String CHARACTER_NOT_HERE = " is not here.";
        public static final String SPECIFY_MORE_PARAM = ERROR_PREFIX + "You must specify more parameters";
        public static final String SPECIFY_LESS_PARAM = ERROR_PREFIX + "Please specify only one parameter";
        public static final String CHARACTER_IS_DEAD = " is dead";
        public static final String OPEN_SHIELDS = "You can only open shields";
        public static final String GET_GUN = "You can't kill without a weapon";
    }

    /**
     * Contains informational messages for the user.
     */
    public static class Info {
        public static final String WELCOME = "Welcome to the game!";
        public static final String GOOD_LUCK = "Good luck!";
        public static final String YOU_ARE_IN = "You are in: ";
        public static final String INVENTORY = "Inventory: ";
        public static final String ITEMS = "Items: ";
        public static final String CHARACTERS = "Characters: ";
        public static final String ENTRANCES = "Entrances: ";
        public static final String DEAD_CHARACTERS = "Corpses: ";
        public static final String ADDED_TO_INVENTORY = " was added to inventory";
        public static final String REMOVED_FROM_INVENTORY = " was dropped to: ";
        public static final String KILLED = " was killed";
    }

    /**
     * Contains character-specific dialogue strings.
     */
    public static class SpeakStrings {
        public static final String RICK_SPEAK = """
                All right. There's six of us, and that's it.""";
        public static final String RICK_SPEAK_WEAPON = """
                I've got about a thousand memories
                of your dumb, little ass and
                about six of them are pleasant.
                The rest
                is annoying garbage.
                So why don't you do us both
                a favor and pull the trigger?
                Do it!
                Do it, motherfucker!
                Pull the fucking trigger!""";
        public static final String SUMMER_SPEAK = """
                Why am I always your go-to?
                **You remember the time when she kicked your balls**""";
        public static final String BETH_SPEAK = """
                I'm your mother remember?""";
        public static final String JERRY_SPEAK = """
                How do we know I'm real?
                [ Crying ]
                I'm a parasite!
                """;
        public static final String NICKY_SPEAK = """
                Remember that we all got stuck in the elevator together.\s
                And I said: Somebody call for repairs?
                [ Laughing ]
                That was fun.\s
                We really do get into some crazy situations as a family,\s
                mostly when we're cooped up like this.
                L-let's get some fresh air.""";
        public static final String FRANKENSTEIN_SPEAK = """
                I will admit it's suspicious
                that Summer's only friend
                is a magic ballerina lamb
                that we've never seen.""";
        public static final String BUTLER_SPEAK = """
                Do you remember how I saved you in that Nazi submarine?
                Perhaps I'm biased, but if
                that story never happened,
                then I wouldn't still be
                the family butler.""";
        public static final String POOPYBUTTHOLE_SPEAK = "I'm Mr. Poopybutthole";
        public static final String FRIDGE_SPEAK = """
                I-i-i-i everyone has
                bad memories of me.
                You remember
                that one time on the roller coaster?
                [ Screaming ]
                Ooh, man,
                we couldn't stop screaming.
                Beth: Uh, roller coasters aren't bad,
                Mrs. Refrigerator.
                They're thrilling.
                And you've been a perfect
                companion to me my entire life.""";
        public static final String PENCILVESTER_SPEAK = """
                I'm Pencilvester.
                Listen to that name.
                You can't kill me.""";
        public static final String RAPTOR_SPEAK = "Rrrrrrrrrr";
        public static final String STEVE_SPEAK = """
                I wanted to thank you for letting me live here all this time, so I'm treating the family to a vacation!
                others: Thanks, Uncle Steve!
                Summer: Best Uncle ever.""";
    }

    /**
     * Contains introductory messages for the game.
     */
    public static class Intro {
        public static final String INTRO_MESSAGE = "Welcome to Rick and Morty adventure";
    }

    /**
     * Contains outro and game-over messages.
     */
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