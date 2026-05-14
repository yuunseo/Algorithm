class Solution {

    public String solution(String video_len, String pos,
                           String op_start, String op_end,
                           String[] commands) {

        int video = toSec(video_len);
        int current = toSec(pos);
        int start = toSec(op_start);
        int end = toSec(op_end);

        // 시작 위치가 오프닝 구간인지 체크
        current = skipOpening(current, start, end);

        for (String command : commands) {

            if (command.equals("prev")) {
                current = Math.max(0, current - 10);
            } else {
                current = Math.min(video, current + 10);
            }

            // 명령 수행 후 오프닝 체크
            current = skipOpening(current, start, end);
        }

        return toTime(current);
    }

    // mm:ss -> 초 변환
    private int toSec(String time) {
        String[] arr = time.split(":");
        int min = Integer.parseInt(arr[0]);
        int sec = Integer.parseInt(arr[1]);

        return min * 60 + sec;
    }

    // 초 -> mm:ss 변환
    private String toTime(int time) {
        int min = time / 60;
        int sec = time % 60;

        return String.format("%02d:%02d", min, sec);
    }

    // 오프닝 구간이면 자동 스킵
    private int skipOpening(int current, int start, int end) {
        if (start <= current && current <= end) {
            return end;
        }
        return current;
    }
}