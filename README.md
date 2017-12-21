## Basic algorithms review

### Sorting
* [Insertion](src/main/java/com/sm/algorithms/sort/InsertionSort.java) (iterative, stable, in-place)
```
gradle test --tests com.sm.algorithms.sort.InsertionSortTest
```
* [Merge Sort Top Down](src/main/java/com/sm/algorithms/sort/MergeSortTopDown.java) (recursive, stable)
```
gradle test --tests com.sm.algorithms.sort.MergeSortTopDownTest
```
* [Merge Sort Bottom Up](src/main/java/com/sm/algorithms/sort/MergeSortBottomUp.java) (iterative, stable)
```
gradle test --tests com.sm.algorithms.sort.MergeSortBottomUpTest
```
* [HeapSort](src/main/java/com/sm/algorithms/sort/HeapSort.java) (iterative, stable)
```
gradle test --tests com.sm.algorithms.sort.HeapSortTest
```
* [CountingSort](src/main/java/com/sm/algorithms/sort/CountingSort.java) (iterative, stable)
```
gradle test --tests com.sm.algorithms.sort.CountingSortTest
```

### Tree
* [Check if BST](src/main/java/com/sm/algorithms/tree/BstChecker.java) 
```
gradle test --tests com.sm.algorithms.tree.BstCheckerTest
```
* [Print tree by line](src/main/java/com/sm/algorithms/tree/TreeVisualizer.java) 
* [Merge two trees](src/main/java/com/sm/algorithms/tree/TreeMerger.java) 


### Draph
* [Dfs](src/main/java/com/sm/algorithms/graph/Dfs.java) (Traverse, pathTo)
```
gradle test --tests DfsTest
```
* [Digraph DFS cycle detection](src/main/java/com/sm/algorithms/graph/DigraphDfsCycleDetection.java) (Cycle detection, Traverse, pathTo)
```
gradle test --tests com.sm.algorithms.graph.DigraphDfsCycleDetectionTest
```
* [Bfs](src/main/java/com/sm/algorithms/graph/Bfs.java) (Traverse, pathTo)
```
gradle test --tests com.sm.algorithms.graph.BfsTest
```
* [TopologicalSort](src/main/java/com/sm/algorithms/graph/TopologicalSort.java) (Creates depencency sequence, no cycle detection)
```
gradle test --tests com.sm.algorithms.graph.TopologicalSortTest
```
* [DijkstraShortestPath](src/main/java/com/sm/algorithms/graph/DijkstraShortestPath.java) 
  * Find shortest path, no cycle detection (see cycle detection in DFS digraph cycle detection above), E logV complexity. 
```
gradle test --tests com.sm.algorithms.graph.DijkstraShortestPathTest
```
* [BellmanFordShortestPath](src/main/java/com/sm/algorithms/graph/BellmanFordShortestPath.java) 
  * Find shortest path, negative cycle detection, V*E complexity. 
```
gradle test --tests com.sm.algorithms.graph.BellmanFordShortestPathTest
```

### Dynamic programming
* [Find optimal RodCut to give max price](src/main/java/com/sm/algorithms/dp/RodCutMaxPrice.java) 

---
TODO: Add cycle detection to Dijkstra's shortest path alg