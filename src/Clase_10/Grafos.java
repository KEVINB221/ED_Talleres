package Clase_10;

import java.util.*;

/**
 * Clase que contiene todas las implementaciones de grafos y sus algoritmos
 */
public class Grafos {
    
    /**
     * ACTIVIDAD 1: Grafo No Dirigido
     */
    static class Graph {
        private Map<String, List<String>> adjList;
        
        public Graph() {
            adjList = new HashMap<>();
        }
        
        public void addVertex(String vertex) {
            if (!adjList.containsKey(vertex)) {
                adjList.put(vertex, new ArrayList<>());
            }
        }
        
        public void addEdge(String src, String dest) {
            addVertex(src);
            addVertex(dest);
            
            if (!adjList.get(src).contains(dest)) {
                adjList.get(src).add(dest);
            }
            if (!adjList.get(dest).contains(src)) {
                adjList.get(dest).add(src);
            }
        }
        
        public void printGraph() {
            for (String vertex : adjList.keySet()) {
                System.out.println(vertex + " -> " + adjList.get(vertex));
            }
        }
        
        // ACTIVIDAD 4: Implementación BFS
        public void bfs(String start) {
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            
            queue.add(start);
            visited.add(start);
            
            while (!queue.isEmpty()) {
                String node = queue.poll();
                System.out.print(node + " ");
                
                for (String neighbor : adjList.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        
        // ACTIVIDAD 5: Implementación DFS
        public void dfs(String start, Set<String> visited) {
            visited.add(start);
            System.out.print(start + " ");
            
            for (String neighbor : adjList.get(start)) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, visited);
                }
            }
        }
    }
    
    /**
     * ACTIVIDAD 2: Grafo Dirigido
     */
    static class DirectedGraph {
        private Map<String, List<String>> adjList;
        
        public DirectedGraph() {
            adjList = new HashMap<>();
        }
        
        public void addUser(String user) {
            if (!adjList.containsKey(user)) {
                adjList.put(user, new ArrayList<>());
            }
        }
        
        public void addEdge(String follower, String followed) {
            addUser(follower);
            addUser(followed);
            
            if (!adjList.get(follower).contains(followed)) {
                adjList.get(follower).add(followed);
            }
        }
        
        public List<String> getFollowers(String user) {
            List<String> followers = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
                if (entry.getValue().contains(user)) {
                    followers.add(entry.getKey());
                }
            }
            return followers;
        }
        
        public void printGraph() {
            for (String user : adjList.keySet()) {
                System.out.println(user + " sigue a: " + adjList.get(user));
            }
        }
    }
    
    /**
     * ACTIVIDAD 3: Grafo Ponderado
     */
    static class WeightedGraph {
        private Map<String, Map<String, Integer>> adjList;
        
        public WeightedGraph() {
            adjList = new HashMap<>();
        }
        
        public void addCity(String city) {
            if (!adjList.containsKey(city)) {
                adjList.put(city, new HashMap<>());
            }
        }
        
        public void addEdge(String src, String dest, int weight) {
            if (weight < 0) {
                throw new IllegalArgumentException("El costo no puede ser negativo");
            }
            
            addCity(src);
            addCity(dest);
            
            adjList.get(src).put(dest, weight);
            adjList.get(dest).put(src, weight);
        }
        
        public Integer getCost(String src, String dest) {
            return adjList.containsKey(src) ? adjList.get(src).get(dest) : null;
        }
        
        public void printGraph() {
            for (String city : adjList.keySet()) {
                System.out.println(city + " tiene las siguientes rutas:");
                for (Map.Entry<String, Integer> route : adjList.get(city).entrySet()) {
                    System.out.println("  → " + route.getKey() + " (costo: " + route.getValue() + ")");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Pruebas de Grafo No Dirigido (Actividad 1)
        System.out.println("=== PRUEBA GRAFO NO DIRIGIDO ===");
        Graph grafo = new Graph();
        grafo.addEdge("Ciudad A", "Ciudad B");
        grafo.addEdge("Ciudad B", "Ciudad C");
        grafo.addEdge("Ciudad A", "Ciudad C");
        grafo.addEdge("Ciudad C", "Ciudad D");
        System.out.println("Grafo no dirigido:");
        grafo.printGraph();
        
        // Prueba BFS (Actividad 4)
        System.out.println("\nRecorrido BFS desde Ciudad A:");
        grafo.bfs("Ciudad A");
        
        // Prueba DFS (Actividad 5)
        System.out.println("\n\nRecorrido DFS desde Ciudad A:");
        Set<String> visited = new HashSet<>();
        grafo.dfs("Ciudad A", visited);
        
        // Pruebas de Grafo Dirigido (Actividad 2)
        System.out.println("\n\n=== PRUEBA GRAFO DIRIGIDO ===");
        DirectedGraph grafoDir = new DirectedGraph();
        grafoDir.addEdge("Usuario 1", "Usuario 2");
        grafoDir.addEdge("Usuario 1", "Usuario 3");
        grafoDir.addEdge("Usuario 2", "Usuario 4");
        grafoDir.addEdge("Usuario 3", "Usuario 2");
        grafoDir.addEdge("Usuario 3", "Usuario 4");
        System.out.println("Grafo dirigido:");
        grafoDir.printGraph();
        
        // Pruebas de Grafo Ponderado (Actividad 3)
        System.out.println("\n=== PRUEBA GRAFO PONDERADO ===");
        WeightedGraph grafoPond = new WeightedGraph();
        grafoPond.addEdge("Ciudad A", "Ciudad B", 10);
        grafoPond.addEdge("Ciudad A", "Ciudad C", 15);
        grafoPond.addEdge("Ciudad B", "Ciudad C", 5);
        grafoPond.addEdge("Ciudad B", "Ciudad D", 20);
        grafoPond.addEdge("Ciudad C", "Ciudad D", 30);
        System.out.println("Grafo ponderado:");
        grafoPond.printGraph();
    }
}