// Kaifa Nur Rabbi Auladana
// 055449217
// Sistem Informasi
// UPBJJ Kota Bogor

import java.util.*;

public class DFS {
    private static final Map<String, List<String>> ADJ = new HashMap<>();
    private static final Map<String, Integer> VALUES = new HashMap<>();
    private static final Set<String> VISITED = new LinkedHashSet<>();
    private static final List<String> PATH = new ArrayList<>();

    // Inisialisasi graf
    private static void initGraph() {
        // Node & Nilai: a1(5), a2(3), a3(9), a4(1), a5(7), a6(2), a7(8), a8(4)
        VALUES.put("a1", 5); VALUES.put("a2", 3);
        VALUES.put("a3", 9); VALUES.put("a4", 1);
        VALUES.put("a5", 7); VALUES.put("a6", 2);
        VALUES.put("a7", 8); VALUES.put("a8", 4);

        // Edges (Hubungan antar node)
        addEdge("a1", "a2"); addEdge("a1", "a3");
        addEdge("a2", "a4"); addEdge("a2", "a5");
        addEdge("a3", "a6"); addEdge("a4", "a7");
        addEdge("a5", "a7"); addEdge("a5", "a8");
        addEdge("a6", "a8");
    }

    private static void addEdge(String u, String v) {
        ADJ.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        ADJ.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }
    
    // Tampilan Visual Graf
    private static void printGraphVisualization() {
        System.out.println("--- VISUALISASI GRAF ---");
        System.out.println("            a1 (5)");
        System.out.println("           /      \\");
        System.out.println("        a2 (3)    a3 (9)");
        System.out.println("       /    \\        \\");
        System.out.println("     a4 (1)  a5 (7)    a6 (2)");
        System.out.println("       \\    / \\      /");
        System.out.println("        \\  /   \\    /");
        System.out.println("        a7 (8)    a8 (4)");
        System.out.println("------------------------\n");
    }

    // Logika DFS Rekursif
    private static boolean dfsRec(String u, int target, int depth) {
        System.out.println("  ".repeat(depth) + "Kunjungi " + u + " (Nilai: " + VALUES.get(u) + ")");
        VISITED.add(u);
        PATH.add(u);

        if (VALUES.get(u) == target) {
            System.out.println("  ".repeat(depth) + "*** DITEMUKAN! ***");
            return true;
        }

        List<String> neighbors = ADJ.getOrDefault(u, Collections.emptyList());
        Collections.sort(neighbors); 

        for (String v : neighbors) {
            if (!VISITED.contains(v)) {
                if (dfsRec(v, target, depth + 1)) {
                    return true;
                }
            }
        }

        PATH.remove(PATH.size() - 1);
        return false;
    }

    // Main Program
    public static void main(String[] args) {
        initGraph();
        final String START_NODE = "a1";

        printGraphVisualization();
        //

        // Input Nilai n
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nilai n yang dicari: ");
        int targetN = sc.nextInt();
        sc.close();
        
        System.out.println("\n--- DFS Search | Start: " + START_NODE + ", Target: " + targetN + " ---\n");
        
        boolean found = dfsRec(START_NODE, targetN, 0);
        
        // Output Hasil
        System.out.println("\n--- Hasil DFS ---");
        System.out.println("Status: " + (found ? "DITEMUKAN" : "TIDAK DITEMUKAN"));
        if (found) {
            System.out.println("Path: " + String.join(" -> ", PATH));
        }
        System.out.println("Total Kunjungan: " + VISITED.size() + " " + VISITED);
        System.out.println("-----------------");
    }
}
