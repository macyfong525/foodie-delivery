package com.example.foodiedelivery.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodiedelivery.models.User;

import java.util.List;
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUsers(User...users);

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    Long[] insertUsersFromList(List<User> users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneUser(User user);

    @Query("SELECT * FROM users")
    List<User> GetAllUsers();

    @Delete
    int deleteOneUser(User user);

    @Delete
    int deleteUsersFromList(List<User> users);

    @Query("DELETE FROM users")
    void deleteAllUsers();

    @Query("DELETE FROM users WHERE id = :UserId")
    int deleteUserWithId(int UserId);
}
