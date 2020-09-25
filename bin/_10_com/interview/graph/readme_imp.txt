 //TODO 1: Dijktra

        _7_BinaryMinHeap<Vertex<Integer>> minHeap = new _7_BinaryMinHeap<>();

        //TODO stores shortest distance from root to every vertex
        Map<Vertex<Integer>,Integer> distance = new HashMap<>();

        //TODO stores parent of every vertex in shortest distance
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();


 //TODO 2:  PrimMST  map of vertex to edge which gave minimum weight to this vertex.

            Map<Vertex<Integer>,Edge<Integer>> vertexEdgeHashMap = new HashMap<>();


//TODO 3: DAGShortest Path

         public Map<Vertex<T>,Integer> shortestPath(_1_Graph<T> graph, Vertex<T> startVertex){

              Map<Vertex<T>,Integer> distance = new HashMap<Vertex<T>,Integer>();

              _15_A_TopologicalSort<T> sort = new _15_A_TopologicalSort<T>();
              //TODO instead of queue in dijkra here topological stack is used
              Deque<Vertex<T>> deque = sort.topSort(graph);
              //TODO startvertex is set to 0

              //todo  Difference from the dikstra is dikstra process min nodes in the heap and here no no heap , infact nodes are processed based on the stack
              distance.put(startVertex, 0);
              while(!deque.isEmpty()){
                  Vertex<T> vertex = deque.poll();
                  for(Edge<T> edge : vertex.getEdges()){
                      if(getDistance(edge.getVertex2(),distance) > getDistance(edge.getVertex1(),distance) + edge.getWeight()){
                          distance.put(edge.getVertex2(), getDistance(edge.getVertex1(),distance) + edge.getWeight());
                      }
                  }
              }

              return distance;
          }

