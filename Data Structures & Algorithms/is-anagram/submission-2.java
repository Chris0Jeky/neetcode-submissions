class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> collectionOfCharactersS = new HashMap<>();
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
            if(!collectionOfCharactersS.containsKey(t.charAt(i))){
                return false;
            }
            else{
                collectionOfCharactersS.compute(t.charAt(i), (k, v) -> v - 1);
                if(collectionOfCharactersS.get(t.charAt(i)) < 0){
                    return false;
                }
            }            
        }
        return true;
    }
}
