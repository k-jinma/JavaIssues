public class World {
    private String[] words = {"APPLE", "BANANA", "ORANGE", "STRAW", "GRAPE", "MELON", "LEMON", "CHERRY", "PEACH", "PLUM"};
    private String answer;

    public World() {
        answer = generateAnswer(words);
    }

    private String generateAnswer(String[] words) {
        int index = (int) (Math.random() * words.length);
        return words[index];
    }

    public boolean isCorrect(String guess) {
        return guess.equals(answer);
    }

    public String checkWord(String guess) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if (guess.indexOf(c) == i) {
                result.append("○");
            } else if (guess.contains(String.valueOf(c))) {
                result.append("△");
            } else {
                result.append("×");
            }
        }
        return result.toString();
    }

    public String getAnswer() {
        return answer;
    }
}
