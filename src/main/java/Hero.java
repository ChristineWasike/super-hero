import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mName;
    private Integer mAge;
    private String mPower;
    private String mWeakness;
    private boolean mMission;
    private LocalDateTime mCreateAt;

    public Hero(String name, Integer age, String power, String weakness) {
        mName = name;
        mAge = age;
        mPower = power;
        mWeakness = weakness;
        mMission = false;

    }

    public String getName() {
        return mName; //creates superhero's name
    }

    public Integer getAge() {
        return mAge;  //creates superhero's age
    }

    public String getPower() {
        return mPower; //creates superhero's power
    }

    public String getWeakness() {
        return mWeakness;
    }

    public boolean getMission() {
        return mMission;
    }

    public LocalDateTime getCreateAt() {
        return mCreateAt;
    }
}




