## Basic algorithms review

### Sorting
* [Insertion](src/main/java/com/sm/algorithms/sort/InsertionSort.java) (iterative, stable, in-place)
```
gradle test --tests InsertionSortTest
```
* [Merge Sort Top Down](src/main/java/com/sm/algorithms/sort/MergeSortTopDown.java) (recursive, stable)
```
gradle test --tests MergeSortTopDownTest
```
* [Merge Sort Bottom Up](src/main/java/com/sm/algorithms/sort/MergeSortBottomUp.java) (iterative, stable)
```
gradle test --tests MergeSortBottomUpTest
```
* [HeapSort](src/main/java/com/sm/algorithms/sort/HeapSort.java) (iterative, stable)
```
gradle test --tests HeapSortTest
```
* [CountingSort](src/main/java/com/sm/algorithms/sort/CountingSort.java) (iterative, stable)
```
gradle test --tests CountingSortTest
```

### Draph
* [Dfs](src/main/java/com/sm/algorithms/graph/Dfs.java) (Traverse, pathTo)
```
gradle test --tests DfsTest
```
* [Digraph DFS cycle detection](src/main/java/com/sm/algorithms/graph/DigraphDfsCycleDetection.java) (Cycle detection, Traverse, pathTo)
```
gradle test --tests DigraphDfsCycleDetectionTest
```
* [Bfs](src/main/java/com/sm/algorithms/graph/Bfs.java) (Traverse, pathTo)
```
gradle test --tests BfsTest
```
* [TopologicalSort](src/main/java/com/sm/algorithms/graph/TopologicalSort.java) (Creates depencency sequence, no cycle detection)
```
gradle test --tests TopologicalSortTest
```
* [DijkstraShortestPath](src/main/java/com/sm/algorithms/graph/DijkstraShortestPath.java) 
  * Find shortest path, no cycle detection (see cycle detection in DFS digraph cycle detection above), E logV complexity. 
```
gradle test --tests DijkstraShortestPathTest
```
* [BellmanFordShortestPath](src/main/java/com/sm/algorithms/graph/BellmanFordShortestPath.java) 
  * Find shortest path, negative cycle detection, V*E complexity. 
```
gradle test --tests BellmanFordShortestPathTest
```


TODO: Add cycle detaction to Dijkstra's shortest path alg