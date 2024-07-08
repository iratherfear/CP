class DSU {
    int[] dsu;
    DSU(int n) {
        dsu = new int[n + 1];
        Arrays.fill(dsu, -1);
    }

    int find(int u) {
        if(dsu[u] < 0) {
            return u;
        }
        dsu[u] = find(dsu[u]);
        return dsu[u];
    }

    boolean union(int u, int v) {
        int parU = find(u);
        int parV = find(v);
        
        if(parU == parV) {
            return false;
        }
        if(Math.abs(dsu[parU]) < Math.abs(dsu[parV])) {
            dsu[parU] = parV;
        } else {
            dsu[parV] = parU;
        }
        return true;
    }
};