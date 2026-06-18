class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            int count = 0;
            char current = c;

            while (count < index) {
                current++;

                if (current > 'z') {
                    current = 'a';
                }

                if (!skip.contains(String.valueOf(current))) {
                    count++;
                }
            }

            answer.append(current);
        }

        return answer.toString();
    }
}