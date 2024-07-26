class Trie {
    private class Node {
    
        private int N = 256;
        private List<Node> links;
        private boolean isEnd = false;

        Node() {
            links = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                links.add(null); // Add null values to the list
            }
        }

        void setIsEndFlag() {
            this.isEnd = true;
        }
        
        boolean getIsEndFlag() {
            return this.isEnd;
        }

        Node set(int idx) {
            if(links.get(idx) != null) {
                return links.get(idx);
            }
            Node temp = new Node();
            links.set(idx, temp);
            return temp;
        }

        Node get(int idx) {
            return links.get(idx);
        }
    }
    
    private Node root;
    public Trie() {
        root = new Node();
        root.setIsEndFlag();
    }
    
    public void insert(String word) {
        Node cur = root;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            cur = cur.set((int) word.charAt(i));
        }
        cur.setIsEndFlag();
    }
    
    public boolean search(String word) {
        Node cur = root;
        int n = word.length();

        for(int i = 0; i < n; i++) {
            cur = cur.get((int) word.charAt(i));
            if(cur == null) {
                return false;
            }
        }

        return cur.getIsEndFlag();
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        int n = prefix.length();

        for(int i = 0; i < n; i++) {
            cur = cur.get((int) prefix.charAt(i));
            if(cur == null) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */