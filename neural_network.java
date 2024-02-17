import java.util.Scanner;

public class neural_network {

    private int no_of_layers;
    private int[] nodes_of_layer;
    private double[][][] edge_weights;

    public neural_network(int no_of_layers, int[] nodes_of_layer) {
        this.no_of_layers = no_of_layers;
        this.nodes_of_layer = nodes_of_layer;

        // Initialize edge_weights with random values
        edge_weights = new double[no_of_layers - 1][][];

    }

    public void setedge_weights() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < no_of_layers - 1; i++) {
            edge_weights[i] = new double[nodes_of_layer[i]][nodes_of_layer[i + 1]];
            for (int j = 0; j < nodes_of_layer[i]; j++) {
                for (int k = 0; k < nodes_of_layer[i + 1]; k++) {
                    System.out.printf("Enter weight for edge from node %d in layer %d to node %d in layer %d: ", j, i, k, i + 1);
                    edge_weights[i][j][k] = scanner.nextDouble();
                }
            }
        }
    }

    public void query(neural_network nn,Scanner scanner){
         System.out.println("QUERYING WEIGHTS ");
         
        System.out.print("Enter layer index");
        int layer_no = scanner.nextInt();
        System.out.print("enter first node index");
        int node1_no = scanner.nextInt();
        System.out.print("Enter second node index ");
        int node2_no = scanner.nextInt();
        try{
        double weight = nn.getedge_weights(layer_no, node1_no, node2_no);
        System.out.printf("Weight of node %d in layer %d to node %d in layer %d is    :%f ",node1_no,layer_no,node2_no,layer_no+1,weight);}
        catch(Exception e){
            System.out.println("Cannot fetch edge data for the above nodes . Try again !!");
            
        }
    }
    public double getedge_weights(int layer_no, int node1_no, int node2_no) {
        return edge_weights[layer_no][node1_no][node2_no];
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of layers: ");
        int no_of_layers = scanner.nextInt();
        int[] nodes_of_layer = new int[no_of_layers];
        for (int i = 0; i < no_of_layers; i++) {
            System.out.printf("Enter the number of nodes in layer %d: ", i);
            nodes_of_layer[i] = scanner.nextInt();
        }

        neural_network nn = new neural_network(no_of_layers, nodes_of_layer);
        nn.setedge_weights();
        
        int do_u_want_to_query_again=1;
        while (do_u_want_to_query_again==1){
            nn.query(nn,scanner);
	    System.out.println();
            System.out.println("Type 0 if u want to exit or 1 to continue querying !");
            do_u_want_to_query_again=scanner.nextInt();
        }
        {System.out.println("TERMINATING .. THANK YOU !! ");}


    }
}
