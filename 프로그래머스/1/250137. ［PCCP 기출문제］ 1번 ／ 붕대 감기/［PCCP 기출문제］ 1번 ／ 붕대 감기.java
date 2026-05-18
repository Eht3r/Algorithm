
/**
 * [PCCP 기출문제] 1번 - 붕대 감기
 *
 * 어떤 게임 캐릭터는 '붕대 감기' 기술을 사용해 체력을 회복할 수 있다.
 *
 * 붕대 감기 기술은 다음 정보를 가진다.
 * - 시전 시간 t
 * - 1초당 회복량 x
 * - 추가 회복량 y
 *
 * 캐릭터가 공격받지 않고 붕대 감기를 1초 성공할 때마다 체력이 x만큼 회복된다.
 * 단, 현재 체력은 최대 체력 health를 초과할 수 없다.
 *
 * 붕대 감기를 t초 연속으로 성공하면 추가로 y만큼 체력을 회복한다.
 * 추가 회복까지 끝나면 연속 성공 시간은 다시 0초로 초기화된다.
 *
 * 몬스터에게 공격받는 시간에는 체력을 회복할 수 없다.
 * 공격을 받으면 정해진 피해량만큼 현재 체력이 감소한다.
 * 또한 공격을 받으면 붕대 감기 연속 성공 시간이 0으로 초기화된다.
 *
 * 공격을 받은 직후 체력이 0 이하가 되면 캐릭터는 사망한다.
 * 캐릭터가 사망하면 더 이상 회복할 수 없으며 -1을 반환해야 한다.
 *
 * 모든 몬스터의 공격이 끝난 직후 캐릭터가 살아 있다면,
 * 그 시점의 남은 체력을 반환한다.
 *
 * @param bandage 붕대 감기 정보 배열
 *                bandage[0] = 시전 시간 t
 *                bandage[1] = 초당 회복량 x
 *                bandage[2] = 추가 회복량 y
 *
 * @param health 캐릭터의 최대 체력
 *
 * @param attacks 몬스터의 공격 정보 배열
 *                attacks[i][0] = 공격 시간
 *                attacks[i][1] = 피해량
 *                공격 시간은 오름차순이며 중복되지 않는다.
 *
 * @return 모든 공격이 끝난 직후 남은 체력.
 *         공격을 받아 체력이 0 이하가 되면 -1.
 */

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int current = health;
        int success = 0;
        int attackIndex = 0;
        
        for (int t = 1; t <= attacks[attacks.length -1][0]; t++) {
            if (attacks[attackIndex][0] == t) {
                current -= attacks[attackIndex][1];
                success = 0;
                
                if (current <= 0) {
                    return -1;
                }
                
                attackIndex++;
            } else {
                current += bandage[1];
                success += 1;
                
                if (success == bandage[0]) {
                    current += bandage[2];
                    success = 0;
                }
                
                current = Math.min(current, maxHealth);
            }
        }
        
        return current;
    }
}