/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

/**
 *
 * @author WOLFy
 */
public class Node {
    char data; 
    Node left, right; 
  
    public Node(char data) 
    { 
        this.data = data; 
        left = right = null; 
    } 
}
