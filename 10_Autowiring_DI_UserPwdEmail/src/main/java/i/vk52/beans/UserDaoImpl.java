package i.vk52.beans;

public class UserDaoImpl implements IUserDao {

	@Override
	public void saveUser() {
		// DB connection logics
		System.out.println("User Details Saved");
	}

}
