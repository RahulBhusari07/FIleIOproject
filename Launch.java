import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Launch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(
					"P1->CreateFile\nP2->ShowAllFiles\nP3->ShowFilesbyName\nP4->OpenFilebyName\nP5->DeleteFilebyName\nP6->Restore\nP7->DeleteAll\nP8->EXIT");
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();
			if (choice == 8) {
				System.out.println("THANKS FOR USING");
				break;
			}
			switch (choice) {
			case 1:
				String result = createFile();
				System.out.println(result);

				break;
			case 2:
				ArrayList<String> showAllFiles = showAllFiles();
				System.out.println();
				for (String filename : showAllFiles) {
					System.out.println(filename);
				}
				System.out.println();
				break;
			case 3:
				String showFilesbyName = showFilesbyName();
				System.out.println(showFilesbyName);

				break;
			case 4:
				openFilebyName();
				break;
			case 5:
				String deleteFilebyName = deleteFilebyName();
				System.out.println(deleteFilebyName);
				break;
			case 6:
				String restore = restore();
				System.out.println(restore);
				break;
			case 7:
				deleteAll();
				break;
			default:
				break;

			}// end of switch

		} // end of while

	}// end of main

	private static void deleteAll() {

		String path = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio";
		File file = new File(path);
		File[] listFiles = file.listFiles();

		for (File f : listFiles) {
			f.delete();
		}
		System.out.println(" All File Deleted Succesfully");

	}

	private static String restore() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter File Name to be restored");
			String filename = sc.next();
			String source = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio\\backup" + File.separator + filename;
			String destination = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio" + File.separator + filename;

			File file = new File(source);
			boolean exists = file.exists();
			if (exists) {
				// restore logic
				FileReader fileReader = new FileReader(source);
				fr = fileReader;
				fw = new FileWriter(destination);
				int temp = 0;
				while (true) {
					temp = fr.read();
					if (temp == -1) {
						break;
					}
					fw.write(temp);
				}

				fr.close();
				fw.close();
				// delete
				new File(source).delete();
				return "file restored";

			} else {
				return "File not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went Wrong";

		} finally {
			if (fr != null && fw != null) {
				try {
					fr.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}

	private static String deleteFilebyName() {

		try {
			String result = showFilesbyName();
			if (result.endsWith(".txt")) {
				String source = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio" + File.separator + result;
				backup(result);
				File file = new File(source);
				boolean delete = file.delete();
				if (delete) {
					return "File Deleted Succesully";
				} else {
					return "File is still in open condition";
				}
			} else {
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "File is still in open condition";
		}
	}

	private static void backup(String result) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			String source = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio" + File.separator + result;
			String destination = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio\\backup" + File.separator + result;
			fr = new FileReader(source);
			fw = new FileWriter(destination);
			int temp = 0;
			while (true) {
				temp = fr.read();
				if (temp == -1) {
					break;
				}
				fw.write(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null && fw != null) {
				try {
					fr.close();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	private static void openFilebyName() {
		FileReader fr = null;
		try {
			String result = showFilesbyName();
			if (result.endsWith(".txt")) {
				String path = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio" + File.separator + result;
				fr = new FileReader(path);
				int temp = 0;
				while (true) {
					temp = fr.read();
					if (temp == -1) {
						break;
					}
					System.out.print((char) temp);

				}
				System.out.println();
			} else {
				System.err.println(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}

	private static String showFilesbyName() {
		try {
			// iterate and give file by name starts with ->a
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter File Name");
			String filename = sc.next();
			ArrayList<String> showAllFiles = showAllFiles();
			int indexOf = showAllFiles.indexOf(filename);
			if (indexOf != -1) {
				String getfile = showAllFiles.get(indexOf);
				System.out.println("Your File Is Avaliable");
				return getfile;
			} else {
				return "File not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went Wrong";
		}

	}

	private static ArrayList<String> showAllFiles() {
		ArrayList<String> namelist = new ArrayList<String>();
		String path = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio";
		File file = new File(path);
		File[] listFiles = file.listFiles();

		for (File f : listFiles) {
			namelist.add(f.getName());
		}

		return namelist;
	}

	private static String createFile() {

		try {
			String path = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio";

			Scanner sc = new Scanner(System.in);
			System.out.println("********CREATE FILE********");

			System.out.println("Enter File Name");
			String filename = sc.next();

			path = "C:\\Users\\rahul\\OneDrive\\Desktop\\databaseio" + File.separator + filename;
			File file = new File(path);
			boolean newFile = file.createNewFile();
			if (newFile) {
				return "File Created Successfully";
			} else {
				return "File Already Exist";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went Wrong";
		}

	}

}
