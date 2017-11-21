package requestBeans;

import java.io.IOException;
import java.net.SocketException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;

@ManagedBean(name = "ftpbean")
@RequestScoped
public class FtpBean {

	private Part file = null;
	private String server = "127.0.0.1";
	private Integer port = 21;
	private String user = "test";
	private String pass = "test";
	private FTPClient ftpClient = new FTPClient();
	private String usr = "L'utilisateur";
	private String up = "a envoyé le fichier";
	private String dw = "a telechargé le fichier";;
	private FTPFile[] result = null;

	@PostConstruct
	public void init() {
		try {

			ftpClient.connect(server, port);

			ftpClient.login(user, pass);

			ftpClient.enterLocalPassiveMode();

			String dirToSearch = ftpClient.printWorkingDirectory();

			FTPFileFilter filter = new FTPFileFilter() {

				@Override
				public boolean accept(FTPFile ftpFile) {

					return (ftpFile.isFile());
				}
			};

			result = ftpClient.listFiles(dirToSearch, filter);

			ftpClient.logout();

			ftpClient.disconnect();

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		System.out.println("list OK");
	}

	public void upload() throws SocketException, IOException, InstantiationException, IllegalAccessException {

		ftpClient.connect(server, port);
		ftpClient.login(user, pass);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		System.out.println("Start uploading file");
		ftpClient.storeFile(getFilename(file), file.getInputStream());
		ftpClient.logout();
		ftpClient.disconnect();
	}

	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public FTPFile[] getResult() {
		return result;
	}

	public void setResult(FTPFile[] result) {
		this.result = result;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

}
