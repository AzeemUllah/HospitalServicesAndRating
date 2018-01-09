package hospital.hospital.ChatResources;

/**
 * Created by syeda on 1/9/2018.
 */

public class ChatData {
    private String message, profilePic, time, name;

    public ChatData() {
    }

    public ChatData(String message, String profilePic, String time, String name) {
        this.message = message;
        this.profilePic = profilePic;
        this.time = time;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String time) {
        this.name = name;
    }
}
