public class Dijkstra {
    record Edge(int node, int distance){}
    private int numNodes;
    private Map<Integer, List<Edge>> graph;

    public Dijkstra(int numNodes, Map<Integer, List<Edge>> graph) {
        this.numNodes = numNodes;
        this.graph = graph;
    }

    public Map<Integer, Integer> getFrom(int src) {
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(Edge::distance));
        minHeap.add(new Edge(src, 0));
        Map<Integer, Integer> distance = new HashMap<>();
        int cnt = 0;
        while(cnt < numNodes) {
            Edge top = minHeap.poll();
            int node = top.node();
            int dist = top.distance();
            if(!distance.containsKey(node)) {
                distance.put(node, dist);
                cnt++;
            }
            for(Edge nbr: graph.get(node)) {
                if(distance.containsKey(nbr.node())) {
                    continue;
                }
                Edge newEdge = new Edge(nbr.node(), dist + nbr.distance());
                minHeap.add(newEdge);
            }
        }
        return distance;
    }
}