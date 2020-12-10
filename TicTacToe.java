//TicTacToe by Prashant!
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class TicTacToe extends JFrame implements ActionListener
{
JButton b[]=new JButton[10];
TextField tf,tf1;
JLabel l1,l2;
Button start,cancel;
JFrame jf;
int flag=0,count=0,l=0;
int c[]=new int[10];
Icon i=new ImageIcon("C:\\Users\\Prashant\\Documents\\Java programs\\TicTacToe\\ic2.jpg");
Icon i1=new ImageIcon("C:\\Users\\Prashant\\Documents\\Java programs\\TicTacToe\\ic1.jpg");
TicTacToe()
{
super("TicTacToe by prashant");
lookandfeel();
opening();
setLayout(null);
setVisible(true);
addWindowListener(new Rohit());
}

public void lookandfeel()
{
try
{
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch(Exception e){}
}

public void opening()
{
l1=new JLabel("Enter your Name");
l1.setBounds(10,30,100,25);
add(l1);
tf=new TextField("");
tf.setBounds(120,30,100,25);
add(tf);
l2=new JLabel("Enter Friends Name");
l2.setBounds(10,80,100,30);
add(l2);
tf1=new TextField("");
tf1.setBounds(120,80,100,25);
add(tf1);
start=new Button("start");
start.setBounds(60,130,50,35);
add(start);
start.addActionListener(this);
cancel=new Button("cancel");
cancel.setBounds(120,130,50,35);
cancel.addActionListener(this);
add(cancel);
setSize(257,280);
setLayout(null);
setVisible(true);
}

public void welcome()
{
jf=new JFrame("REAL ONE");
jf.setBounds(250,250,257,305);
for(int i=1,j=0,k=0;i<10;i++,j+=80)
{
if(i>3 && (i-1)%3==0)
{
k+=80;j=0;
}
b[i]=new JButton();
b[i].setBounds(j,k,80,80);
b[i].addActionListener(this);
jf.add(b[i]);
c[i]=-1;
}
jf.setLayout(null);
jf.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==start)
{
welcome();
Label a=new Label(tf.getText());
Label mid=new Label("VS");
mid.setBounds(105,250,25,15);
Label a1=new Label(tf1.getText());
a.setBounds(50,250,50,15);
a1.setBounds(150,250,60,15);
Font displayFont = new Font("Serif", Font.BOLD, 18);
mid.setFont(displayFont);
jf.add(a);
jf.add(a1);
jf.add(mid);
}
if(ae.getSource()==cancel)
{
reset();
}
for(int j=1;j<10;j++)
{
if(ae.getSource()==b[j])
{
if(c[j]==-1)
{
if(flag==1)
{
b[j].setIcon(i);
c[j]=1;flag=0;count++;
}
else
{
b[j].setIcon(i1);
flag=1;
c[j]=2;count++;
}
if(count>4)
{
for(int k=1;k<10;k++)
{
if(k==1||k==4||k==7)
{
if((c[k]==1&&c[k+1]==1&&c[k+2]==1&&l==0)||(c[k]==2&&c[k+1]==2&&c[k+2]==2&&l==0))
{
JOptionPane.showMessageDialog(jf,"VICTORY");
l=1;
}
}
if(k==1||k==2||k==3)
{
if((c[k]==1&&c[k+3]==1&&c[k+6]==1&&l==0)||(c[k]==2&&c[k+3]==2&&c[k+6]==2&&l==0))
{
JOptionPane.showMessageDialog(jf,"VICTORY");
l=1;
}
}
}
}}}}
if((c[1]==1&&c[5]==1&&c[9]==1&&l==0)||(c[1]==2&&c[5]==2&&c[9]==2&&l==0)||(c[3]==1&&c[5]==1&&c[7]==1&&l==0)||(c[3]==2&&c[5]==2&&c[7]==2&&l==0))
{
JOptionPane.showMessageDialog(jf,"VICTORY!");
l=1;
}
if(l==0&&count==9)
{
JOptionPane.showMessageDialog(jf,"DRAW!");
}
}
void reset()
{
for(int i=1;i<10;i++){
c[i]=-1;
b[i].setIcon(null);
}count=0;l=0;
}


public static void main(String...s)
{
new TicTacToe();
}
}

class Rohit extends WindowAdapter
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
}