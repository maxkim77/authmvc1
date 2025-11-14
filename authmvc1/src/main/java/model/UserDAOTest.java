package model;

public class UserDAOTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		String id = "DCU1234";
		String password = "ghdrlfehd1!";
		
		UserBean user = dao.login(id, password);
		
		if (user!=null)
		{
			System.out.println("로그인 성공!");
			System.out.println("ID:" + user.getId());
			System.out.println("ID:" + user.getUsername());
		}else {			
			System.out.println("로그인 실패!");
		}
		
	}
}
