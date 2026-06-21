class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> collectionOfCharactersS = new HashMap<>();
        HashMap<Character, Integer> collectionOfCharactersT = new HashMap<>();
        AtomicBoolean solution = new AtomicBoolean(true);
        if (s.length() != t.length())
            return false;

        int currentMaxFrequency = 0;

        for(int i = 0; i < s.length(); i++){
            if(collectionOfCharactersS.containsKey(s.charAt(i)) == false){
                collectionOfCharactersS.put(s.charAt(i), 1);
            }
            else{
                collectionOfCharactersS.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
                if(currentMaxFrequency < collectionOfCharactersS.get(s.charAt(i))){
                    currentMaxFrequency = collectionOfCharactersS.get(s.charAt(i));
                }
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(collectionOfCharactersS.containsKey(t.charAt(i)) == false){
                return false;
            }
            else if(collectionOfCharactersT.containsKey(t.charAt(i)) == false){
                collectionOfCharactersT.put(t.charAt(i), 1);
            }
            else{
                collectionOfCharactersT.computeIfPresent(t.charAt(i), (k, v) -> v + 1);
                if(currentMaxFrequency < collectionOfCharactersT.get(t.charAt(i))){
                    return false;
                }
            }
        }

        collectionOfCharactersT.forEach((k, v) -> {
            if(!collectionOfCharactersS.containsKey(k) ||
               !collectionOfCharactersS.get(k).equals(v)){
                solution.set(false);
                }
            });

        System.out.println(collectionOfCharactersS.toString());

        return solution.get();
    }
}
