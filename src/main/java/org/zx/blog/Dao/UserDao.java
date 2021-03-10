package org.zx.blog.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zx.blog.Model.User;

import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findByName(String name);
    List<User> findByNameAndEmail(String name, String eamil);
    List<User> findByNameAndEmailOrderByIDDesc(String name, String email);
    List<User> findTop2ByNameAndEmailOrderByIDDesc(String name, String email);

}
