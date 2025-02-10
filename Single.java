import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

class UserService {
    String name;
}

public class Single {
    private volatile static UserService userService = null;

    private Single() {
    }

    public UserService getUserService() {
        if (userService == null) {
            synchronized (Single.class) {
                if (userService == null) {
                    userService = new UserService();
                }
            }
        }
        return userService;
    }

    public static void main(String[] args) {

    }
}
