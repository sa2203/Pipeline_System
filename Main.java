import java.util.Scanner;
import java.util.Arrays;
class Graph {
    Scanner sc = new Scanner(System.in);
    Vertex[] vertices;
    Edge[] edges;
    float[][] adjMatrix;
    int e;
    float cost=0;
    Graph(int verSize){
        vertices = new Vertex[verSize];
        adjMatrix = new float[verSize][verSize];
    }

    void acceptVertices(){
        for(int i=0; i<vertices.length; i++){
            System.out.print("Enter the name of the place: ");
            vertices[i] = new Vertex(sc.nextLine(), i);
        }
        System.out.println();
    }

    void acceptEdges(){
        String name;
        float weight;
        System.out.print("Enter the no. of connecting paths:");
        e = sc.nextInt();
        edges = new Edge[2*e];
        sc.nextLine();
        for(int i=0; i<e; i++){
            edges[i] = new Edge();
            edges[i+e] = new Edge();
            System.out.print("Enter source place name: ");
            name = sc.nextLine();
            int j,k;
            for(j=0;j<vertices.length; j++){
                if(vertices[j].name.equalsIgnoreCase(name)){
                    edges[i].source = vertices[j];
                    edges[i+e].destination = vertices[j];
                    break;
                }
            }
            System.out.print("Enter destination place name: ");
            name = sc.nextLine();
            for(k=0;k<vertices.length; k++){
                if(vertices[k].name.equalsIgnoreCase(name)){
                    edges[i].destination = vertices[k];
                    edges[i+e].source = vertices[k];
                    break;
                }
            }
            System.out.print("Enter the distance between them(in kms): ");
            weight = sc.nextFloat();
            sc.nextLine();
            edges[i].weight = weight;
            edges[i+e].weight = weight;
            adjMatrix[j][k] = weight;
            adjMatrix[k][j] = weight;
        }
        System.out.println();

    }

    void kruskal(Edge[] input, int v, int e){
        Arrays.sort(input); //sort all edges in ascending order of their weight
        Edge[] output = new Edge[v-1]; //declare an output array of size one less than the no. of vertices
        int k=0;//k keeps track of the no. of edges added to the output array
        boolean disconnected = false;
        int[] parent = new int[v]; //declare parent array to hold parents of all vertices as they are added in the tree
        //initially the parent of each vertex is the vertex itself
        for(int i=0; i<v; i++){
            parent[i] = i;
        }
        //loop over all the available edges
        for(int i=0; i<2*e; i++){
            //break loop if v-1 edges have already been added to the output array
            if(k==v-1) break;

            Edge currEdge = input[i]; //consider an edge from the input array
            int src_parent = find(currEdge.source.associatedNum, parent); //get the parent of the source of that edge
            int dst_parent = find(currEdge.destination.associatedNum, parent); //get the parent of the destination of that edge
            //if both parents are same, it means a cycle is formed, so that edge is rejected
            //else that edge is included
            if(src_parent!=dst_parent){
                output[k] = currEdge; //add edge to output array
                k++; //increment no. of edges in output array
                parent[src_parent] = dst_parent; //update the parents of added vertices
            }
        }
        //check if the obtained output is connected
        for(int i=0; i<output.length; i++){
            if(output[i]==null){
                System.out.println("Pipeline network cannot be formed as one or more places may be unreachable.");
                disconnected = true;
                break;
            }
        }
        //display MST if obtained output is connected
        if(!disconnected)
            cost=0;
            for(int i=0; i<output.length; i++){
                System.out.println(output[i].source.name+"-->"+output[i].destination.name);
                cost = cost+output[i].weight;
            }
        System.out.println("Total length of obtained network: "+cost);
    }

    //method to trace the parent of a vertex
    int find(int v, int[] parent){
        if(parent[v]==v)
            return v;
        return find(parent[v], parent);
    }

    //method returning the distance of the closest vertex from a given vertex
    int getClosestVertex(float[] distance, boolean[] visited){
        float min = Integer.MAX_VALUE; //initialise min distance to be "infinity"
        int minIdx = -1; //set the index of the vertex with the shortest distance to be -1
        //loop over all the distances present
        for(int i=0; i<distance.length; i++)
        {
            //if the distance from a vertex is less than the current minimum
            //and that vertex is also unvisited, set it as the new minimum
            if(distance[i] < min)
                if(!visited[i])
                {
                    min = distance[i];
                    minIdx = i;
                }
        }
        //return the index at which the minimum distance was found
        return minIdx;
    }
    float[] dijkstrasShortestPath(Vertex src)
    {
        float[] distance = new float[vertices.length];//final shortest distance array
        boolean[] visited = new boolean[vertices.length];//array to tell whether a shortest distance to a vertex has been found

        //initialize all distances to be "infinity" and all vertices to be unvisited
        for(int i=0; i<vertices.length; i++)
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[src.associatedNum] = 0; //set the distance from source vertex to itself to be equal to 0

        //loop over all the vertices
        for(int i=0; i<vertices.length; i++)
        {
            int closestVertex = getClosestVertex(distance, visited); //get the closest vertex
            //if closest vertex is infinite distance away, it means that no other vertex can be reached
            if(closestVertex == -1)
                return distance;

            visited[closestVertex] = true;
            //loop over all the adjacent vertices of the obtained vertex
            for(int j=0; j<vertices.length; j++)
            {
                if(!visited[j])//shortest distance of the vertex j should not have been finalized
                {
                    if(adjMatrix[closestVertex][j] != 0)
                    {
                        float d = distance[closestVertex] + adjMatrix[closestVertex][j];
                        if(d < distance[j])//distance via closestVertex is less than the initial distance
                            distance[j] = d;
                    }
                }
            }
        }
        return distance;
    }
    void displayAdj(){
        for(int i=0; i<adjMatrix.length; i++) {
            //loop over elements of ith row in the adj matrix
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
class Edge implements Comparable<Edge>{
    Vertex source;
    Vertex destination;
    float weight;
    //provide implementation of compareTo method in the interface
    //this method returns an integer which is either +ve, -ve or 0.
    public int compareTo(Edge compareEdge){
        return (int) (this.weight-compareEdge.weight);
    }
}
class Vertex {
    String name;
    int associatedNum;
    Vertex(String name, int num){
        this.name = name;
        associatedNum = num;
    }
    Vertex(){}
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int verNums=0;
        int choice;
        int pipeType=0, unitCost=0, flag=0;
        String source=null;
        float[] minDist;
        Vertex X = new Vertex();
        System.out.print("Enter the no. of places:");
        verNums = sc.nextInt();
        sc.nextLine();
        Graph obj = new Graph(verNums);
        obj.acceptVertices();
        obj.acceptEdges();
        do{
            System.out.println("\nEnter:\n1 to display the adjacency matrix of the layout");
            System.out.println("2 to see the optimised pipeline layout");
            System.out.println("3 to see the cost of the obtained layout\n4 to get the shortest distance between a source place and any other place\n0 to exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    obj.displayAdj();
                    break;
                case 2:
                    obj.kruskal(obj.edges, obj.vertices.length, obj.e);
                    break;
                case 3:
                    System.out.println("Enter the purpose of the pipeline:");
                    System.out.println("1 for drinking water");
                    System.out.println("2 for irrigation water\n3 for CNG\n4 for LPG");
                    System.out.println("5 for crude oil");
                    pipeType = sc.nextInt();
                    sc.nextLine();
                    if(pipeType==1){
                        unitCost=150000; //per km cost
                        System.out.println("PVC pipe will be used. The total cost will be Rs.: "+obj.cost*unitCost);
                        System.out.println("The per kilometer price will be Rs.: "+unitCost);
                    }
                    else if(pipeType==2){
                        unitCost=160000;
                        System.out.println("PVC pipe will be used. The total cost will be Rs.: "+obj.cost*unitCost);
                        System.out.println("The per kilometer price will be Rs.: "+unitCost);
                    }
                    else if(pipeType==3){
                        unitCost=40000;
                        System.out.println("PVC pipe will be used. The total cost will be Rs.: "+obj.cost*unitCost);
                        System.out.println("The per kilometer price will be Rs.: "+unitCost);
                    }

                    else if(pipeType==4){
                        unitCost=120000;
                        System.out.println("PVC pipe will be used. The total cost will be Rs.: "+obj.cost*unitCost);
                        System.out.println("The per kilometer price will be Rs.: "+unitCost);
                    }
                    else{
                        unitCost= 307080;
                        System.out.println("PVC pipe will be used. The total cost will be Rs.: "+obj.cost*unitCost);
                        System.out.println("The per kilometer price will be Rs.: "+unitCost);
                    }
                    break;
                case 4:
                    System.out.println("Enter the source place: ");
                    source=sc.nextLine();
                    for(int i=0; i<obj.vertices.length; i++){
                        if(source.equalsIgnoreCase(obj.vertices[i].name)){
                            flag=1;
                            X = obj.vertices[i];
                            break;
                        }
                    }
                    if(flag==0)
                        System.out.println("Given place was not found in the entered data.");
                    else{
                        minDist = obj.dijkstrasShortestPath(X);
                        for(int j=0; j<obj.vertices.length; j++)
                                System.out.println("Minimum distance to place "+obj.vertices[j].name+" is "+minDist[obj.vertices[j].associatedNum]+".");

                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Exited.");
                    break;
                default:
                    System.out.println("Enter a valid choice.\n");
            }
        } while(choice!=0);
    }
}
