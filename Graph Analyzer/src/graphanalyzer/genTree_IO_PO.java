/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

import static graphanalyzer.GenTree.horizontal;
import static graphanalyzer.New_interface1.ec;
import static graphanalyzer.New_interface1.edge;
import static graphanalyzer.New_interface1.i;
import static graphanalyzer.New_interface1.k;
import static graphanalyzer.New_interface1.node;
import static graphanalyzer.New_interface1.node_names;
import static graphanalyzer.New_interface1.edgeFlag;
import static graphanalyzer.New_interface1.edgecount;
import java.awt.geom.Ellipse2D;


/**
 *
 * @author WOLFy
 */
  
class genTree_IO_PO { 

    public static Node buildUtil(char in[], char post[], int inStrt, 
                   int inEnd, Index pIndex,int x,int y,char s,int hlen,int parent) 
    {
        String name;

        if (inStrt > inEnd) 
            return null; 

        name = Character.toString(post[pIndex.index]);
        Node node1 = new Node(post[pIndex.index]); 
        (pIndex.index)--; 

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
            return node1; 
        parent =i;
        int iIndex = search(in, inStrt, inEnd, node1.data); 

        node1.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex,x,y,'r',hlen-35,parent); 
        node1.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex,x,y,'l',hlen-35,parent); 
        k=i;
        edgecount=ec;
        return node1; 
    } 
   
    public static Node buildTree(char in[], char post[], int n) 
    { 
        Index pIndex = new Index(); 
        pIndex.index = n - 1; 
        return buildUtil(in, post, 0, n - 1, pIndex,400,100,'0', horizontal,-1); 
    }
    
    public static int search(char arr[], int strt, int end, int value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i] == value) 
                break; 
        } 
        return i; 
    } 



} 

