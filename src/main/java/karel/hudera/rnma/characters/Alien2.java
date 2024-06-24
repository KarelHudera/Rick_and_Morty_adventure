package karel.hudera.rnma.characters;

import karel.hudera.rnma.logic.game.GamePlan;

public class Alien2 extends GameCharacter {
    private GamePlan gamePlan;

    public Alien2(GamePlan gamePlan, String name, String speakString) {
        super(name, speakString);
        this.gamePlan = gamePlan;
    }

    @Override
    public String speak() {
        String answer = super.speak();
        if (this.gamePlan.getInventory().containsItem("bag")) {
            answer = "dsdsd";
        }
        return answer;
    }
}
