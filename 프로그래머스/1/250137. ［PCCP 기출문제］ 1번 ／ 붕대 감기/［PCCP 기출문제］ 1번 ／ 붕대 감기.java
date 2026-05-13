class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {

        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        int currentHealth = health;
        int prevAttackTime = 0;

        for (int i = 0; i < attacks.length; i++) {

            int attackTime = attacks[i][0];
            int damage = attacks[i][1];

            // 공격 전까지 회복 가능한 시간
            int recoveryTime = attackTime - prevAttackTime - 1;
            
            currentHealth += recoveryTime * x; // 기본 회복
            
            currentHealth += (recoveryTime / t) * y; // 추가 회복
            
            currentHealth = Math.min(currentHealth, health);// 최대 체력
            
            currentHealth -= damage;// 공격 받기
            
            if (currentHealth <= 0) {
                return -1;
            }

            // 이전 공격 시간 갱신
            prevAttackTime = attackTime;
        }

        return currentHealth;
    }
}