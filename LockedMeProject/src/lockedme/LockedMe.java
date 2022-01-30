package lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe
{
	
	static final String projectFilesPath = "D:\\lockmeproject";
	static final String errorMessage = "error occured in the function please contact : lockedme@admin.com";

	public static void main(String[] args)
	
	{
		Scanner obj = new Scanner(System.in);
		int ch;
		
	do
		{
			displayMenu();
			System.out.println("Enter The Chocice From Menu");
			ch = Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
			case 1:getAllFiles();
			break;
			case 2:createFiles();
			break;
			case 3:deleteFiles();
			break;
			case 4:searchFiles();
			break;
			case 5:System.exit(0);
			break;
			default:System.out.println("no option exists");
			break;
			}
		
		}
	while(ch>0);
			obj.close();
		}

	/**
	 * this function will display menu options for the program
	*/

	public static void displayMenu()
{
		System.out.println("**************************************************************************");
		System.out.println("\t\t <<<<< Welcome To LockedMe.com >>>>>");
		System.out.println("\t\t\t\t\t Created By Akhila.V");
		System.out.println("**************************************************************************");
		System.out.println("\t\t **TABLE OF CONTENT**");
		System.out.println("\t\t1.Display all the files");
		System.out.println("\t\t2.Add a new file");
		System.out.println("\t\t3.Delete a file");
		System.out.println("\t\t4.Search a file");
		System.out.println("\t\t5.exit");
	
}
	

/**
 * this function will return files from the directory
 */
  
	public static void getAllFiles()
	{
		try
		{
			File folder = new File(projectFilesPath);
			File[] listofFiles = folder.listFiles();
		if(listofFiles.length==0)
			System.out.println("No file exist in the directory");
		else
		{
			for(var l:listofFiles)
			{
				System.out.println(l.getName());
			}
		}
		}
		
		catch(Exception Ex)
		{
			System.out.println("errorMessage");
			
		}
		
				
	}
	
	/**
	 * this function will create files and add to the directory
	 */
	public static void createFiles()
	{
		try
		{
			Scanner obj=new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name");
			fileName= obj.nextLine();
			
			int lineCount;
			System.out.println("enter how many lines expected in the file:");
			
			lineCount = Integer.parseInt(obj.nextLine());
			FileWriter myWriter = new FileWriter(projectFilesPath+"\\"+fileName);
			for(int i=1;i<=lineCount;i++)
			{
				System.out.println("Enter the file line");
				myWriter.write(obj.nextLine()+"\n");
			}
			System.out.println("File created succesfully");
			myWriter.close();
			obj.close();
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
			
		}
						
		}
	
	/**
	 * this function will delete files from the directory
	 */
	public static void deleteFiles()
	{
		Scanner obj= new Scanner(System.in);
		try 
		{
			String fileName;
			System.out.println("enter the file name to be deleted:");
			fileName = obj.nextLine();
			File file = new File(projectFilesPath+ "\\"+fileName);
			
			if (file.exists())
			{
				file.delete();
				System.out.println("file deleted succesfully");
			}
			else
			{
				System.out.println("file donot exist");
			}
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
			
		}
	
	}
/**
* this function will search a specific file from the directory
*/
	
	public static void searchFiles()
	
	{
		Scanner obj= new Scanner(System.in);
		
		try
		{
			String fileName;
			System.out.println("enter the file name to be searched");
			fileName = obj.nextLine();
			
			File folder = new File(projectFilesPath);
			File[] listofFiles = folder.listFiles();
			
			LinkedList<String> filenames = new LinkedList<String>();
			
			for(var l:listofFiles)
				filenames.add(l.getName());
			
			if(filenames.contains(fileName))
				System.out.println("file is available in the folder");
			
			else
			System.out.println("file is not available in the folder");
			}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
			
		}
	
	}
	
}