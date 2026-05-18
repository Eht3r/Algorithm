/**
 * 문제 설명
 * - 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞지 않을 수 있다.
 * - 입력된 아이디를 정해진 7단계 처리 과정에 따라 변환하여
 *   규칙에 맞는 추천 아이디를 만들어야 한다.
 *
 * 아이디 규칙
 * - 아이디의 길이는 3자 이상 15자 이하여야 한다.
 * - 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)만 사용할 수 있다.
 * - 마침표(.)는 처음과 끝에 올 수 없다.
 * - 마침표(.)는 연속으로 사용할 수 없다.
 *
 * 처리 과정
 * 1. 모든 대문자를 소문자로 변환한다.
 * 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자를 제거한다.
 * 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 바꾼다.
 * 4. 마침표(.)가 문자열의 처음이나 끝에 있으면 제거한다.
 * 5. 빈 문자열이 되면 "a"를 대입한다.
 * 6. 길이가 16자 이상이면 앞에서부터 15자까지만 남긴다.
 *    - 이때 마지막 문자가 마침표(.)라면 제거한다.
 * 7. 길이가 2자 이하라면 마지막 문자를 반복해서 붙여 길이가 3이 되게 한다.
 *
 * 입력
 * - new_id: 신규 유저가 입력한 아이디 문자열
 *   - 길이는 1 이상 1,000 이하이다.
 *   - 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성된다.
 *
 * 출력
 * - 7단계 처리 과정을 모두 거친 추천 아이디 문자열
 */
class Solution {
    public String solution(String new_id) {        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        StringBuilder sb = new StringBuilder();
        for (char ch : new_id.toCharArray()) {
            if (('a' <= ch && ch <= 'z') || 
                ('0' <= ch && ch <= '9') ||
                ch == '-' || 
                ch == '_' ||
                ch == '.') {
                sb.append(ch);
            }
        }
            
        // 3단계
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == '.' && sb.charAt(i - 1) == '.') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        // 4단계
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 5단계
        if (sb.length() == 0) {
            sb.append('a');
        }

        // 6단계        
        if (sb.length() >= 16) {
            sb.setLength(15);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 7단계
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}