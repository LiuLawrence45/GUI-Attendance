import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


//Basis from https://introcs.cs.princeton.edu/java/15inout/GUI.java.html

public class GUI implements ActionListener {
	private int num = 0;
    private JFrame frame = new JFrame();
    private ArrayList<Attendance> students = new ArrayList<Attendance>();
    JButton addStudent;
    JButton displayStudents;
    JButton runStudents;

    public GUI() {

        // the clickable button
        addStudent = new JButton("New Student");
        displayStudents = new JButton("Display Students");
        runStudents = new JButton("Run Students");
        addStudent.addActionListener(this);
        displayStudents.addActionListener(this);
        runStudents.addActionListener(this);
        

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        panel.add(addStudent);
        panel.add(displayStudents);
        panel.add(runStudents);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Attendance");
        frame.pack();
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
    	if (e.getSource() == addStudent) {
    		String first = JOptionPane.showInputDialog(null,"Enter first name:");
    		String last = JOptionPane.showInputDialog(null,"Enter last name:");
    		int grade = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter grade:"));
    		String homebase = JOptionPane.showInputDialog(null,"Enter homebase lastname:");
    		students.add(new Attendance(last,first,grade,homebase));
    		num++;
    		
    	}
    	else if (e.getSource() == displayStudents) {
    		String[] columns = new String[]{"last","first","grade","homebase"};
    		
    		String[][]data = new String[num][4];
    			for (int b = 0; b < num; b++) {
    				data[b][0] = students.get(b).getLast();
    				data[b][1] = students.get(b).getFirst();
    				data[b][2] = Integer.toString((students.get(b).getGrade()));
    				data[b][3] = students.get(b).getTeacher();
    			}
    	   		JTable table = new JTable(data,columns);
    			JFrame tempFrame = new JFrame();

    			 tempFrame.add(new JScrollPane(table));
    		         
    			 tempFrame.setTitle("Table Example");
    			 tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    			 tempFrame.pack();
    			 tempFrame.setVisible(true);
    	}
    	else if (e.getSource() == runStudents) {
    		for (Attendance temp: students) {
    			
    			//what eclipse generated since cant add interruptedexception and ioexception to actionperformed
    			try {
					temp.attend();
				} catch (InterruptedException | IOException e1) {
					e1.printStackTrace();
				}
    		}
    	}
    	
    }

    // create one Frame
    public static void main(String[] args) {
        new GUI();
    }
}
