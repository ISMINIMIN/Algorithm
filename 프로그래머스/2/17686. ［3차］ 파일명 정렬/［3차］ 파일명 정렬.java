import java.util.*;

class Solution {
    class FileInfo implements Comparable<FileInfo> {
        String head;
        int number;
        int index;

        public FileInfo(String head, int number, int index) {
            this.head = head;
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(FileInfo f) {
            int headCompare = this.head.compareTo(f.head);
            if (headCompare != 0) return headCompare;

            int numberCompare = this.number - f.number;
            if (numberCompare != 0) return numberCompare;

            return this.index - f.index;
        }
    }

    public String[] solution(String[] files) {
        List<FileInfo> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            fileList.add(parseFileName(files[i], i));
        }

        Collections.sort(fileList);

        String[] answer = new String[files.length];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = files[fileList.get(i).index];
        }

        return answer;
    }

    private FileInfo parseFileName(String file, int index) {
        int headEnd = 0;
        while (headEnd < file.length() && !Character.isDigit(file.charAt(headEnd))) {
            headEnd++;
        }

        int numberEnd = headEnd;
        while (numberEnd < file.length() && Character.isDigit(file.charAt(numberEnd))) {
            numberEnd++;
        }

        String head = file.substring(0, headEnd).toLowerCase();
        int number = Integer.parseInt(file.substring(headEnd, numberEnd));

        return new FileInfo(head, number, index);
    }
}