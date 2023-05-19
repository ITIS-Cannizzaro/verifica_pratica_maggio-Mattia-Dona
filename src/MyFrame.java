import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class MyFrame extends JFrame implements ActionListener{
	JFrame j1=new JFrame();
	JFrame j2=new JFrame();
	JLabel a=new JLabel("Inserisci un numero");
	JLabel a1=new JLabel("Inserisci un numero");
	JTextArea in=new JTextArea();
	JTextArea in1=new JTextArea();
	JTextArea ris=new JTextArea();
	JTextArea ris1=new JTextArea();
	JTextArea ris2=new JTextArea();
	JButton add=new JButton("Aggiungi");
	JButton remove=new JButton("Rimuovi");
	JButton remove1=new JButton("Rimuovi");
	JButton view=new JButton("Visualizza");
	ArrayList vett=new ArrayList();
	public MyFrame() 
	{
	   j1.setLayout(null);
	   j2.setLayout(null);
	   j1.add(a);
	   a.setBounds(100, 10, 500, 30);
	   j1.add(in);
	   in.setBounds(700, 10, 200, 30);
	   j1.add(add);
	   add.addActionListener(e -> Add());
	   add.setBounds(100, 100, 300, 30);
	   j1.add(remove);
	   remove.addActionListener(e -> rim());
	   remove.setBounds(500, 100, 300, 30);
	   j1.add(view);
	   view.addActionListener(e -> Stampa());
	   view.setBounds(900, 100, 300, 30);
	   j1.add(ris);
	   ris.setBounds(750, 200, 500, 500);
	   vett=new ArrayList<Integer>();
	   j1.setVisible(true);
	   j2.add(a1);
	   a1.setBounds(100, 10, 500, 30);
	   j2.add(in1);
	   in1.setBounds(700, 10, 200, 30);
	   j2.add(remove1);
	   remove1.addActionListener(e -> rim1());
	   remove1.setBounds(500, 100, 300, 30);
	   j2.add(ris1);
	   ris1.setBounds(550, 200, 500, 500);
	   
	}
	
	public int prendi(int i) 
	{
		 return (int) vett.get(i);
	}
	public void Add() 
	{
		int num=Integer.parseInt(in.getText());
		vett.add(num);
		int temp=0; 
		for(int i=0; i<vett.size(); i++)
		{
			for(int j=0; j<vett.size()-1; j++)
			{
				if(prendi(j)>prendi(j+1))
				{
					temp=prendi(j);
					vett.set(j, vett.get(j+1));
					vett.set(j+1, temp);
				}
			}
		}
		
	}
	
	public void Stampa() 
	{
		String k=" ";
		for(int i=0; i<vett.size(); i++)
		{
			k=k + vett.get(i) + " ";
		}
		ris.setText(k);
	}
	
	public void rim() 
	{
		j2.setVisible(true);
		
		
	}
	public void rim1() 
	{
		int c=0;
		int num=Integer.parseInt(in1.getText());
		for(int i=0; i<vett.size(); i++)
		{
			if(num==prendi(i))
			{
				vett.remove(i);
				c++;
				if(i!=0){
				i--;	
				}
			}
		}
		String q=" ";
		for(int i=0; i<vett.size(); i++)
		{
			q=q+vett.get(i)+" ";
		}
		ris2.setText(q);
		if(c==0)
		{
			ris1.setText("numero non presente: Array Aggiornato \n " + q);
		}
		else {
			ris1.setText(q);
			
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==add)
		{
			Add();
		}
		
		if(e.getSource()==remove)
		{
			rim();
		}
		
		if(e.getSource()==view)
		{
			Stampa();
		}

	}
}
