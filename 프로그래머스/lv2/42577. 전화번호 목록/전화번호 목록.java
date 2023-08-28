import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) 
            map.put(phoneBook[i], i);
        
        for (int i = 0; i < phoneBook.length; i++)
            for (int j = 0; j < phoneBook[i].length(); j++)
                if (map.containsKey(phoneBook[i].substring(0, j)))
                    return false;

        return true;
    }
}

// TC 15번 실패,, 반례를 모르겠음,,
// class Solution {
//     public boolean solution(String[] phone_book) {
//         Set<String> set = new HashSet<>();
        
//         Arrays.sort(phone_book);
//         System.out.println(Arrays.toString(phone_book));
//         set.add(phone_book[0]);
        
//         for(int i=1; i<phone_book.length; i++) {
//             if(phone_book[i].length() > phone_book[i-1].length()) {
//                 String str = phone_book[i].substring(0, phone_book[i-1].length());
//                 set.add(str);
//             } else {
//                 set.add(phone_book[i]);
//             }
//         }
        
//         return set.size() != phone_book.length ? false : true;
//     }
// }

// 해시 안 쓴거
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
        
//         Arrays.sort(phone_book);
        
//         for(int i=0; i<phone_book.length-1; i++) {
//             if(phone_book[i+1].startsWith(phone_book[i])) {
//                 answer = false;
//                 break;
//             }
//         }
        
//         return answer;
//     }
// }