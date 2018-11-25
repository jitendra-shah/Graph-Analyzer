/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

import static graphanalyzer.New_interface1.i;
import static graphanalyzer.New_interface1.jTextArea2;
import static graphanalyzer.New_interface1.outnode;
import static graphanalyzer.New_interface1.outnodec;
/**
 *
 * @author WOLFy
 */
public class Hamiltonian_Cycle {
final int V = i+1;
    int path[];

    boolean isSafe(int v, int graph[][], int path[], int pos)
    {

        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
 
        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos)
    {

        if (pos == V)
        {

            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        for (int v = 1; v < V; v++)
        {

            if (isSafe(v, graph, path, pos))
            {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1) == true)
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    int hamCycle(int graph[][])
    {
        path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;
 
        path[0] = 0;
        if (hamCycleUtil(graph, path, 1) == false)
        {
            jTextArea2.append("\nSolution does not exist\n");
            return 0;
        }
 
        printSolution(path);
        return 1;
    }

    void printSolution(int path[])
    {
        int j;
        jTextArea2.append("\nSolution Exists: Following" +
                           " is one Hamiltonian Cycle\n");
        for (j = 0; j < V; j++)
        {
            outnodec++;
            outnode[j]=path[j];
            jTextArea2.append(" " + path[j] + " ");
        }

        outnodec++;
        outnode[j]=path[0];
        jTextArea2.append(" " + path[0] + " ");
    }
}
