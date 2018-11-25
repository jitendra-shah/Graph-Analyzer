/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

import static graphanalyzer.GenTree.horizontal;
import static graphanalyzer.New_interface1.ec;
import static graphanalyzer.New_interface1.edge;
import static graphanalyzer.New_interface1.edgeFlag;
import static graphanalyzer.New_interface1.edgecount;
import static graphanalyzer.New_interface1.i;
import static graphanalyzer.New_interface1.k;
import static graphanalyzer.New_interface1.node;
import static graphanalyzer.New_interface1.node_names;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author WOLFy
 */
public class genTree_IO_PreO {

    Node root; 
    static int preIndex = 0; 
  
    Node buildTree(char in[], char pre[], int inStrt, int inEnd, int x, int y, char s, int hlen, int parent) 
    { 
        if (inStrt > inEnd) 
            return null; 
        
        String name = Character.toString(pre[preIndex]);
        Node tNode = new Node(pre[preIndex++]); 
        
        if(i==-1)
        {
            i++;
            node[i] = new Ellipse2D.Double(x, y, 40, 40);
            node_names[i] = name;
            edgeFlag=1;
        }
        else
        {
            if(s=='r')
            {
                ec++;
                edge[ec][0]=node[parent].getCenterX();
                edge[ec][1]=node[parent].getCenterY();
                x=x+hlen;
                y=y+100;
                i++;
                node[i] = new Ellipse2D.Double(x, y, 40, 40);
                node_names[i] = name;
                edge[ec][2]=node[i].getCenterX();
                edge[ec][3]=node[i].getCenterY();
                
            }
            else if(s=='l')
            {
                ec++;
                edge[ec][0]=node[parent].getCenterX();
                edge[ec][1]=node[parent].getCenterY();
                x=x-hlen;
                y=y+100;
                i++;
                node[i] = new Ellipse2D.Double(x, y, 40, 40);
                node_names[i] = name;
                edge[ec][2]=node[i].getCenterX();
                edge[ec][3]=node[i].getCenterY();
            }
        }
        
        if (inStrt == inEnd) 
            return tNode; 
  
        int inIndex = search(in, inStrt, inEnd, tNode.data); 
        parent=i;
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1,x,y,'l',hlen-35,parent); 
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd,x,y,'r',hlen-35,parent); 
        k=i;
        edgecount=ec;
        return tNode; 
    }
    
    int search(char arr[], int strt, int end, char value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    }



}
