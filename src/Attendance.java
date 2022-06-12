//Lawrence Liu

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Attendance {
	
	private String last, first, teacher;
	private int grade1;

	
	public Attendance(String u_last, String u_first, int grade2, String u_teacher) {
		last = u_last;
		first = u_first;
		grade1 = grade2;
		teacher = u_teacher;
	}
	
	public String getLast() {
		return last;
	}
	public String getFirst() {
		return first;
	}
	public int getGrade() {
		return grade1;
	}
	public String getTeacher() {
		return teacher;
	}
	public void attend() throws InterruptedException, IOException{
		
		System.out.println("Last: " + last);
		System.out.println("First: " + first);
		System.out.println("Grade: " + grade1);
		System.out.println("Teacher: " + teacher);
		//Opening
		System.setProperty("webdriver.chrome.driver", "/Users/lawrenceliu/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSeHuS8KQZMV3r_opaJ2v8oDW3z3B0V0KDRxrs4dxPER3Zn1pQ/viewform");

		//LastName
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div/div[1]/input"));
		lastName.sendKeys(last);
		
		//FirstName
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[1]/input"));
		firstName.sendKeys(first);
		

		//Grade
		WebElement grade = driver.findElement(By.className("quantumWizMenuPaperselectOptionList"));
		grade.click();
		Actions keyDown = new Actions(driver);
		Thread.sleep(200);
		for (int i = 0; i < grade1+2; i++) {
			keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
			Thread.sleep(25);
		}
		keyDown.sendKeys(Keys.chord(Keys.RETURN)).perform();
		
		//School
		WebElement school = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[2]/div[4]/div/div[2]/div/span/div/div[1]/label/div/div[1]/div"));
		school.click();
		
		//NextPage
		WebElement switchPage = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[3]/div[1]/div/div"));
		switchPage.click();
		Thread.sleep(1000);
		
		
		//Teacher select
		String[] Teachers= new String[]{"Aducci","Aires","Angelo","Antonikas","Bandurski","Barle","Barone","Battista","Baxter","Bennett","Billings","Buches","Burger","Butkovic","Capeck","Coffield","Colvin","Congalton","Cooper","Cowles","Cuda","Deal","Derry","Devlin","Dixon","Dojonovic","Elder","Farino","Finley","Fischer","Gass","Gibson","Gilberti","Grahor","Grana","Green","Guadagni","Hammer","Hetu","Hollern","Hopper","Karavlan","Kirk","Klein","Klipa","Koller","Leasure","Lesnik","MacDowell","Marangoni","Massack","Matonak","Matusiak","McKamish","Meabon","Miller","Modlin","A. Montgomery (French)","M. Montgomery (Art)","Morley","Morris","Moul","Murray","Norberg","O'Connor","Palucis","Papalia","Mr. Papariello","Mrs. Papariello","Patterson","Patrick","Payner","Pazin","Peifer","Polesiak","Reilly","Rios","Sayre","Schubert","Senkoski","Shemanski","Shiner","Skillen","Smith","Sparrow","Sperdute","Studt","Susser","Tabis","Thomas","Tsambis","Ubinger","Ward","Ware","Wickman","Wolfe","Yacamelli","Yanizeski","Zehnder"};
		int index = 0;
	
		for (int i = 0; i<Teachers.length; i++) {
			if (teacher.toUpperCase().equals(Teachers[i].toUpperCase())) {
				index = i;
				//System.out.println("index" + index);
			}
		}
		
		WebElement tL = driver.findElement(By.className("quantumWizMenuPaperselectOptionList"));
		tL.click();
		Thread.sleep(100);
		for (int i = 0; i < index + 1; i++) {
			keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
			Thread.sleep(15);
		}
		keyDown.sendKeys(Keys.chord(Keys.RETURN)).perform();
		
		//Next
		switchPage = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[3]/div[1]/div/div[2]"));
		switchPage.click();
		Thread.sleep(500);
		
		
		//Checkbox
		WebElement cB = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div/label/div/div[1]"));
		cB.click();
		
		//Submit
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[3]/div[1]/div/div[2]"));
		submit.click();
		
		
	}
	
	public static void main(String []args)throws InterruptedException, IOException{
		JFrame frame = new JFrame("Attendance Input");
	    frame.setSize(500,500);
	    frame.setVisible( true );
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 
		/*
		String first = JOptionPane.showInputDialog(null,"Enter first name:");
		String last = JOptionPane.showInputDialog(null,"Enter last name:");
		int grade = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter grade:"));
		String homebase = JOptionPane.showInputDialog(null,"Enter homebase lastname:");
		*/
		GUI temp = new GUI();
		//temp.attend(last, first, grade, homebase);
		
		
	
	}
	
	
}
