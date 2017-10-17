/*
 * ���ߣ�miyar chen��
 */
package baidu;

import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baidu.InitDriver;
import baidu.Baidu;

public class BaiduMain extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void launchFrame(){
		this.setSize(300, 300);//���ÿ�Ⱥ͸߶�
		this.setLocation(700, 466);//���ó�ʼλ��
		this.setVisible(true);//���ÿɼ�
		this.setTitle("�����ѡ��");
		JLabel label = new JLabel("���������������");
		//JTextField textField = new JTextField();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton submit = new JButton("�ύ");
		//panel.add(textField);
		panel.add(label);
		panel.add(submit);
		getContentPane().add(panel);
	}
	
	public static void main(String args[]) {
		WebDriver driver = null;
		String url="http://www.baidu.com";
		//String driverName="Firefox";
		//String driverName="Chrome";
		//String driverName="IE";
		String driverName;
		
		new BaiduMain().launchFrame();
		
		System.out.println("��ѡ����������Firefox Chrome IE");
		System.out.print("���������������:");
		
		Scanner str = new Scanner(System.in);
		driverName=str.next();		
		driverName=driverName.intern();//����ַ��������Ƿ����driverName��ֵ��������ڣ��ͷ��س�����ַ�������������ڣ��÷����� ��driverName��ֵ��ӵ��ַ������У�Ȼ���ٷ�����������
		
	    InitDriver initDriver = new InitDriver();
	    driver=initDriver.startExplorer(driver, driverName, url);
	    
	    str.close();
	    
	    WebElement element = driver.findElement(By.id("kw"));
	    element.sendKeys("selenium");
	    WebElement element_submit = driver.findElement(By.id("su"));
	    element_submit.click();
	    
	    WebElement element_set = driver.findElement(By.linkText("����"));
	    element_set.click();
	   // Baidu bd = new Baidu();
	   // bd.baiduSearch(driver);
	    
	    initDriver.closeExplorer(driver);
	    System.out.println("success!");
	}
}
