import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> monsterAttack = new HashMap<>();
        
        int maxHealth = health;
        int maxTime = 0;
        for(int[] attack : attacks) {
            monsterAttack.put(attack[0], attack[1]);
            maxTime = Math.max(maxTime, attack[0]);
        }
        
        int currentTime = 1;
        int attackCount = 0;
        while(true) {
            if(currentTime > maxTime) break;
            if(health <= 0) break;
            
            if(monsterAttack.containsKey(currentTime)) {
                attackCount = 0;
                health -= monsterAttack.get(currentTime);
            } else {
                if(health + bandage[1] <= maxHealth) health += bandage[1];
                else health = maxHealth;
                attackCount++;
                if(attackCount == bandage[0]) {
                    if(health + bandage[2] <= maxHealth) health += bandage[2];
                    else health = maxHealth;
                    attackCount = 0;
                }
            }
            
            currentTime++;
        }
        
        return health <= 0 ? -1 : health;
    }
}