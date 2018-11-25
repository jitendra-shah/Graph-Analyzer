/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WOLFy
 */

package graphanalyzer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class New_interface1 extends javax.swing.JFrame {

    /**
     * Creates new form NewInterface
     */
    
    public int x;
    public int y;
    public static Point oldpoint;
    int Xcentre=200,Ycentre=200,w=50,h=50;
    public static Polygon arrowHead[] = new Polygon[50];
    //nodes
    
    public static boolean nodePressed=false;
    public static Ellipse2D node[] = new Ellipse2D[50];
    public static String node_names[] = new String[50];
    public static int outnode[] = new int[50];
    public static int outnodec=-1;
    
    //edges
    public static boolean edgePressed=false;
    public static boolean dedgePressed=false;
    public static boolean wedgePressed=false;
    public static double edge[][] = new double[50][4];
    public static int edgeSource[] = new int[50];
    public static int edgeDest[] = new int[50];
    public static double dedge[][] = new double[50][4];
    public static int weight[] = new int[50];
//    public static int selectedEdge[] =new int[50];
    
    public static int edgecount=-1,ec=-1;
    public static int edgeFlag=-1;
    public static int outedge[]=new int[50];

    //matrix
    public static int graph[][]=new int[50][50];
    public static int wgtmat[][] = new int[50][50];
    public static int e1=-1,e2=-1;
    
    
    //adjaceny List
    public static LinkedList<Integer> adj[] = new LinkedList[50];
    
    //Genrate Tree Infix Postfix

    //others
    
    public static int i=-1;
    public static int k=-1,nodeSelected=0;
    public static double lx1,lx2,ly1,ly2;
    
    
    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void chgButtonState(int val)
    {

    }    
    
    int searchNode(String s)
    {
        for(int j=0;j<=i;j++)
        {
            if(s.equals(node_names[j]))
            {
                return j;
            }
        }
        return -1;
    }
    
    // Used for setting the index of edges present in output to 1
    
    void setoutedge3()
    {
        int count=0;
        for(int j=0;j<=outnodec;j+=2)
        {
            for(int z=0;z<=ec;z++)
            {
                if(node[outnode[j]].getCenterX()==edge[z][0] && node[outnode[j]].getCenterY()==edge[z][1])
                {
                    if(node[outnode[j+1]].getCenterX()==edge[z][2] && node[outnode[j+1]].getCenterY()==edge[z][3])
                    {
                        outedge[count]=z;
                        count++;
                        break;
                    }
                }
                else if(node[outnode[j]].getCenterX()==edge[z][2] && node[outnode[j]].getCenterY()==edge[z][3])
                {
                    if(node[outnode[j+1]].getCenterX()==edge[z][0] && node[outnode[j+1]].getCenterY()==edge[z][1])
                    {
                        outedge[count]=z;
                        count++;
                        break;
                    }
                }
            }
        }

    }
    void setoutedge2()
    {
        int count=0;
        for(int j=0;j<=outnodec;j++)
        {
            for(int z=0;z<=ec;z++)
            {
                if(node[outnode[j]].getCenterX()==edge[z][0] && node[outnode[j]].getCenterY()==edge[z][1])
                {
                    if(node[outnode[j+1]].getCenterX()==edge[z][2] && node[outnode[j+1]].getCenterY()==edge[z][3])
                    {
                        outedge[count]=z;
                        count++;
                        break;
                    }
                }
                else if(node[outnode[j]].getCenterX()==edge[z][2] && node[outnode[j]].getCenterY()==edge[z][3])
                {
                    if(node[outnode[j+1]].getCenterX()==edge[z][0] && node[outnode[j+1]].getCenterY()==edge[z][1])
                    {
                        outedge[count]=z;
                        count++;
                        break;
                    }
                }
            }
        }

    }
    
    
    void setoutedge()
    {
        int count=0;
        for(int j=0;j<=outnodec-1;j++)
        {
            for(int z=0;z<=ec;z++)
            {
                if(node[outnode[j]].getCenterX()==edge[z][0] && node[outnode[j]].getCenterY()==edge[z][1])
                {
                    if(node[outnode[j+1]].getCenterX()==edge[z][2] && node[outnode[j+1]].getCenterY()==edge[z][3])
                    {
                        outedge[count]=z;
                        count++;
                        break;
                    }
                }
                else if(node[outnode[j]].getCenterX()==edge[z][2] && node[outnode[j]].getCenterY()==edge[z][3])
                {
                    if(node[outnode[j+1]].getCenterX()==edge[z][0] && node[outnode[j+1]].getCenterY()==edge[z][1])
                    {
                        outedge[count]=z;
                        count++;
                        break;
                    }
                }
            }
        }
    }
    
    void updateKruskalObject(Kruskal ob)
    {
        for(int j=0;j<=ec;j++)
        {
            ob.edge[j].src = edgeSource[j];
            ob.edge[j].dest = edgeDest[j];
            ob.edge[j].weight = wgtmat[edgeSource[j]][edgeDest[j]];           
        }
    }
    
    void initialize()
    {
        outnodec=-1;
        edgecount=-1;
        edgeFlag=-1;
        ec=-1;
        e1=-1;
        e2=-1;
        i=-1;
        k=-1;
        nodeSelected=0;
    }
    
    public New_interface1() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        undirected_edge = new javax.swing.JButton();
        wt_edge = new javax.swing.JButton();
        directed_edge = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        gen_mat = new javax.swing.JButton();
        gen_adj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        algo_select = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                if(edgecount!=-1)
                {
                    //   node[i] = new Ellipse2D.Double(Xcentre, Ycentre, w, h);
                    if(edgeFlag==1)
                    {
                        for(int j=0;j<=ec;j++){
                            g2.setStroke(new BasicStroke(3));
                            g2.setColor(Color.BLUE);
                            g2.drawLine((int)edge[j][0],(int)edge[j][1],(int)edge[j][2],(int)edge[j][3]);
                        }
                    }
                    else if(edgeFlag==2)
                    {
                        int v1x,v1y,v2x,v2y,v3x,v3y;
                        for(int j=0;j<=ec;j++){
                            g2.setStroke(new BasicStroke(3));
                            g2.setColor(Color.BLUE);
                            g2.drawLine((int)edge[j][0],(int)edge[j][1],(int)edge[j][2],(int)edge[j][3]);
                            int centerX=(int)edge[j][2];
                            int centerY=(int)edge[j][3];
                            v1x=(int)edge[j][2]-20;
                            v1y=(int)edge[j][3];
                            v2x=(int)edge[j][2]-45;
                            v2y=(int)edge[j][3]+8;
                            v3x=(int)edge[j][2]-45;
                            v3y=(int)edge[j][3]-8;
                            double angle = Math.atan2(edge[j][3]-edge[j][1], edge[j][2]-edge[j][0]);
                            int x1r = (int) ((v1x - centerX) * Math.cos(angle) - (v1y - centerY) * Math.sin(angle) + centerX);
                            int y1r = (int) ((v1x - centerX) * Math.sin(angle) + (v1y - centerY) * Math.cos(angle) + centerY);

                            int x2r = (int) ((v2x - centerX) * Math.cos(angle) - (v2y - centerY) * Math.sin(angle) + centerX);
                            int y2r = (int) ((v2x - centerX) * Math.sin(angle) + (v2y - centerY) * Math.cos(angle) + centerY);

                            int x3r = (int) ((v3x - centerX) * Math.cos(angle) - (v3y - centerY) * Math.sin(angle) + centerX);
                            int y3r = (int) ((v3x - centerX) * Math.sin(angle) + (v3y - centerY) * Math.cos(angle) + centerY);
                            arrowHead[j]=new Polygon();
                            arrowHead[j].addPoint(x1r,y1r);
                            arrowHead[j].addPoint(x2r,y2r);
                            arrowHead[j].addPoint(x3r,y3r);
                            //                   tx.translate(dedge[j][2]-50, dedge[j][3]-50);
                            //                   tx.rotate((angle-Math.PI/2d));
                            //                   tx.createTransformedShape(arrowHead[j]);
                            //                   g2.rotate(Math.toDegrees(Math.atan2(((int)dedge[j][3]-(int)dedge[j][1])/((int)dedge[j][2]-(int)dedge[j][0]))));
                            //                   g2.rotate(45);
                            g2.fill(arrowHead[j]);
                        }
                    }
                    else if(edgeFlag==3)
                    {
                        /*                int v1x,v1y,v2x,v2y,v3x,v3y;
                        for(int j=0;j<=ec;j++){
                            g2.setStroke(new BasicStroke(3));
                            g2.setColor(Color.BLUE);
                            g2.drawLine((int)edge[j][0],(int)edge[j][1],(int)edge[j][2],(int)edge[j][3]);
                            int centerX=(int)edge[j][2];
                            int centerY=(int)edge[j][3];
                            v1x=(int)edge[j][2]-20;
                            v1y=(int)edge[j][3];
                            v2x=(int)edge[j][2]-45;
                            v2y=(int)edge[j][3]+8;
                            v3x=(int)edge[j][2]-45;
                            v3y=(int)edge[j][3]-8;
                            double angle = Math.atan2(edge[j][3]-edge[j][1], edge[j][2]-edge[j][0]);
                            int x1r = (int) ((v1x - centerX) * Math.cos(angle) - (v1y - centerY) * Math.sin(angle) + centerX);
                            int y1r = (int) ((v1x - centerX) * Math.sin(angle) + (v1y - centerY) * Math.cos(angle) + centerY);

                            int x2r = (int) ((v2x - centerX) * Math.cos(angle) - (v2y - centerY) * Math.sin(angle) + centerX);
                            int y2r = (int) ((v2x - centerX) * Math.sin(angle) + (v2y - centerY) * Math.cos(angle) + centerY);

                            int x3r = (int) ((v3x - centerX) * Math.cos(angle) - (v3y - centerY) * Math.sin(angle) + centerX);
                            int y3r = (int) ((v3x - centerX) * Math.sin(angle) + (v3y - centerY) * Math.cos(angle) + centerY);
                            arrowHead[j]=new Polygon();
                            arrowHead[j].addPoint(x1r,y1r);
                            arrowHead[j].addPoint(x2r,y2r);
                            arrowHead[j].addPoint(x3r,y3r);
                            //                   tx.translate(dedge[j][2]-50, dedge[j][3]-50);
                            //                   tx.rotate((angle-Math.PI/2d));
                            //                   tx.createTransformedShape(arrowHead[j]);
                            //                   g2.rotate(Math.toDegrees(Math.atan2(((int)dedge[j][3]-(int)dedge[j][1])/((int)dedge[j][2]-(int)dedge[j][0]))));
                            //                   g2.rotate(45);
                            g2.fill(arrowHead[j]);*/
                            for(int j=0;j<=ec;j++){
                                g2.setStroke(new BasicStroke(3));
                                g2.setColor(Color.BLUE);
                                g2.drawLine((int)edge[j][0],(int)edge[j][1],(int)edge[j][2],(int)edge[j][3]);

                                g2.setColor(Color.BLACK);
                                g2.setFont(new Font("default", Font.BOLD, 16));
                                g2.drawString(Integer.toString(weight[j]),(int)((edge[j][0]+edge[j][2])/2)+15,(int)((edge[j][1]+edge[j][3])/2)+15);
                            }
                        }
                    }
                    if(i!=-1)
                    {
                        //   node[i] = new Ellipse2D.Double(Xcentre, Ycentre, w, h);
                        for(int j=0;j<=k;j++){
                            g2.setColor(Color.RED);
                            g2.fill(node[j]);
                            g2.setColor(Color.BLACK);
                            int diff=(int)g2.getFontMetrics().getStringBounds(node_names[j], g2).getWidth();
                            g2.drawString(node_names[j],(int)(node[j].getCenterX()-diff/2),(int)(node[j].getCenterY()+diff/3));
                        }
                    }

                };
            };
            gen_wgt_mat = new javax.swing.JButton();

            javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
            jFrame1.getContentPane().setLayout(jFrame1Layout);
            jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
            );
            jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel2.setBackground(new java.awt.Color(204, 255, 204));
            jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphanalyzer/1024px-Location_dot_red.png"))); // NOI18N
            jButton1.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.jButton1.text_1")); // NOI18N
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            undirected_edge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphanalyzer/LINE_1.png"))); // NOI18N
            undirected_edge.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.undirected_edge.text")); // NOI18N
            undirected_edge.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    undirected_edgeActionPerformed(evt);
                }
            });

            wt_edge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphanalyzer/w2LINE.png"))); // NOI18N
            wt_edge.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.wt_edge.text_1")); // NOI18N
            wt_edge.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    wt_edgeActionPerformed(evt);
                }
            });

            directed_edge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphanalyzer/dLINE.png"))); // NOI18N
            directed_edge.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.directed_edge.text")); // NOI18N
            directed_edge.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    directed_edgeActionPerformed(evt);
                }
            });

            jButton2.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.jButton2.text_1")); // NOI18N
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(directed_edge, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(undirected_edge, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wt_edge, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(24, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(51, 51, 51))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(undirected_edge, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(47, 47, 47)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(directed_edge, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wt_edge, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addComponent(jButton2)
                    .addContainerGap(91, Short.MAX_VALUE))
            );

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            jLabel1.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.jLabel1.text_1")); // NOI18N

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);

            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
            jLabel2.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.jLabel2.text")); // NOI18N

            gen_mat.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.gen_mat.text")); // NOI18N
            gen_mat.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    gen_matActionPerformed(evt);
                }
            });

            gen_adj.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.gen_adj.text")); // NOI18N
            gen_adj.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    gen_adjActionPerformed(evt);
                }
            });

            jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
            jLabel3.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.jLabel3.text")); // NOI18N

            jTextArea2.setColumns(20);
            jTextArea2.setRows(5);
            jScrollPane2.setViewportView(jTextArea2);

            algo_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DETECT CYCLE", "HAMILTONIAN CYCLE", "BFS", "DFS", "Tree from infix and (postfix or prefix)", "Prims", "Kruskal", "Dijsktra", " " }));

            jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
            jLabel4.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.jLabel4.text")); // NOI18N

            jButton7.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.jButton7.text")); // NOI18N
            jButton7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton7ActionPerformed(evt);
                }
            });

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    jPanel1MouseDragged(evt);
                }
            });
            jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel1MouseClicked(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    jPanel1MousePressed(evt);
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel1MouseReleased(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 688, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 371, Short.MAX_VALUE)
            );

            gen_wgt_mat.setText(org.openide.util.NbBundle.getMessage(New_interface1.class, "New_interface1.gen_wgt_mat.text_1")); // NOI18N
            gen_wgt_mat.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    gen_wgt_matActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(algo_select, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton7))
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gen_wgt_mat)
                            .addGap(18, 18, 18)
                            .addComponent(gen_adj, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(gen_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(18, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gen_adj)
                        .addComponent(gen_mat)
                        .addComponent(gen_wgt_mat))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(algo_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    i++;
    k=i;
    nodePressed=true;
    edgePressed=false;
    dedgePressed=false;
    node[i]=new Ellipse2D.Double(Xcentre, Ycentre, w, h);
    
    String name=JOptionPane.showInputDialog(jFrame1,"Enter node name");
    node_names[i]=name;
    
    adj[i] = new LinkedList();
    
    jPanel1.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void undirected_edgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undirected_edgeActionPerformed
       edgeFlag=1;
       edgePressed=true;
       nodePressed=false;  
       dedgePressed=false;
       directed_edge.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_undirected_edgeActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        x = evt.getX();
        y = evt.getY();
        if(edgePressed)
        {
            for(int j=0;j<=i;j++)
            {
                if(node[j].contains(x,y))
                {
                    if(nodeSelected==0)
                    {
                        e1=j;
                        lx1 = node[j].getBounds().getCenterX();
                        lx2 = node[j].getBounds().getCenterY();
                        nodeSelected=1;
                    }
                    else
                    {
                        e2=j;
                        edgecount++;
                        edgeSource[edgecount]=e1;
                        edgeDest[edgecount]=e2;
                        ec=edgecount;
                        ly1 = node[j].getBounds().getCenterX();
                        ly2 = node[j].getBounds().getCenterY();
                        if(ly1!=lx1 && ly2!=lx2)
                        {
                            nodeSelected=0;
                            edge[edgecount][0]=lx1;
                            edge[edgecount][1]=lx2;
                            edge[edgecount][2]=ly1;
                            edge[edgecount][3]=ly2;
                            lx1=lx2=ly1=ly2=-1;
                            edgePressed=false;
                            nodePressed=true;
                            jPanel1.repaint();
//                      System.out.print("dsds");

//For bidirectional graph
                            graph[e1][e2]=1;
                            graph[e2][e1]=1;
                            addEdge(e1,e2);
//                          addEdge(e2,e1);
                            e1=-1;e2=-1;
                        }
                    }
                    
                    }
                }
            }
        else if(dedgePressed)
        {
            for(int j=0;j<=i;j++)
            {
                if(node[j].contains(x,y))
                {
                    if(nodeSelected==0)
                    {
                        e1=j;
                        lx1 = node[j].getBounds().getCenterX();
                        lx2 = node[j].getBounds().getCenterY();
                        nodeSelected=1;
                    }
                    else
                    {
                        e2=j;
                        edgecount++;
                        ec=edgecount;
                        edgeSource[edgecount]=e1;
                        edgeDest[edgecount]=e2;
                        ly1 = node[j].getBounds().getCenterX();
                        ly2 = node[j].getBounds().getCenterY();
                        if(ly1!=lx1 && ly2!=lx2)
                        {
                            nodeSelected=0;
                            edge[edgecount][0]=lx1;
                            edge[edgecount][1]=lx2;
                            edge[edgecount][2]=ly1;
                            edge[edgecount][3]=ly2;
                            lx1=lx2=ly1=ly2=-1;
                            dedgePressed=false;
                            nodePressed=true;
                            jPanel1.repaint();
//                          System.out.print("dsds");

//For bidirectional graph
                            graph[e1][e2]=1;
                            adj[e1].add(e2);
                            e1=-1;e2=-1;
                        }
                    }
                    
                    }
                }
            }   
        else if(wedgePressed)
        {
            for(int j=0;j<=i;j++)
            {
                if(node[j].contains(x,y))
                {
                    if(nodeSelected==0)
                    {
                        e1=j;
                        lx1 = node[j].getBounds().getCenterX();
                        lx2 = node[j].getBounds().getCenterY();
                        nodeSelected=1;
                    }
                    else
                    {
                        e2=j;
                        edgecount++;
                        ec=edgecount;
                        edgeSource[edgecount]=e1;
                        edgeDest[edgecount]=e2;
                        ly1 = node[j].getBounds().getCenterX();
                        ly2 = node[j].getBounds().getCenterY();
                        if(ly1!=lx1 && ly2!=lx2)
                        {
                            nodeSelected=0;
                            edge[edgecount][0]=lx1;
                            edge[edgecount][1]=lx2;
                            edge[edgecount][2]=ly1;
                            edge[edgecount][3]=ly2;
                            lx1=lx2=ly1=ly2=-1;
                            dedgePressed=false;
                            nodePressed=true;
                            String name=JOptionPane.showInputDialog(jFrame1,"Enter edge weight");
                            weight[edgecount]=Integer.parseInt(name);
                            jPanel1.repaint();
                            
//                          System.out.print("dsds");

//For bidirectional graph
                            graph[e1][e2]=1;
                            wgtmat[e1][e2]=weight[edgecount];
                            wgtmat[e2][e1]=weight[edgecount];
                            adj[e1].add(e2);
                            e1=-1;e2=-1;
                        }
                    }
                    
                    }
                }
            }// TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();

        if(nodePressed)
        {
        for(int j=0;j<=i;j++)
        {
            if(node[j].contains(x,y))
            {
                k=i;
                i=j;
                break;
            }
        }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
    i=k;        
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
       if(nodePressed)
        {
            int dx = evt.getX() - x;
            int dy = evt.getY() - y;
  //      Point p = getLocation();
            double x1,y1;
            if(node[i].getBounds().contains(x,y))
            {
                double xc = node[i].getX();
                double yc = node[i].getY();
                x1=node[i].getBounds().getCenterX();
                y1=node[i].getBounds().getCenterY();
                node[i].setFrame(xc+=dx, yc+=dy, w, h);
                for(int j=0;j<=ec;j++)
                {
                    if(edge[j][0]==x1 && edge[j][1]==y1)
                    {
                        edge[j][0]=node[i].getBounds().getCenterX();
                        edge[j][1]=node[i].getBounds().getCenterY();
                    }
                    else if(edge[j][2]==x1 && edge[j][3]==y1)
                    {
                        edge[j][2]=node[i].getBounds().getCenterX();
                        edge[j][3]=node[i].getBounds().getCenterY();
                    }
                }
                jPanel1.repaint();
        }
        x += dx;
        y += dy;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void gen_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gen_matActionPerformed
        int c1,c2;
        jTextArea1.append("MATRIX:-\n------------\n\n");
        for(c1=0;c1<=i;c1++)
        {
            jTextArea1.append("\t"+node_names[c1]);
        }
        jTextArea1.append("\n");
        for(c1=0;c1<=i;c1++)
        {
            jTextArea1.append(node_names[c1]+"\t");
            for(c2=0;c2<=i;c2++)
            {
                jTextArea1.append("  "+graph[c1][c2]+"\t");
            }
            jTextArea1.append("\n");
        }
        jTextArea1.append("\n\n");// TODO add your handling code here:
    }//GEN-LAST:event_gen_matActionPerformed

    private void gen_adjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gen_adjActionPerformed
    int c1,c2;
    Iterator itr;
    
    jTextArea1.append("Adjacency List:-\n-----------------\n\n");
    for(c1=0;c1<=i;c1++)
    {
        itr = adj[c1].iterator();
        jTextArea1.append(node_names[c1]+"");
        while(itr.hasNext())
        {
            jTextArea1.append(" -> "+node_names[(int)itr.next()]);
        }
        jTextArea1.append("\n");
    }
    jTextArea1.append("\n\n");
    // TODO add your handling code here:
    }//GEN-LAST:event_gen_adjActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    int index = algo_select.getSelectedIndex();
    String start_v;
    int v;
    Arrays.fill(outnode,0);
    outnodec=-1;
    switch(index)
    {
       
        case 0: FindCycle_Undirected ob1 = new FindCycle_Undirected();  
                if (ob1.isCyclic())
                    jTextArea2.append("\nGraph contains cycle");
                else
                    jTextArea2.append("\nGraph doesn't contains cycle");
                break;
                
        case 1: Hamiltonian_Cycle ob2= new Hamiltonian_Cycle();
                ob2.hamCycle(graph);
                setoutedge();
                new Output().setVisible(true);
                break;
       
        case 2: BFS ob3 = new BFS();
                start_v = JOptionPane.showInputDialog(jFrame1,"Enter node name");
                v=searchNode(start_v);
                if(v==-1)
                {
                    JOptionPane.showMessageDialog(jFrame1,"Node not found");
                }
                else
                {
                    jTextArea2.append("\nBFS traversal starting from vertex "+start_v+"\n");
                    ob3.BFS1(v);
                }
                setoutedge2();
                new Output2().setVisible(true);
                break;
                
        case 3: DFS1 ob4 = new DFS1();
                start_v = JOptionPane.showInputDialog(jFrame1,"Enter node name");
                v=searchNode(start_v);
                if(v==-1)
                {
                    JOptionPane.showMessageDialog(jFrame1,"Node not found");
                }
                else
                {
                    jTextArea2.append("\nDFS traversal starting from vertex "+start_v+"\n");
                    ob4.DFS(v);
                }
                setoutedge2();
                new Output2().setVisible(true);
                break; 
                
        case 4: new GenTree().setVisible(true);
                break;
               
        case 5: Prims ob5 = new Prims();
                ob5.primMST(wgtmat);
                setoutedge3();
                new Output().setVisible(true);
                break;
                
        case 6: Kruskal ob6 = new Kruskal(i+1,ec+1);
                updateKruskalObject(ob6);
                ob6.KruskalMST();
                setoutedge3();
                new Output().setVisible(true);
                break;
                
        case 7: DijSktra ob7 = new DijSktra();
                start_v = JOptionPane.showInputDialog(jFrame1,"Enter source");
                v=Integer.parseInt(start_v);
                ob7.dijkstra(wgtmat, v);
                break;
                
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void directed_edgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directed_edgeActionPerformed
       edgeFlag=2;
       edgePressed=false;
       nodePressed=false;  
       dedgePressed=true;
       wedgePressed=false;
       undirected_edge.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_directed_edgeActionPerformed

    private void wt_edgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wt_edgeActionPerformed
       edgeFlag=3;
       edgePressed=false;
       nodePressed=false;  
       dedgePressed=false;
       wedgePressed=true;
       undirected_edge.setEnabled(false);
       directed_edge.setEnabled(false);
       
    }//GEN-LAST:event_wt_edgeActionPerformed

    private void gen_wgt_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gen_wgt_matActionPerformed
    int c1,c2;
        jTextArea1.append("WEIGHT MATRIX:-\n------------\n\n");
        for(c1=0;c1<=i;c1++)
        {
            jTextArea1.append("\t"+node_names[c1]);
        }
        jTextArea1.append("\n");
        for(c1=0;c1<=i;c1++)
        {
            jTextArea1.append(node_names[c1]+"\t");
            for(c2=0;c2<=i;c2++)
            {
                jTextArea1.append("  "+wgtmat[c1][c2]+"\t");
            }
            jTextArea1.append("\n");
        }
        jTextArea1.append("\n\n");    // TODO add your handling code here:
    }//GEN-LAST:event_gen_wgt_matActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 initialize();   
 jPanel1.repaint();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(New_interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_interface1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_interface1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> algo_select;
    private javax.swing.JButton directed_edge;
    private javax.swing.JButton gen_adj;
    private javax.swing.JButton gen_mat;
    private javax.swing.JButton gen_wgt_mat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton undirected_edge;
    private javax.swing.JButton wt_edge;
    // End of variables declaration//GEN-END:variables
}
