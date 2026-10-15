class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                inDegree.putIfAbsent(ch, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLength = Math.min(w1.length(), w2.length());

            if( w1.length() > w2.length() && w1.startsWith(w2) ) {
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                char a = w1.charAt(j);
                char b = w2.charAt(j);

                if (a != b) {
                    if (graph.get(a).add(b)) {
                        inDegree.put(b, inDegree.get(b) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for( Character ch: inDegree.keySet()){
            if(inDegree.get(ch) == 0){
                queue.offer(ch);
            }
        }
        
        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()){
            Character ch = queue.poll();

            result.append(ch);

            for(Character neigh : graph.get(ch)){
                inDegree.put(neigh,inDegree.get(neigh)-1);

                if(inDegree.get(neigh) == 0) queue.offer(neigh);
            }
        }

        if (result.length() != inDegree.size()) {
            return "";
        }

        return result.toString();


    }
}
